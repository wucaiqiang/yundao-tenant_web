package com.yundao.tenant.web.service.customer.imports.impl;

import com.yundao.core.code.Result;
import com.yundao.core.excel.ExcelUtils;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.ConfigUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.core.utils.RegularUtils;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.constant.DicCode;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.common.LabelValueDto;
import com.yundao.tenant.web.dto.customer.imports.*;
import com.yundao.tenant.web.dto.dictionary.DictionaryDto;
import com.yundao.tenant.web.enums.customer.CustomerStatusEnum;
import com.yundao.tenant.web.service.customer.imports.CustomerImportService;
import com.yundao.tenant.web.service.dictionary.DictionaryService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import com.yundao.tenant.web.util.LambdaFilter;
import com.yundao.tenant.web.util.SymbolUtils;
import com.yundao.tenant.web.util.access.AccessCommon;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.*;

/**
 * 客户导入服务实现
 *
 * @author jan
 * @create 2017-08-31 PM5:04
 **/
@Service
public class CustomerImportServiceImpl implements CustomerImportService {

    private static Log log = LogFactory.getLog(CustomerImportServiceImpl.class);

    @Autowired
    private DictionaryService dictionaryService;

    @Override
    public Result<Object> importFromCustomer(HttpServletResponse response, MultipartFile file) throws Exception {
        return this.importCustomer(response, file, false);
    }

    @Override
    public Result<Object> importFromOpensea(HttpServletResponse response, MultipartFile file) throws Exception {
        return this.importCustomer(response, file, true);
    }

    public Result<Object> importCustomer(HttpServletResponse response, MultipartFile file, boolean opensea) throws
            Exception {
        String rowCountStr = ConfigUtils.getValue("customer.import.column.count");
        if (BooleanUtils.isEmpty(rowCountStr))
            throw new BaseException(CodeConstant.CODE_900016);

        int rowCount = Integer.valueOf(rowCountStr);
        List<Map<Integer, String>> excelContents = ExcelUtils.readExcel(file.getOriginalFilename(), file.getInputStream
                ());
        if (excelContents == null)
            return Result.newFailureResult(CodeConstant.CODE_900010);

        List<Map<Integer, String>> contents = filterEmptyRow(rowCount, excelContents);

        ImportResultDto result = new ImportResultDto();
        int size = contents != null ? contents.size() : 0;
        int contentSize = size - 1; //需要导入的数据条数，不包括表头
        result.setTotal(contentSize);
        if (contentSize < 1) {
            return Result.newFailureResult(CodeConstant.CODE_900011);
        }

        //判断模板格式
        Map<Integer, String> contentMap = contents.get(0);

        ImportRowNameDto rowNameDto = this.getRowNameDto();

        checkTemplateFormat(contentMap, rowNameDto);

        ImportRowIndexDto rowIndexDto = this.getRowIndexDto(contentMap, rowNameDto);

        Integer limitCount = Integer.valueOf(ConfigUtils.getValue("customer.import.limit.count"));
        if (size - 1 > limitCount) {
            return Result.newFailureResult(CodeConstant.CODE_900013, "每次最多只能上传" + limitCount.toString() + "个客户");
        }

        if (isExistRepeatMobile(contents, rowIndexDto.getMobileIndex())) {
            return Result.newFailureResult(CodeConstant.CODE_900014);
        }

        List<CustomerImportDto> customers = new ArrayList<>();
        List<String> existCustomers = this.getExistCustomers(this.getMobiles(contents, size, rowIndexDto.getMobileIndex()));
        List<ImportExcelDto> excels = new ArrayList<>();
        String validText = ConfigUtils.getValue("customer.import.valid.text");
        String validUnknownText = ConfigUtils.getValue("customer.import.valid.unknown.text");
        List<ImportAlertDto> alerts = new LinkedList<>();
        List<String> dics = new ArrayList<>();
        dics.add(DicCode.DIC_CUSTOMER_LEVEL);
        dics.add(DicCode.DIC_CUSTOMER_SOURCE);
        dics.add(DicCode.DIC_CUSTOMER_CREDENTIALS);
        dics.add(DicCode.DIC_SEX);
        dics.add(DicCode.PRODUCT_TYPE);
        List<DictionaryDto> dictionaryDtos = dictionaryService.gets(SymbolUtils.toStr(dics)).getResult();
        for (int i = 0; i < size; i++) {
            // 跳过表头
            if (i == 0 || isRowEmpty(contents.get(i)))
                continue;
            processCore(contents, customers, existCustomers, excels, alerts, i, rowIndexDto, validText,
                    validUnknownText, dictionaryDtos);
        }

        result.setSuccessCount(customers.size());
        result.setFailureCount(result.getTotal() - customers.size());
        Result<Object> postResult = new Result<>();
        if (customers.size() > 0) {
            String url = opensea ? TenantUrl.CUSTOMER_IMPORT_MULTI_IMPORT_FROM_OPENSEA : TenantUrl.CUSTOMER_IMPORT_MULTI_IMPORT_V2;
            postResult = HttpUtils.post(url, ArgsUtils.toIdMap(JsonUtils.objectToJson(customers), "mobiles"),
                    new BaseTypeReference<Result<Object>>() {
                    });
        }

        if (postResult.getSuccess()) {
            if (alerts.size() > 0) {
                setErrorAlert(excels, alerts);
                String filePath = com.yundao.tenant.web.util.file.ExcelUtils.export(response, excels, rowNameDto);
                result.setFilePath(filePath);
                String errAlertStr;
                if (contentSize == alerts.size())
                    errAlertStr = "文件已上传，但数据导入失败，结果请查看excel文件";
                else
                    errAlertStr = "文件已上传，但部分数据导入失败，结果请查看excel文件";

                return Result.newResult(true, errAlertStr, result);
            } else {
                return Result.newSuccessResult(result);
            }

        } else {
            log.info("插入数据失败：" + postResult.getMessage());
            return postResult;
        }
    }

