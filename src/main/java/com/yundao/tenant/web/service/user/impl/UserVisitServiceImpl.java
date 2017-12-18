package com.yundao.tenant.web.service.user.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.common.PermissionUrlDto;
import com.yundao.tenant.web.dto.customer.CustomerDetailVisitPageReqDto;
import com.yundao.tenant.web.dto.customer.CustomerDetailVisitPageResDto;
import com.yundao.tenant.web.dto.user.visit.UserVisitPageReqDto;
import com.yundao.tenant.web.dto.user.visit.UserVisitPageResDto;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.service.user.UserVisitService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import com.yundao.tenant.web.util.access.ResultAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 客户回访服务实现
 *
 * @author jan
 * @create 2017-08-12 PM2:09
 **/
@Service
public class UserVisitServiceImpl implements UserVisitService {

    @Autowired
    private PermissionService permissionService;

    @Override
    public Result<PaginationSupport<CustomerDetailVisitPageResDto>> getCustomerDetailVisitPage(CustomerDetailVisitPageReqDto dto) throws BaseException {
        //查看当前操作人的权限
        Integer permission = permissionService.getRead(DataObjectEnum.VISIT.getCode()).getResult();
        PermissionUrlDto urlDto = new PermissionUrlDto();
        urlDto.setPersonalUrl(TenantUrl.GET_USER_VISIT_PAGE_FOR_CUSTOMER_DETAIL_PERSONAL);
        urlDto.setDepartmentUrl(TenantUrl.GET_USER_VISIT_PAGE_FOR_CUSTOMER_DETAIL_DEPARTMENT);
        urlDto.setPublicUrl(TenantUrl.GET_USER_VISIT_PAGE_FOR_CUSTOMER_DETAIL_PUBLIC);
        String url = urlDto.getPermissionUrl(permission);
        //如无权限，直接返回
        if (BooleanUtils.isEmpty(url))
            return Result.newSuccessResult(new PaginationSupport<CustomerDetailVisitPageResDto>());

        return HttpUtils.get(url, ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<CustomerDetailVisitPageResDto>>>() {
        });
    }

    @Override
    public Result<PaginationSupport<UserVisitPageResDto>> getPage(UserVisitPageReqDto dto) throws BaseException {
        Integer permission = permissionService.getRead(DataObjectEnum.VISIT.getCode()).getResult();
        PermissionUrlDto urlDto = new PermissionUrlDto();
        urlDto.setPersonalUrl(TenantUrl.GET_USER_VISIT_PAGE_FOR_PERSONAL);
        urlDto.setDepartmentUrl(TenantUrl.GET_USER_VISIT_PAGE_FOR_DEPARTMENT);
        urlDto.setPublicUrl(TenantUrl.GET_USER_VISIT_PAGE_FOR_PUBLIC);
        String url = urlDto.getPermissionUrl(permission);
        //如无权限，直接返回
        if (BooleanUtils.isEmpty(url))
            return Result.newSuccessResult(new PaginationSupport<UserVisitPageResDto>());

        Result<PaginationSupport<UserVisitPageResDto>> result = HttpUtils.get(url, ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<UserVisitPageResDto>>>() {
        });
        PaginationSupport<UserVisitPageResDto> page = result.getResult();
        if (BooleanUtils.isEmpty(page.getDatas()))
            return Result.newSuccessResult(new PaginationSupport<UserVisitPageResDto>());

        return ResultAccess.newSuccessResultPage(result);
    }
}
