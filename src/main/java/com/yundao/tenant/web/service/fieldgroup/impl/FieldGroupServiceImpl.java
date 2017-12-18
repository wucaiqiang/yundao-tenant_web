package com.yundao.tenant.web.service.fieldgroup.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.bo.ObjectFieldPageResDto;
import com.yundao.tenant.web.dto.common.BaseObjectDto;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.fieldgroup.BaseFieldGroup;
import com.yundao.tenant.web.dto.fieldgroup.FieldGroupRelDto;
import com.yundao.tenant.web.dto.product.ProductSelectOptionDto;
import com.yundao.tenant.web.enums.bo.BusinessObjectEnum;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.service.fieldgroup.FieldGroupService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by gjl on 2017/7/6.
 */
@Service
public class FieldGroupServiceImpl implements FieldGroupService {
    @Autowired
    private PermissionService permissionService;
    @Override
    public FieldGroupRelDto get(Long id) throws BaseException {
        Result<BaseFieldGroup> baseFieldGroupResult = HttpUtils.get(TenantUrl.FIELD_GROUP_GET, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<BaseFieldGroup>>(){});
        Result<List<ObjectFieldPageResDto>> objectFieldList = HttpUtils.get(TenantUrl.FIELDGROUPREL_GET, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<List<ObjectFieldPageResDto>>>(){});
        Result<List<ObjectFieldPageResDto>> allField = HttpUtils.get(TenantUrl.GET_ELEMENT_LIST, ArgsUtils.toIdMap(BusinessObjectEnum.PRODUCT.getCode(),"boCode"), new BaseTypeReference<Result<List<ObjectFieldPageResDto>>>(){});
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("typeId",baseFieldGroupResult.getResult().getId());
        params.put("count",Integer.MAX_VALUE);
        Result<List<ProductSelectOptionDto>> managerList = HttpUtils.get(TenantUrl.PRODUCT_GET_SELECT_OPTION_LIST_BY_TYPEID, params, new BaseTypeReference<Result<List<ProductSelectOptionDto>>>(){});
        return new FieldGroupRelDto(baseFieldGroupResult.getResult(),objectFieldList.getResult(),allField.getResult(),managerList.getResult());
    }

    @Override
    public Result<PermissionResultDto> checkDelete(Map<String, Object> params) throws BaseException {
        Result<List<BaseFieldGroup>> result = HttpUtils.get(TenantUrl.PRODUCT_NOTICE_GET_IDS,params,new BaseTypeReference<Result<List<BaseFieldGroup>>>(){});
        List<BaseFieldGroup> fieldGroups = result.getResult();
        List<BaseObjectDto> baseObjectDtos = new ArrayList<>(fieldGroups.size());
        for (BaseFieldGroup fieldGroup : fieldGroups) {
            baseObjectDtos.add(new BaseObjectDto(fieldGroup.getId(),fieldGroup.getName(),fieldGroup.getCreateUserId()));
        }
        return permissionService.checkDeleteListForOwnerIds(baseObjectDtos, DataObjectEnum.PRODUCT_TYPE.getCode());
    }

    @Override
    public Boolean checkUpdate(Long id) throws BaseException {
        Result<BaseFieldGroup> baseFieldGroupResult = HttpUtils.get(TenantUrl.FIELD_GROUP_GET, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<BaseFieldGroup>>(){});
        if(baseFieldGroupResult == null || baseFieldGroupResult.getResult() == null) {
            return false;
        }
        Result<Boolean> result = permissionService.checkUpdate(DataObjectEnum.PRODUCT_TYPE.getCode(),baseFieldGroupResult.getResult().getCreateUserId());
        return result.getResult();
    }
}