    private ImportRowIndexDto getRowIndexDto(Map<Integer, String> contentMap, ImportRowNameDto rowNameDto) {
        ImportRowIndexDto rowIndexDto = new ImportRowIndexDto();
        Map<String, Integer> map = new HashMap<>();
        for (Map.Entry<Integer, String> entry : contentMap.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        rowIndexDto.setNameIndex(map.get(rowNameDto.getName()));
        rowIndexDto.setMobileIndex(map.get(rowNameDto.getMobile()));
        rowIndexDto.setSexIndex(map.get(rowNameDto.getSex()));
        rowIndexDto.setWechatIndex(map.get(rowNameDto.getWechat()));
        rowIndexDto.setEmailIndex(map.get(rowNameDto.getEmail()));
        rowIndexDto.setValidIndex(map.get(rowNameDto.getStatus()));
        rowIndexDto.setRemarkIndex(map.get(rowNameDto.getRemark()));
        rowIndexDto.setLevelIndex(map.get(rowNameDto.getLevel()));
        rowIndexDto.setTagIndex(map.get(rowNameDto.getTag()));
        rowIndexDto.setSourceIndex(map.get(rowNameDto.getSource()));
        rowIndexDto.setCredentialsTypeIndex(map.get(rowNameDto.getCredentialsType()));
        rowIndexDto.setCredentialsNumberIndex(map.get(rowNameDto.getCredentialsNumber()));
        rowIndexDto.setProvinceIndex(map.get(rowNameDto.getProvince()));
        rowIndexDto.setCitykIndex(map.get(rowNameDto.getCity()));
        rowIndexDto.setAddresskIndex(map.get(rowNameDto.getAddress()));
        rowIndexDto.setTradekIndex(map.get(rowNameDto.getTrade()));
        rowIndexDto.setOrganizationkIndex(map.get(rowNameDto.getOrganization()));
        rowIndexDto.setPositionIndex(map.get(rowNameDto.getPosition()));
        rowIndexDto.setQqIndex(map.get(rowNameDto.getQq()));
        rowIndexDto.setBankAccountIndex(map.get(rowNameDto.getBankAccount()));
        rowIndexDto.setBankNameIndex(map.get(rowNameDto.getBankName()));
        return rowIndexDto;
    }

    private Map<Integer, String> checkTemplateFormat(Map<Integer, String> tableHeader, ImportRowNameDto rowNameDto) throws BaseException {
        Field[] fields = rowNameDto.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object fieldValue = AccessCommon.getFieldValue(rowNameDto, field);
            boolean isExist = false;
            for (Map.Entry<Integer, String> entry : tableHeader.entrySet()) {
                if (fieldValue.toString().equals(entry.getValue())) {
                    isExist = true;
                    continue;
                }
            }
            if (!isExist)
                throw new BaseException(CodeConstant.CODE_900012);
        }
        return tableHeader;
    }

