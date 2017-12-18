package com.yundao.tenant.web.service.product.impl;

import com.sun.org.apache.regexp.internal.RE;
import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.common.BaseObjectDto;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.permission.PermissionDetailResDto;
import com.yundao.tenant.web.dto.permission.PermissionListResDto;
import com.yundao.tenant.web.dto.productnotice.BaseProductNotice;
import com.yundao.tenant.web.dto.productnotice.ProductNoticeModel;
import com.yundao.tenant.web.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.service.product.ProductNoticeService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import com.yundao.tenant.web.util.LambdaFilter;
import com.yundao.tenant.web.util.LambdaMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gjl on 2017/8/21.
 */
@Service
public class ProductNoticeServiceImpl implements ProductNoticeService {
    @Autowired
    private PermissionService permissionService;

    @Override
    public Boolean updatePermission(Long id, String code) throws BaseException {
        Result<ProductNoticeModel> modelResult = HttpUtils.get(TenantUrl.PRODUCT_NOTICE_GET, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<ProductNoticeModel>>() {});
        Result<Boolean> result= permissionService.checkUpdate(code,modelResult.getResult().getCreateUserId());
        return result.getResult();
    }

    @Override
    public Result<PermissionResultDto> delete(String ids) throws BaseException {
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        Result<PermissionResultDto> checkResult = checkDelete(params);
        if(!checkResult.getSuccess() || (checkResult.getResult() != null && !checkResult.getResult().isSuccess())){
            return checkResult;
        }
        return HttpUtils.post(TenantUrl.PRODUCT_NOTICE_DELETE, params, new BaseTypeReference<Result<PermissionResultDto>>() {
        });
    }

    @Override
    public void checkUpdatePermission(Result<PaginationSupport<ProductNoticeModel>> result) throws BaseException {
        if(result.getResult() == null || result.getResult().getDatas() == null){
            return;
        }
        //获取每条数据对应的owner
        List<ProductNoticeModel> dtos = LambdaFilter.toList(result.getResult().getDatas(), m -> m.getCreateUserId() != null);
        PermissionListResDto permissionListResDto = permissionService.checkUpdateListSingleObj(DataObjectEnum.NOTICE.getCode(), LambdaMap.toSingleList(dtos, m -> m.getCreateUserId()));
        List<PermissionDetailResDto> permissions = permissionListResDto.getPermissions();

        //获取用户的编辑权限
        DataObjectPermissionEnum permissionEnum = getDataObjectPermissionEnum();

        for (ProductNoticeModel resDto : dtos) {
            if (resDto.getCreateUserId() == null) {
                resDto.setCanProcess(false);
                resDto.setNotCanProcess(DataObjectPermissionEnum.NONE.getNotCanPermission());
                continue;
            }
            PermissionDetailResDto detail = LambdaFilter.firstOrDefault(permissions, m -> resDto.getCreateUserId().equals
                    (m.getOwnerId()));
            if (detail == null || !detail.getIsPass()) {
                resDto.setCanProcess(false);
                resDto.setNotCanProcess(permissionEnum.getNotCanPermission());
            }
        }
    }

    public DataObjectPermissionEnum getDataObjectPermissionEnum() throws BaseException {
        DataObjectPermissionEnum permissionEnum = DataObjectPermissionEnum.NONE;
        Result<Integer> upPermission = permissionService.getUpdate(DataObjectEnum.NOTICE.getCode());
        if(upPermission.getSuccess() && upPermission.getResult() != null){
            permissionEnum = DataObjectPermissionEnum.getEnum(upPermission.getResult());
        }
        return permissionEnum;
    }

    private Result<PermissionResultDto> checkDelete(Map<String,Object> params) throws BaseException {
        Result<List<BaseProductNotice>> result = HttpUtils.get(TenantUrl.PRODUCT_NOTICE_GET_IDS,params,new BaseTypeReference<Result<List<BaseProductNotice>>>(){});
        List<BaseProductNotice> noticeList = result.getResult();
        List<BaseObjectDto> baseObjectDtos = new ArrayList<>(noticeList.size());
        for (BaseProductNotice baseProductNotice : noticeList) {
            baseObjectDtos.add(new BaseObjectDto(baseProductNotice.getId(),baseProductNotice.getTitle(),baseProductNotice.getCreateUserId()));
        }
        return permissionService.checkDeleteListForOwnerIds(baseObjectDtos, DataObjectEnum.NOTICE.getCode());
    }
}
