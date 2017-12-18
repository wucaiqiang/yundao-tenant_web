package com.yundao.tenant.web.service.sale.leads.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.common.PermissionUrlDto;
import com.yundao.tenant.web.dto.permission.PermissionDetailResDto;
import com.yundao.tenant.web.dto.permission.PermissionListResDto;
import com.yundao.tenant.web.dto.sale.leads.*;
import com.yundao.tenant.web.dto.user.customer.UserCustomerDto;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.service.customer.CustomerService;
import com.yundao.tenant.web.service.sale.leads.LeadsService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import com.yundao.tenant.web.util.LambdaFilter;
import com.yundao.tenant.web.util.LambdaMap;
import com.yundao.tenant.web.util.access.ResultAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jan
 * @create 2017-09-07 PM9:47
 **/
@Service
public class LeadsServiceImpl implements LeadsService {

    private static Log log = LogFactory.getLog(LeadsServiceImpl.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public Result<PaginationSupport<LeadsPageResDto>> getPage(LeadsPageReqDto dto) throws BaseException {
        log.begin(dto);
        //获取对客户资料的读取权限
        Integer permission = permissionService.getRead(DataObjectEnum.LEADS.getCode()).getResult();
        PermissionUrlDto urlDto = new PermissionUrlDto();
        urlDto.setPersonalUrl(TenantUrl.GET_LEADS_PAGE_PERSONAL);
        urlDto.setDepartmentUrl(TenantUrl.GET_LEADS_PAGE_DEPARTMENT);
        urlDto.setPublicUrl(TenantUrl.GET_LEADS_PAGE_PUBLIC);
        String url = urlDto.getPermissionUrl(permission);

        // 没有对应的url，表示没有权限，直接返回
        if (BooleanUtils.isEmpty(url))
            return Result.newSuccessResult(new PaginationSupport<LeadsPageResDto>());

        Result<PaginationSupport<LeadsPageResDto>> result = HttpUtils.get(url, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<PaginationSupport<LeadsPageResDto>>>() {
                });
        if (!result.getSuccess())
            return result;
        if (BooleanUtils.isEmpty(result.getResult().getDatas())) {
            return Result.newSuccessResult(new PaginationSupport<LeadsPageResDto>());
        }
        return ResultAccess.newSuccessResultPage(result);
    }

    @Override
    public Result<PaginationSupport<LeadsForCustomerDetailResDto>> getPageForCustomerDetail(LeadsForCustomerDetailReqDto dto) throws BaseException {
        log.begin(dto);
        //获取对客户资料的读取权限
        Integer permission = permissionService.getRead(DataObjectEnum.LEADS.getCode()).getResult();
        PermissionUrlDto urlDto = new PermissionUrlDto();
        urlDto.setPersonalUrl(TenantUrl.GET_LEADS_FOR_CUSTOMER_DETAIL_PERSONAL);
        urlDto.setDepartmentUrl(TenantUrl.GET_LEADS_FOR_CUSTOMER_DETAIL_DEPARTMENT);
        urlDto.setPublicUrl(TenantUrl.GET_LEADS_FOR_CUSTOMER_DETAIL_PUBLIC);
        String url = urlDto.getPermissionUrl(permission);

        // 没有对应的url，表示没有权限，直接返回
        if (BooleanUtils.isEmpty(url))
            return Result.newSuccessResult(new PaginationSupport<LeadsForCustomerDetailResDto>());

        Result<PaginationSupport<LeadsForCustomerDetailResDto>> result = HttpUtils.get(url, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<PaginationSupport<LeadsForCustomerDetailResDto>>>() {
                });
        if (!result.getSuccess())
            return result;

        if (BooleanUtils.isEmpty(result.getResult().getDatas()))
            return Result.newSuccessResult(new PaginationSupport<LeadsForCustomerDetailResDto>());

        //判断是否有足够权限处理线索
        this.setProcessPermission(result);
        return result;
    }

    private void setProcessPermission(Result<PaginationSupport<LeadsForCustomerDetailResDto>> result) throws BaseException {
        //注意：canProcess的值，后置系统已经根据 当前状态设置好了，所以这里仅当没权限时，设置为false，有权限忽略即可
        List<LeadsForCustomerDetailResDto> dtos = result.getResult().getDatas();

        PermissionListResDto permissionListResDto = permissionService.checkUpdateListSingleObj(DataObjectEnum.LEADS.getCode(), LambdaMap.toSingleList(dtos, m -> m.getFpId()));
        List<PermissionDetailResDto> permissions = permissionListResDto.getPermissions();
        for (LeadsForCustomerDetailResDto resDto : result.getResult().getDatas()) {
            if (resDto.getFpId() == null) {
                resDto.setCanProcess(false);
                continue;
            }
            PermissionDetailResDto detail = LambdaFilter.firstOrDefault(permissions, m -> resDto.getFpId().equals
                    (m.getOwnerId()));
            if (detail == null || !detail.getIsPass())
                resDto.setCanProcess(false);
        }
    }

    @Override
    public Result<Long> doProcess(LeadsUpdateStatusReqDto dto) throws BaseException {
        LeadsDetailDto leadsDetail = this.get(dto.getId());
        if (leadsDetail == null)
            throw new BaseException(CodeConstant.CODE_900015);

        //判断是否有编辑线索的权限
        UserCustomerDto userCustomer = customerService.getUserCustomer(leadsDetail.getCustomerId());
        Boolean canUpdate = permissionService.checkUpdate(DataObjectEnum.LEADS.getCode(), userCustomer != null ? userCustomer.getUserId() : null).getResult();
        if (!canUpdate)
            throw new BaseException(CodeConstant.CODE_1220015);

        return HttpUtils.post(TenantUrl.PROCESS_LEADS, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    private LeadsDetailDto get(Long id) throws BaseException {
        return HttpUtils.get(TenantUrl.GET_LEADS, ArgsUtils.toIdMap(id, "id"), new BaseTypeReference<Result<LeadsDetailDto>>() {
        }).getResult();
    }
}
