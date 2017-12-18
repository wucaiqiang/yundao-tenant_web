package com.yundao.tenant.web.service.customer.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.common.DataAndPermissionDto;
import com.yundao.tenant.web.dto.common.DataPermissionDto;
import com.yundao.tenant.web.dto.common.PermissionUrlDto;
import com.yundao.tenant.web.dto.customer.*;
import com.yundao.tenant.web.dto.customer.customer.*;
import com.yundao.tenant.web.dto.customer.follow.CustomerFollowUpPageDto;
import com.yundao.tenant.web.dto.customer.v2.CustomerV2PageReqDto;
import com.yundao.tenant.web.dto.customer.v2.CustomerV2PageResDto;
import com.yundao.tenant.web.dto.permission.PermissionMultiCodeDto;
import com.yundao.tenant.web.dto.sale.leads.LeadsForCustomerDetailReqDto;
import com.yundao.tenant.web.dto.user.customer.UserCustomerDto;
import com.yundao.tenant.web.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.model.customer.BaseCustomer;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.service.customer.CustomerService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.FormatContactUtils;
import com.yundao.tenant.web.util.HttpUtils;
import com.yundao.tenant.web.util.access.ResultAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户服务实现
 *
 * @author jan
 * @create 2017-08-09 PM2:49
 **/
@Service
public class CustomerServiceImpl extends AbstractService implements CustomerService {

    private static Log log = LogFactory.getLog(CustomerServiceImpl.class);

    @Autowired
    private PermissionService permissionService;

    @Override
    public Result<CustomerDetailResDto> getDetail(Long id) throws BaseException {

        Map<String, Object> methodMap = new HashMap<String, Object>();
        methodMap.put("id", id);
        Result<CustomerDetailResDto> dtoResult = HttpUtils.get(TenantUrl.GET_CUSTOMER_DETAIL, methodMap,
                new BaseTypeReference<Result<CustomerDetailResDto>>() {
                });

        if (dtoResult != null && dtoResult.getResult() != null) {
            CustomerDetailResDto dto = dtoResult.getResult();

            Result<Boolean> read = permissionService.checkRead(DataObjectEnum.CUSTOMER.getCode(),
                    dtoResult.getResult().getUserId());

            if (read == null || read.getResult() == null || !read.getSuccess() || !read.getResult()) {
                dto = new CustomerDetailResDto();
                DataAndPermissionDto<CustomerContactDto> contact = new DataAndPermissionDto<>();
                dto.setContact(contact);
                contact.setPermission(new DataPermissionDto(DataObjectEnum.CONTACT.getCode(), false, false, false));

                DataAndPermissionDto<CustomerInfoDto> info = new DataAndPermissionDto<>();
                dto.setInfo(info);
                info.setPermission(new DataPermissionDto(DataObjectEnum.CUSTOMER.getCode(), false, false, false));

                DataAndPermissionDto<CustomerFollowUpPageDto> follow = new DataAndPermissionDto<>();
                dto.setFollow(follow);
                follow.setPermission(new DataPermissionDto(DataObjectEnum.FOLLOW.getCode(), true, false, false));

                return Result.newSuccessResult(dto);
            }

            List<PermissionMultiCodeDto> reqDtos = new ArrayList<PermissionMultiCodeDto>(2);
            reqDtos.add(new PermissionMultiCodeDto(DataObjectEnum.CUSTOMER.getCode(), dto.getUserId()));
            reqDtos.add(new PermissionMultiCodeDto(DataObjectEnum.CONTACT.getCode(), dto.getUserId()));

            Result<List<DataPermissionDto>> peResult = permissionService.checkRead(reqDtos);
            boolean contactRead = false;
            boolean customerRead = false;
            if (peResult != null && peResult.getResult() != null) {
                List<DataPermissionDto> dataPermissionDtos = peResult.getResult();
                if (dataPermissionDtos != null && !dataPermissionDtos.isEmpty()) {
                    for (DataPermissionDto permission : dataPermissionDtos) {
                        if (DataObjectEnum.CONTACT.getCode().equals(permission.getDataObjectCode())) {
                            contactRead = permission.getReadPermission();// 获取读权限

                            DataAndPermissionDto<CustomerContactDto> contact = dto.getContact();
                            if (contact == null) {
                                contact = new DataAndPermissionDto<>();
                                dto.setContact(contact);
                            }
                            contact.setPermission(permission);
                            if (!contactRead) {
                                contact.setData(null);// 没有权限设置为空
                            }
                        } else if (DataObjectEnum.CUSTOMER.getCode().equals(permission.getDataObjectCode())) {
                            customerRead = permission.getReadPermission();// 获取读权限

                            DataAndPermissionDto<CustomerInfoDto> info = dto.getInfo();
                            if (info == null) {
                                info = new DataAndPermissionDto<>();
                                dto.setInfo(info);
                            }
                            info.setPermission(permission);
                        }
                    }

                    //单独配置 跟进权限
                    DataAndPermissionDto<CustomerFollowUpPageDto> follow = new DataAndPermissionDto<>();
                    DataPermissionDto followDP = new DataPermissionDto();
                    followDP.setDataObjectCode(DataObjectEnum.FOLLOW.getCode());
                    followDP.setReadPermission(true);
                    //v1.2版本修改为，只有自己的客户才能根据
                    followDP.setEditPermission(super.getHeaderUserId().equals(dto.getUserId()));
                    followDP.setDeletePermission(false);
                    follow.setPermission(followDP);
                    dto.setFollow(follow);

                }
            }

            // 手机号码加密
            dto.setMobile(FormatContactUtils.formatMobile(customerRead, contactRead, dto.getMobile()));
        }

        return dtoResult;
    }

