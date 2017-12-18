package com.yundao.tenant.web.service.pool.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.common.DataAndPermissionDto;
import com.yundao.tenant.web.dto.common.DataPermissionDto;
import com.yundao.tenant.web.dto.common.PermissionUrlDto;
import com.yundao.tenant.web.dto.customer.CustomerDetailResDto;
import com.yundao.tenant.web.dto.customer.follow.CustomerFollowUpPageDto;
import com.yundao.tenant.web.dto.customer.opensea.CustomerOpenSeaPageReqDto;
import com.yundao.tenant.web.dto.customer.opensea.CustomerOpenSeaPageResDto;
import com.yundao.tenant.web.dto.customer.pool.CustomerPoolPageReqDto;
import com.yundao.tenant.web.dto.customer.pool.CustomerPoolPageResDto;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.service.pool.CustomerPoolService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.FormatContactUtils;
import com.yundao.tenant.web.util.HttpUtils;
import com.yundao.tenant.web.util.access.ResultAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 客户池控服务实现
 *
 * @author jan
 * @create 2017-08-14 PM2:10
 **/
@Service
public class CustomerPoolServiceImpl implements CustomerPoolService {

    private static Log log = LogFactory.getLog(CustomerPoolServiceImpl.class);

    @Autowired
    private PermissionService permissionService;

    @Override
    public Result<PaginationSupport<CustomerPoolPageResDto>> getPage(CustomerPoolPageReqDto dto) throws BaseException {
        log.begin(dto);
        //获取对客户资料的读取权限
        Integer permission = permissionService.getRead(DataObjectEnum.CUSTOMER.getCode()).getResult();
        PermissionUrlDto urlDto = new PermissionUrlDto();
        urlDto.setPersonalUrl(TenantUrl.GET_CUSTOMER_POOL_PERSONAL);
        urlDto.setDepartmentUrl(TenantUrl.GET_CUSTOMER_POOL_DEPARTMENT);
        urlDto.setPublicUrl(TenantUrl.GET_CUSTOMER_POOL_PUBLIC);
        String url = urlDto.getPermissionUrl(permission);
        // 没有对应的url，表示没有权限，直接返回
        if (BooleanUtils.isEmpty(url))
            return Result.newSuccessResult(new PaginationSupport<CustomerPoolPageResDto>());

        Result<PaginationSupport<CustomerPoolPageResDto>> result = HttpUtils.get(url, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<PaginationSupport<CustomerPoolPageResDto>>>() {
                });
        if (!result.getSuccess())
            return result;
        if (BooleanUtils.isEmpty(result.getResult().getDatas())) {
            return Result.newSuccessResult(new PaginationSupport<CustomerPoolPageResDto>());
        }
        return ResultAccess.newSuccessResultPage(result);
    }

    /**
     * 获取公海分页数据
     */
    public Result<PaginationSupport<CustomerOpenSeaPageResDto>> getOpenSeaPage(CustomerOpenSeaPageReqDto dto) throws BaseException {
        log.begin(dto);
        return HttpUtils.get(TenantUrl.GET_CUSTOMER_OPENSEA_PUBLIC, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<PaginationSupport<CustomerOpenSeaPageResDto>>>() {
                });
    }

    @Override
    public Result<CustomerDetailResDto> getDetail(Long id) throws BaseException {
        Result<CustomerDetailResDto> result = HttpUtils.get(TenantUrl.GET_CUSTOMER_DETAIL, ArgsUtils.toIdMap(id),
                new BaseTypeReference<Result<CustomerDetailResDto>>() {
                });
        //对客户基本信息的操作权限
        Boolean isCustomerReadPermission = true;
        Boolean isCustomerEditPermission = false;
        Boolean isCustomerDeletePermission = false;

        //对客户联系方式的操作权限
        Boolean isContactReadPermission = false;
        Boolean isContactEditPermission = false;
        Boolean isContactDeletePermission = false;

        //对跟进信息的操作权限
        Boolean isFollowReadPermission = true;
        Boolean isFollowEditPermission = false;
        Boolean isFollowDeletePermission = false;

        CustomerDetailResDto dto = result.getResult();
        dto.setMobile(FormatContactUtils.formatMobile(isCustomerReadPermission, isContactReadPermission, dto.getMobile()));

        if (dto.getInfo() != null) {
            DataPermissionDto infoDP = new DataPermissionDto();
            infoDP.setDataObjectCode(DataObjectEnum.CUSTOMER.getCode());
            infoDP.setReadPermission(isCustomerReadPermission);
            infoDP.setEditPermission(isCustomerEditPermission);
            infoDP.setDeletePermission(isCustomerDeletePermission);
            dto.getInfo().setPermission(infoDP);
        }

        if (dto.getContact() != null) {
            DataPermissionDto contactDP = new DataPermissionDto();
            contactDP.setDataObjectCode(DataObjectEnum.CONTACT.getCode());
            contactDP.setReadPermission(isContactReadPermission);
            contactDP.setEditPermission(isContactEditPermission);
            contactDP.setDeletePermission(isContactDeletePermission);
            dto.getContact().setPermission(contactDP);
            if (dto.getContact().getData() != null) {
                dto.getContact().getData().setMobile(FormatContactUtils.formatMobile(isCustomerReadPermission, isContactReadPermission, dto.getMobile()));
            }
        }

        DataAndPermissionDto<CustomerFollowUpPageDto> follow = dto.getFollow() == null ? new DataAndPermissionDto<>() : dto
                .getFollow();
        DataPermissionDto followDP = new DataPermissionDto();
        followDP.setDataObjectCode(DataObjectEnum.FOLLOW.getCode());
        followDP.setReadPermission(isFollowReadPermission);
        followDP.setEditPermission(isFollowEditPermission);
        followDP.setDeletePermission(isFollowDeletePermission);
        follow.setPermission(followDP);
        dto.setFollow(follow);

        return result;

    }
}