    private ImportRowNameDto getRowNameDto() throws BaseException {
        ImportRowNameDto rowNameDto = new ImportRowNameDto();
        rowNameDto.setName(ConfigUtils.getValue("customer.import.column.name"));
        rowNameDto.setMobile(ConfigUtils.getValue("customer.import.column.mobile"));
        rowNameDto.setSex(ConfigUtils.getValue("customer.import.column.sex"));
        rowNameDto.setWechat(ConfigUtils.getValue("customer.import.column.wechat"));
        rowNameDto.setEmail(ConfigUtils.getValue("customer.import.column.email"));
        rowNameDto.setStatus(ConfigUtils.getValue("customer.import.column.valid"));
        rowNameDto.setRemark(ConfigUtils.getValue("customer.import.column.remark"));
        rowNameDto.setLevel(ConfigUtils.getValue("customer.import.column.level"));
        rowNameDto.setTag(ConfigUtils.getValue("customer.import.column.tag"));
        rowNameDto.setSource(ConfigUtils.getValue("customer.import.column.source"));
        rowNameDto.setCredentialsType(ConfigUtils.getValue("customer.import.column.credentialsType"));
        rowNameDto.setCredentialsNumber(ConfigUtils.getValue("customer.import.column.credentialsNumber"));
        rowNameDto.setProvince(ConfigUtils.getValue("customer.import.column.province"));
        rowNameDto.setCity(ConfigUtils.getValue("customer.import.column.city"));
        rowNameDto.setAddress(ConfigUtils.getValue("customer.import.column.address"));
        rowNameDto.setTrade(ConfigUtils.getValue("customer.import.column.trade"));
        rowNameDto.setOrganization(ConfigUtils.getValue("customer.import.column.organization"));
        rowNameDto.setPosition(ConfigUtils.getValue("customer.import.column.position"));
        rowNameDto.setQq(ConfigUtils.getValue("customer.import.column.qq"));
        rowNameDto.setBankAccount(ConfigUtils.getValue("customer.import.column.bankAccount"));
        rowNameDto.setBankName(ConfigUtils.getValue("customer.import.column.bankName"));

        Field[] fields = rowNameDto.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (AccessCommon.getFieldValue(rowNameDto, field) == null)
                throw new BaseException(CodeConstant.CODE_900012);
        }
        return rowNameDto;
    }

    /**
     * 过滤空的行
     */
    private List<Map<Integer, String>> filterEmptyRow(int rowFieldNum, List<Map<Integer, String>> excelContents) {
        List<Map<Integer, String>> contents = new ArrayList<>();
        for (int i = 0; i < excelContents.size(); i++) {
            Map<Integer, String> content = excelContents.get(i);
            if (i == 0) {
                contents.add(content);
                continue;
            }
            boolean isEmpty = true;
            for (int j = 0; j < rowFieldNum; j++) {
                if (BooleanUtils.isNotEmpty(content.get(j))) {
                    isEmpty = false;
                    continue;
                }
            }
            if (!isEmpty)
                contents.add(content);
        }
        return contents;
    }

    private void processCore(List<Map<Integer, String>> contents, List<CustomerImportDto> customers, List<String> existCustomers, List<ImportExcelDto> excels, List<ImportAlertDto> alerts, int index, ImportRowIndexDto indexDto, String validText, String validUnknownText, List<DictionaryDto> dictionaryDtos) throws Exception {
        ImportAlertDto alert = new ImportAlertDto();
        ImportExcelDto excel = new ImportExcelDto();
        Map<Integer, String> content = contents.get(index);
        CustomerImportDto model = new CustomerImportDto();

        boolean isPass = true;
        alert.setRowNumber(index);
        excel.setRowNumber(index);
        excel.setName(content.get(indexDto.getNameIndex()));
        excel.setMobile(content.get(indexDto.getMobileIndex()));
        excel.setSex(content.get(indexDto.getSexIndex()));
        excel.setWechat(content.get(indexDto.getWechatIndex()));
        excel.setStatus(content.get(indexDto.getValidIndex()));
        excel.setEmail(content.get(indexDto.getEmailIndex()));
        excel.setRemark(content.get(indexDto.getRemarkIndex()));
        excel.setLevel(content.get(indexDto.getLevelIndex()));
        excel.setTag(content.get(indexDto.getTagIndex()));
        excel.setSource(content.get(indexDto.getSourceIndex()));
        excel.setCredentialsType(content.get(indexDto.getCredentialsTypeIndex()));
        excel.setCredentialsNumber(content.get(indexDto.getCredentialsNumberIndex()));
        excel.setProvince(content.get(indexDto.getProvinceIndex()));
        excel.setCity(content.get(indexDto.getCitykIndex()));
        excel.setAddress(content.get(indexDto.getAddresskIndex()));
        excel.setTrade(content.get(indexDto.getTradekIndex()));
        excel.setOrganization(content.get(indexDto.getOrganizationkIndex()));
        excel.setPosition(content.get(indexDto.getPositionIndex()));
        excel.setQq(content.get(indexDto.getQqIndex()));
        excel.setBankAccount(content.get(indexDto.getBankAccountIndex()));
        excel.setBankName(content.get(indexDto.getBankNameIndex()));

        /** 姓名 **/
        if (StringUtils.isBlank(excel.getName())) {
            alert.setNameAlert("客户姓名 不能为空；");
            isPass = false;
        }
        model.setName(excel.getName());

        /** 性别 **/
        if (BooleanUtils.isNotBlank(excel.getSex())) {
            DictionaryDto sexDic = LambdaFilter.firstOrDefault(dictionaryDtos, m -> m.getValue().equals(DicCode.DIC_SEX));
            if (sexDic != null) {
                LabelValueDto labelValueDto = LambdaFilter.firstOrDefault(sexDic.getSelections(), m -> m.getLabel()
                        .equals(excel.getSex()));
                if (labelValueDto != null) {
                    model.setSex(labelValueDto.getValue());
                }
            }
        }

        /** 手机号码 **/
        String mobile = excel.getMobile();
        if (StringUtils.isBlank(mobile)) {
            alert.setMobileAlert("手机号码 不能为空；");
            isPass = false;
        } else {
            if (!RegularUtils.isMatch(mobile, RegularUtils.Regular.NUMBER) || mobile.length() < 6 || mobile.length()
                    > 20) {
                alert.setMobileAlert("手机号码格式有误；");
                isPass = false;
            } else {
                if (isExist(existCustomers, mobile)) {
                    alert.setMobileAlert("手机号码已存在；");
                    isPass = false;
                }
            }
        }
        model.setMobile(mobile);
        /** 有效性 **/
        if (BooleanUtils.isBlank(excel.getStatus())) {
            model.setStatus(CustomerStatusEnum.UNCONFIRMED.getValue().toString()); //未确认
        } else {
            if (excel.getStatus().equals(validText)) {
                model.setStatus(CustomerStatusEnum.VALID.getValue().toString());
            } else if (excel.getStatus().equals(validUnknownText)) {
                model.setStatus(CustomerStatusEnum.UNCONFIRMED.getValue().toString());
            } else {
                alert.setStatusAlert("客户有效性有误；");
                isPass = false;
            }
        }

        /** 微信号码 **/
        model.setWechat(cutString(excel.getWechat(), 32));

        /** 邮箱号 **/
        model.setEmail(cutString(excel.getEmail(), 64));

        /** 备注 **/
        model.setRemark(cutString(excel.getRemark(), 256));

        /**客户级别**/
        if (BooleanUtils.isNotBlank(excel.getLevel())) {
            DictionaryDto customerLevelDic = LambdaFilter.firstOrDefault(dictionaryDtos, m -> m.getValue().equals(DicCode.DIC_CUSTOMER_LEVEL));
            if (customerLevelDic != null) {
                LabelValueDto labelValueDto = LambdaFilter.firstOrDefault(customerLevelDic.getSelections(), m -> m.getLabel().equals(excel.getLevel()));
                if (labelValueDto != null) {
                    model.setLevel(labelValueDto.getValue());
                }
            }
        }

        /**标签**/
        if (BooleanUtils.isNotBlank(excel.getTag())) {
            String[] array = excel.getTag().replace("，", ",").trim().split(",");
            List<String> tagList = LambdaFilter.distinct(Arrays.asList(array));
            model.setTag(SymbolUtils.toStr(tagList));
        }

        /**来源**/
        if (BooleanUtils.isNotBlank(excel.getSource())) {
            DictionaryDto sourceDic = LambdaFilter.firstOrDefault(dictionaryDtos, m -> m.getValue().equals(DicCode
                    .DIC_CUSTOMER_SOURCE));
            if (sourceDic != null) {
                LabelValueDto labelValueDto = LambdaFilter.firstOrDefault(sourceDic.getSelections(), m -> m.getLabel
                        ().equals(excel.getSource()));
                if (labelValueDto != null) {
                    model.setSource(labelValueDto.getValue());
                }
            }
        }

        /**证件类型**/
        if (BooleanUtils.isNotBlank(excel.getCredentialsType())) {
            DictionaryDto credentialType = LambdaFilter.firstOrDefault(dictionaryDtos, m -> m.getValue().equals(DicCode
                    .DIC_CUSTOMER_CREDENTIALS));
            if (credentialType != null) {
                LabelValueDto labelValueDto = LambdaFilter.firstOrDefault(credentialType.getSelections(), m -> m.getLabel
                        ().equals(excel.getCredentialsType()));
                if (labelValueDto != null) {
                    model.setCredentialsType(labelValueDto.getValue());
                }
            }
        }

        /** 证件号码 **/
        model.setCredentialsNumber(cutString(excel.getCredentialsNumber(), 32));

        /** 省份 **/
        model.setProvince(excel.getProvince());

        /** 城市 **/
        model.setCity(excel.getCity());

        /** 地址 **/
        model.setAddress(cutString(excel.getAddress(), 230));

        /** 行业 **/
        model.setTrade(cutString(excel.getTrade(), 64));

        /** 机构 **/
        model.setOrganization(cutString(excel.getOrganization(), 100));

        /** 职位 **/
        model.setPosition(cutString(excel.getPosition(), 64));

        /** QQ **/
        model.setQq(cutString(excel.getQq(), 64));

        /** 银行卡账号 **/
        if (BooleanUtils.isNotBlank(excel.getBankAccount())) {

            if (excel.getBankAccount().length() > 32) {
                alert.setBankAccountAlert("银行卡账号长度不能超过32；");
                isPass = false;
            } else {
                model.setBankAccount(excel.getBankAccount());
            }

        }

        /** 开户行 **/
        model.setBankName(cutString(excel.getBankName(), 128));
        /**银行卡账号**/
        model.setBankAccount(cutString(excel.getBankAccount(), 32));
        if (isPass) {
            customers.add(model);
        } else {
            alerts.add(alert);
            excels.add(excel);
        }

    }

    /**
     * 判断行是否为空
     */
    private boolean isRowEmpty(Map<Integer, String> map) throws Exception {
        for (int i = 0; i < 10; i++) {
            if (!BooleanUtils.isBlank(map.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否存在重复的手机号码
     */
    private boolean isExistRepeatMobile(List<Map<Integer, String>> contents, Integer mobileIndex) throws Exception {
        int contentSize = contents.size();
        for (int i = 1; i < contentSize; i++) {
            Map<Integer, String> content = contents.get(i);
            String mobile = content.get(mobileIndex);
            if (BooleanUtils.isEmpty(mobile)) {
                continue;
            }
            for (int j = 1; j < contentSize; j++) {
                Map<Integer, String> subContent = contents.get(j);
                String subMobile = subContent.get(mobileIndex);
                if (i == j || BooleanUtils.isEmpty(subMobile))
                    continue;
                if (mobile.equals(subMobile)) {
                    return true;
                }
            }
        }
        return false;
    }

    private String getMobiles(List<Map<Integer, String>> contents, int size, int mobileFieldIndex) throws Exception {
        String mobiles = "";
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                continue;
            }
            Map<Integer, String> content = contents.get(i);
            String mobile = content.get(mobileFieldIndex);
            if (!BooleanUtils.isBlank(mobile)) {
                mobiles += mobile + ",";
            }
        }
        return mobiles;
    }

    /**
     * 获取已存在的手机号码
     */
    private List<String> getExistCustomers(String mobiles) throws BaseException {
        Result<List<String>> result =
                HttpUtils.get(TenantUrl.CUSTOMER_IMPORT_GET_EXIST, ArgsUtils.toIdMap(mobiles, "mobiles"), new BaseTypeReference<Result<List<String>>>() {
                });
        return result.getResult();
    }

    private boolean isExist(List<String> existMobiles, String mobile) {
        return existMobiles.contains(mobile);
    }

    /**
     * 截取字符串
     *
     * @param content
     * @return
     * @throws Exception
     */
    protected String cutString(String content, int len) throws Exception {
        if (BooleanUtils.isBlank(content)) {
            return content;
        }
        if (content.length() <= len) {
            return content;
        }
        return content.substring(0, len);
    }

    private void setErrorAlert(List<ImportExcelDto> excels, List<ImportAlertDto> alerts) throws Exception {
        for (ImportExcelDto excel : excels) {
            for (ImportAlertDto alert : alerts) {
                if (excel.getRowNumber().intValue() == alert.getRowNumber()) {
                    String text = !BooleanUtils.isBlank(alert.getMobileAlert()) ? alert.getMobileAlert() : "";
                    text += !BooleanUtils.isBlank(alert.getNameAlert()) ? alert.getNameAlert() : "";
                    text += !BooleanUtils.isBlank(alert.getStatusAlert()) ? alert.getStatusAlert() : "";
                    excel.setErrorAlert(text);
                    continue;
                }
            }
        }
    }

}
