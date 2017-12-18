package com.yundao.tenant.web.controller.filedgroup;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.DateUtils;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.common.DataAndPermissionDto;
import com.yundao.tenant.web.dto.common.DataPermissionDto;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.fieldgroup.*;
import com.yundao.tenant.web.enums.bo.BusinessObjectEnum;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.service.fieldgroup.FieldGroupService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务对象字段分组
 *
 * @author gjl
 * @create 2017-07-06 PM6:07
 **/
@RestController
@RequestMapping("/product/fieldgroup/")
@ResponseBody
@Api("业务对象字段分组")
public class FieldGroupController {

    @Autowired
    private FieldGroupService fieldGroupService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation(value = "新增业务对象字段分组", notes = "根据FieldGroup对象创建业务对象字段分组")
    public Result<Long> add(@ModelAttribute FieldGroupReqDto dto) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(dto);
        params.put("boCode", BusinessObjectEnum.PRODUCT.getCode());
        return HttpUtils.post(TenantUrl.FIELD_GROUP_ADD, params, new BaseTypeReference<Result<Long>>() {
        });
    }

    @ApiOperation(value = "获取业务对象字段分组详情和关联关系表")
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Result<DataAndPermissionDto<FieldGroupRelDto>> get(@RequestParam long id) throws BaseException {
        FieldGroupRelDto fieldGroupRelDto = fieldGroupService.get(id);
        DataAndPermissionDto<FieldGroupRelDto> result = new DataAndPermissionDto<>();
        result.setData(fieldGroupRelDto);

        //暂时去掉数据权限
       /* PermissionMultiCodeDto codeDto = new PermissionMultiCodeDto(DataObjectEnum.PRODUCT_TYPE.getCode(), fieldGroupRelDto.getFieldGroup().getCreateUserId());
        Result<DataPermissionDto> permissionDtoResult = permissionService.checkOnlyCode(codeDto);
        result.setPermission(permissionDtoResult.getResult());*/

        //临时赋予所有权限
        DataPermissionDto permissionDto = new DataPermissionDto();
        permissionDto.setDataObjectCode(DataObjectEnum.PRODUCT_TYPE.getCode());
        permissionDto.setEditPermission(true);
        permissionDto.setReadPermission(true);
        permissionDto.setReadPermission(true);
        result.setPermission(permissionDto);
        return Result.newSuccessResult(result);
    }

    @RequestMapping(value = "get_page", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询业务对象字段分组")
    public Result<PaginationSupport<BaseFieldGroup>> gets(@ModelAttribute FieldGroupPageDto pageDto) throws Exception {
        if (pageDto.getCreateDateEnd() != null) {
            pageDto.setCreateDateEnd(DateUtils.getDateEnd(DateUtils.parse(pageDto.getCreateDateEnd(), DateUtils.YYYY_MM_DD)));
        }
        Map<String, Object> params = ArgsUtils.toMap(pageDto);
        params.put("boCode", BusinessObjectEnum.PRODUCT.getCode());
        return HttpUtils.get(TenantUrl.FIELD_GROUP_GETS, params, new BaseTypeReference<Result<PaginationSupport<BaseFieldGroup>>>() {
        });
    }

    @RequestMapping(value = "get_all", method = RequestMethod.GET)
    @ApiOperation(value = "查询业务对象字段分组")
    public Result<List<BaseFieldGroup>> getAll(@ModelAttribute FieldGroupPageDto pageDto) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(pageDto);
        params.put("boCode", BusinessObjectEnum.PRODUCT.getCode());
        params.put("pageSize", Integer.MAX_VALUE);
        params.put("isEnabled", CommonConstant.ONE);
        Result<PaginationSupport<BaseFieldGroup>> models = HttpUtils.get(TenantUrl.FIELD_GROUP_GETS, params, new BaseTypeReference<Result<PaginationSupport<BaseFieldGroup>>>() {
        });
        return models.getResult() == null ? null : Result.newSuccessResult(models.getResult().getDatas());
    }

//    @RequestMapping(value = "update", method = RequestMethod.POST)
//    @ApiOperation(value = "编辑业务对象字段分组信息")
//    public Result<Long> update(@ModelAttribute FieldGroupReqDto dto) throws BaseException {
//        /*数据权限暂时去掉*/
//       /* Boolean isPass = fieldGroupService.checkUpdate(dto.getId());
//        if(!isPass){
//            throw new BaseException(CodeConstant.CODE_1220016);
//        }*/
//        Map<String, Object> params = ArgsUtils.toMap(dto);
//        params.put("boCode", BusinessObjectEnum.PRODUCT.getCode());
//        return HttpUtils.post(TenantUrl.FIELD_GROUP_UPDASTE, params, new BaseTypeReference<Result<Long>>() {
//        });
//    }

    @RequestMapping(value = "update_info", method = RequestMethod.POST)
    @ApiOperation(value = "编辑业务对象字段分组信息")
    public Result<Long> updateInfo(@ModelAttribute FieldGroupInfoReqDto dto) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(dto);
        params.put("boCode", BusinessObjectEnum.PRODUCT.getCode());
        return HttpUtils.post(TenantUrl.FIELD_GROUP_UPDASTE_INFO, params, new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "update_rel", method = RequestMethod.POST)
    @ApiOperation(value = "编辑业务对象字段分组信息")
    public Result<Long> updateRel(@ModelAttribute FieldGroupRelReqDto dto) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(dto);
        params.put("boCode", BusinessObjectEnum.PRODUCT.getCode());
        return HttpUtils.post(TenantUrl.FIELD_GROUP_UPDASTE_REL, params, new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除业务对象字段分组信息")
    public Result<PermissionResultDto> delete(@RequestParam String ids) throws BaseException {
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        /*数据权限暂时去掉*/
    /*    Result<PermissionResultDto> checkResult = fieldGroupService.checkDelete(params);
        if(!checkResult.getSuccess()){
            return checkResult;
        }*/
        return HttpUtils.post(TenantUrl.FIELD_GROUP_DELETE, params, new BaseTypeReference<Result<PermissionResultDto>>() {
        });
    }
}