    @Override
    public Result<PaginationSupport<CustomerV2PageResDto>> getPageV2(CustomerV2PageReqDto dto) throws BaseException {
        //获取对客户资料的读取权限
        Integer permission = permissionService.getRead(DataObjectEnum.CUSTOMER.getCode()).getResult();
        PermissionUrlDto urlDto = new PermissionUrlDto();
        urlDto.setPersonalUrl(TenantUrl.GET_CUSTOMER_V2_PAGE_PERSONAL);
        urlDto.setDepartmentUrl(TenantUrl.GET_CUSTOMER_V2_PAGE_DEPARTMENT);
        urlDto.setPublicUrl(TenantUrl.GET_CUSTOMER_V2_PAGE_PUBLIC);
        String url = urlDto.getPermissionUrl(permission);
        // 没有对应的url，表示没有权限，直接返回
        if (BooleanUtils.isEmpty(url))
            return Result.newSuccessResult(new PaginationSupport<CustomerV2PageResDto>());

        Result<PaginationSupport<CustomerV2PageResDto>> result = HttpUtils.get(url, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<PaginationSupport<CustomerV2PageResDto>>>() {
                });
        if (!result.getSuccess())
            return result;
        if (BooleanUtils.isEmpty(result.getResult().getDatas())) {
            return Result.newSuccessResult(new PaginationSupport<CustomerV2PageResDto>());
        }
        return ResultAccess.newSuccessResultPage(result);
    }

    @Override
    public Result<PaginationSupport<MyCustomerPageResDto>> getMyPage(MyCustomerPageReqDto dto) throws BaseException {
        // 获取读取的权限
        Integer permission = permissionService.getRead(DataObjectEnum.CUSTOMER.getCode()).getResult();
        if (DataObjectPermissionEnum.NONE.getValue().equals(permission)) {
            // 表示没有任何权限,直接返回
            return Result.newSuccessResult(new PaginationSupport<MyCustomerPageResDto>());
        }
        Result<PaginationSupport<MyCustomerPageResDto>> result = HttpUtils.get(TenantUrl.GET_CUSTOMER_MY_PAGE,
                ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<MyCustomerPageResDto>>>() {
                });
        if (!result.getSuccess())
            return result;
        if (BooleanUtils.isEmpty(result.getResult().getDatas()))
            return Result.newSuccessResult(new PaginationSupport<MyCustomerPageResDto>());

        this.setFollowPermission(result);

        return ResultAccess.newSuccessResultPage(result);
    }

    private void setFollowPermission(Result<PaginationSupport<MyCustomerPageResDto>> result) throws BaseException {
        log.info("setFollowPermission 开始");
        List<MyCustomerPageResDto> datas = result.getResult().getDatas();

        for (MyCustomerPageResDto data : datas) {
            data.setCanFollow(super.getHeaderUserId().equals(data.getFpId()));
        }
    }

    @Override
    public Result<Integer> updateContact(CustomerContactReqDto reqDto) throws BaseException {
        validateUpdatePermission(reqDto.getId(), DataObjectEnum.CONTACT.getCode());

        Result<Integer> result = HttpUtils.post(TenantUrl.UPDATE_CONTACT, ArgsUtils.toMap(reqDto),
                new BaseTypeReference<Result<Integer>>() {
                });
        return result;
    }

