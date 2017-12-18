package com.yundao.tenant.web.controller.project.company;

import com.fasterxml.jackson.databind.JavaType;
import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.UpdateMultipleDto;
import com.yundao.tenant.web.dto.UpdateOnlyReqDto;
import com.yundao.tenant.web.dto.project.ProjectDetailResDto;
import com.yundao.tenant.web.dto.project.ProjectIdReqDto;
import com.yundao.tenant.web.dto.project.company.BaseAmCompany;
import com.yundao.tenant.web.dto.project.company.CompanyDetailResDto;
import com.yundao.tenant.web.service.am.project.ProjectPermissionService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by gjl on 2017/11/20.
 */
@Controller
@RequestMapping("/assets/project/company")
@ResponseBody
@Api("项目管理 - 公司")
public class CompanyController {

    @Autowired
    private ProjectPermissionService projectPermissionService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation("获取项目公司详情")
    public Result<CompanyDetailResDto> get(@ModelAttribute ProjectIdReqDto dto) throws BaseException {
        return HttpUtils.get(AmUrl.PROJECT_COMPANY_GET, ArgsUtils.toMap(dto), new BaseTypeReference<Result<CompanyDetailResDto>>() {
        });
    }

    @RequestMapping(value = "/update_only", method = RequestMethod.POST)
    @ApiOperation("单项修改项目公司")
    public Result<Long> updateOnly(@ModelAttribute UpdateOnlyReqDto dto) throws BaseException {
        Result<BaseAmCompany> detailResDtoResult = HttpUtils.get(AmUrl.PROJECT_COMPANY_GET_ID, ArgsUtils.toIdMap(dto.getId()), new BaseTypeReference<Result<BaseAmCompany>>() {});
        if(!detailResDtoResult.getSuccess() || detailResDtoResult.getResult() == null){
            throw new BaseException(CodeConstant.CODE_1220016);
        }
        boolean isAuth = projectPermissionService.checkEdit(detailResDtoResult.getResult().getProjectId());
        if(!isAuth){
            throw new BaseException(CodeConstant.CODE_1220016);
        }
        return HttpUtils.post(AmUrl.PROJECT_COMPANY_UPDATE_ONLY, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "/update_multiple", method = RequestMethod.POST)
    @ApiOperation("单项编辑支持多个")
    public Result<Integer> updateMultiple(String data) throws Exception {
        JavaType javaType = JsonUtils.getCollectionType(List.class, UpdateOnlyReqDto.class);
        List<UpdateOnlyReqDto> updateOnlyReqDtos = JsonUtils.jsonToObject(data,javaType);

        if(updateOnlyReqDtos != null){
            Result<BaseAmCompany> detailResDtoResult = HttpUtils.get(AmUrl.PROJECT_COMPANY_GET_ID, ArgsUtils.toIdMap(updateOnlyReqDtos.get(0).getId()), new BaseTypeReference<Result<BaseAmCompany>>() {});
            if(!detailResDtoResult.getSuccess() || detailResDtoResult.getResult() == null){
                throw new BaseException(CodeConstant.CODE_1220016);
            }
            boolean isAuth = projectPermissionService.checkEdit(detailResDtoResult.getResult().getProjectId());
            if(!isAuth){
                throw new BaseException(CodeConstant.CODE_1220016);
            }

            for (UpdateOnlyReqDto dto : updateOnlyReqDtos) {
                HttpUtils.post(AmUrl.PROJECT_COMPANY_UPDATE_ONLY, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
                });
            }
        }

        return Result.newSuccessResult(CommonConstant.ONE);
    }
}
