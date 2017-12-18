package com.yundao.tenant.web.util.file;


import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.threadlocal.filter.RequestCommonParams;
import com.yundao.core.utils.DateUtils;
import com.yundao.core.utils.HttpUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.web.constant.url.BaseUrl;
import com.yundao.tenant.web.dto.FileDto;
import com.yundao.tenant.web.dto.customer.imports.ImportRowNameDto;
import com.yundao.tenant.web.util.access.AccessCommon;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExcelUtils {

    private static Log log = LogFactory.getLog(ExcelUtils.class);

    /**
     * 导出EXCEL
     */
    @SuppressWarnings("deprecation")
    public static <T> String export(HttpServletResponse response, List<T> list, ImportRowNameDto rowNameDto)
            throws Exception {
        String sheetName = "Sheet1";
        response.addHeader("Content-Disposition",
                "attachment;filename=" + java.net.URLEncoder.encode("批量导入客户错误反馈.xls", CommonConstant.UTF_8));
        // 如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
        String pattern = "yyyy-MM-dd hh:mm:ss";
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(sheetName);
        /* sheet.autoSizeColumn((short)3000); */
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 12);
        // 把字体应用到当前的样式
        style.setFont(font);

        if (list.size() == 0) {
            return responseStream(response, workbook);
        }

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        T ht = list.get(0);
        Field[] hFields = ht.getClass().getDeclaredFields();

        Field[] rowNameFields = rowNameDto.getClass().getDeclaredFields();

        for (short i = 0; i < hFields.length; i++) {
            Field field = hFields[i];
            // 通过注解，设置表格头部
            String header = "";
            for (Field rowNameField : rowNameFields) {
                if (rowNameField.getName().equals(field.getName())) {
                    header = AccessCommon.getFieldValue(rowNameDto, rowNameField).toString();
                    continue;
                }
            }
            if (i == hFields.length - 2) {
                header = "错误提示";
            }
            HSSFCell hcell = row.createCell(i);
            hcell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(header);
            hcell.setCellValue(text);

            // 调整宽度
            sheet.setColumnWidth(i, (short) 3500);
        }

        // 遍历集合数据
        Iterator<T> it = list.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);
            T t = it.next();
            // 利用反射得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            for (short i = 0; i < fields.length; i++) {
                Field field = fields[i];
                String fieldName = field.getName();
                if (fieldName.equals("rowNumber")) {
                    continue;
                }
                HSSFCell cell = row.createCell(i);
                String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                Class<? extends Object> tCls = t.getClass();
                Method getMethod = tCls.getMethod(getMethodName, new Class[]{});
                Object value = getMethod.invoke(t, new Object[]{});


                if (fieldName.equals("errorAlert")) {
                    HSSFCellStyle errStyle = workbook.createCellStyle(); // 样式对象
                    HSSFFont errFont = workbook.createFont();//生成一个字体
                    errFont.setColor(HSSFColor.RED.index);//字体颜色
                    errStyle.setFont(errFont);
                    cell.setCellStyle(errStyle);
                }

                // 判断值的类型后进行强制类型转换
                String textValue;
                if (value instanceof Date) {
                    Date date = (Date) value;
                    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                    textValue = sdf.format(date);
                } else {
                    // 其它数据类型都当作字符串简单处理
                    textValue = value != null ? value.toString() : "";
                }

                if (textValue != null) {
                    Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                    Matcher matcher = p.matcher(textValue);
                    if (matcher.matches()) {
                        // 是数字当作double处理
                        cell.setCellValue(Double.parseDouble(textValue));
                    } else {
                        HSSFRichTextString richString = new HSSFRichTextString(textValue);
                        cell.setCellValue(richString);
                    }
                }
            }
        }
        return responseStream(response, workbook);
    }


    /**
     * 输出
     *
     * @param response
     * @param workbook
     * @return
     * @throws Exception
     */
    private static String responseStream(HttpServletResponse response, HSSFWorkbook workbook) throws Exception {
        String fileName = DateUtils.getCurrentTime(DateUtils.YYYYMMDDHHMMSSSSS) + ".xls";
        FileOutputStream fo = new FileOutputStream(fileName);
        workbook.write(fo); // 输出
        workbook.close(); // 关闭
        fo.close();

        File file = new File(fileName);
        FileInputStream in = new FileInputStream(file);
        FileDto fileResult = fileUpload(in, fileName);
        return fileResult.getUrl();
    }

    public static FileDto fileUpload(InputStream is, String fileName) throws BaseException {
        FileDto result = new FileDto();
        try {
            // 调用文件基础服务接口上传文件
            String url = BaseUrl.FILE_UPLOAD_POST;
            List<HttpUtils.UploadFileParams> files = new ArrayList<>();
            HttpUtils.UploadFileParams uploadFileParams = new HttpUtils.UploadFileParams();
            uploadFileParams.setFileName(fileName);
            uploadFileParams.setParameterName("file");
            uploadFileParams.setInputStream(is);
            files.add(uploadFileParams);

            Map<String, String> methodParams = new HashMap<>();
            methodParams.put("cloudType", "0");
            methodParams.put("folder", "");
            RequestCommonParams requestParams = RequestCommonParams.newDefault(methodParams);
            log.info("文件开始上传 url：" + url + " files：" + files + " requestParams:" + requestParams);

            requestParams.setHeaderParams(com.yundao.tenant.web.util.HttpUtils.getHeaderParams());
            String response = HttpUtils.postFiles(url, files, requestParams);

            Result<FileDto> r = JsonUtils.jsonToObject(response, new BaseTypeReference<Result<FileDto>>() {
            });

            result = r.getResult();
            log.info("上传成功！返回结果：" + result.toString());
            // 关闭流
            is.close();
        } catch (Exception e) {
            log.error("文件上传异常", e);
        }
        log.info("响应结果:" + result);
        log.end();
        return result;
    }

}