    private void validateUpdatePermission(Long customerId, String code) throws BaseException {
        Map<String, Object> methodMap = new HashMap<String, Object>();
        methodMap.put("id", customerId);
        Result<BaseCustomer> dtoResult = HttpUtils.get(TenantUrl.GET_CUSTOMER, methodMap,
                new BaseTypeReference<Result<BaseCustomer>>() {
                });
        if (dtoResult.getResult() == null) {
            throw new BaseException(CodeConstant.CODE_1220016);
        }
        Result<Boolean> permissionResult = permissionService.checkUpdate(code,
                dtoResult.getResult().getUserId());
        if (!permissionResult.getResult()) {
            throw new BaseException(CodeConstant.CODE_1220016);
        }
    }

    @Override
    public Result<Integer> updateInfo(CustomerExclusiveContactReqDto reqDto) throws BaseException {
        validateUpdatePermission(reqDto.getId(), DataObjectEnum.CUSTOMER.getCode());

        Result<Integer> result = HttpUtils.post(TenantUrl.UPDATE_INFO, ArgsUtils.toMap(reqDto),
                new BaseTypeReference<Result<Integer>>() {
                });
        return result;

    }

    @Override
    public Result<List<CustomerSelectionResDto>> getMyCustomerSelections(CustomerSelectionReqDto dto)
            throws BaseException {
        Integer permission = permissionService.getRead(DataObjectEnum.CUSTOMER.getCode()).getResult();
        if (permission == null || DataObjectPermissionEnum.NONE.getValue().equals(permission)) {
            return Result.newSuccessResult(new ArrayList<>());
        }
        Result<List<CustomerSelectionResDto>> result = HttpUtils.get(TenantUrl.CUSTOMER_GET_MY_SELECTIONS,
                ArgsUtils.toMap(dto), new BaseTypeReference<Result<List<CustomerSelectionResDto>>>() {
                });
        if (BooleanUtils.isEmpty(result.getResult()))
            return result;

        return ResultAccess.newSuccessResultList(result, super.getHeaderUserId());
    }

    @Override
    public UserCustomerDto getUserCustomer(Long customerId) throws BaseException {
        UserCustomerDto dto = HttpUtils.get(TenantUrl.GET_USER_CUSTOMER, ArgsUtils.toIdMap(customerId, "customerId"),
                new BaseTypeReference<Result<UserCustomerDto>>() {
                }).getResult();
        return dto;
    }

    @Override
    public Result<Long> updateStatus(CustomerUpdateStatusReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.UPDATE_CUSTOMER_STATUS, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    /**
     * 是否有权限查询
     * hasReadCustomerPermission:
     *
     * @param customerId
     * @return
     * @throws BaseException
     * @author: 欧阳利
     * @description:
     */
    public Boolean hasReadCustomerPermission(Long customerId) throws BaseException {
        Map<String, Object> methodMap = new HashMap<String, Object>();
        methodMap.put("customerId", customerId);
        Result<Long> dtoResult = HttpUtils.get(TenantUrl.GET_USERID_BY_CUSTOMERID, methodMap,
                new BaseTypeReference<Result<Long>>() {
                });
        Result<Boolean> read = permissionService.checkRead(DataObjectEnum.CUSTOMER.getCode(),
                dtoResult.getResult());
        if (read == null || read.getResult() == null || !read.getSuccess() || !read.getResult()) {
            return false;
        }
        return true;
    }

    @Override
    public Result<CustomerDetailLeadsChanceResCount> getPageForCustomerDetailCount(LeadsForCustomerDetailReqDto dto) throws BaseException {
        log.begin(dto);
        //获取对客户资料的读取权限
        Integer permission = permissionService.getRead(DataObjectEnum.LEADS.getCode()).getResult();
        PermissionUrlDto urlDto = new PermissionUrlDto();
        urlDto.setPersonalUrl(TenantUrl.GET_CUSTOMER_LEADS_CHANCE_COUNT_PERSONAL);
        urlDto.setDepartmentUrl(TenantUrl.GET_CUSTOMER_LEADS_CHANCE_COUNT_DEPARTMENT);
        urlDto.setPublicUrl(TenantUrl.GET_CUSTOMER_LEADS_CHANCE_COUNT_PUBLIC);
        String url = urlDto.getPermissionUrl(permission);
        if (BooleanUtils.isBlank(url)) {
            //无权限
            CustomerDetailLeadsChanceResCount resDto = new CustomerDetailLeadsChanceResCount();
            resDto.setChanceCount(0);
            resDto.setLeadsCount(0);
            return Result.newSuccessResult(resDto);
        }
        return HttpUtils.get(url, ArgsUtils.toMap(dto), new BaseTypeReference<Result<CustomerDetailLeadsChanceResCount>>() {
        });
    }

}
