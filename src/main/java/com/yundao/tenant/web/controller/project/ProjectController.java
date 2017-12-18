package com.yundao.tenant.web.controller.project;

import com.fasterxml.jackson.databind.JavaType;
import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.JsonUtils;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.UpdateMultipleDto;
import com.yundao.tenant.web.dto.UpdateOnlyReqDto;
import com.yundao.tenant.web.dto.common.DataAndPermissionDto;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.project.*;
import com.yundao.tenant.web.service.am.project.ProjectService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.util.Args;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目控制器
 *
 * @author jan
 * @create 2017-11-17 16:39
 **/
@Controller
@RequestMapping("/assets/project")
@ResponseBody
@Api("项目管理")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("添加")
    public Result<Long> add(@ModelAttribute ProjectAddReqDto dto) throws BaseException {
        return HttpUtils.post(AmUrl.ADD_PROJECT, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation("获取项目详情")
    public Result<DataAndPermissionDto<ProjectDetailResDto>> add(@ModelAttribute ProjectIdReqDto dto) throws BaseException {
        return projectService.get(dto);
    }

    @RequestMapping(value = "/get_search_scope", method = RequestMethod.GET)
    @ApiOperation("获取所有范围")
    public Result<List<ProjectScopeDto>> add() throws BaseException {
        return HttpUtils.get(AmUrl.GET_PROJECT_SCOPE, null, new BaseTypeReference<Result<List<ProjectScopeDto>>>() {
        });
    }

    @RequestMapping(value = "/update_only", method = RequestMethod.POST)
    @ApiOperation("单项修改项目详情")
    public Result<Long> updateOnly(@ModelAttribute UpdateOnlyReqDto dto) throws BaseException {
        return projectService.updateOnly(dto);
    }

    @RequestMapping(value = "/update_multiple", method = RequestMethod.POST)
    @ApiOperation("单项编辑支持多个")
    public Result<Integer> updateMultiple(String data) throws Exception {
        JavaType javaType = JsonUtils.getCollectionType(List.class, UpdateOnlyReqDto.class);
        List<UpdateOnlyReqDto> reqDtos = JsonUtils.jsonToObject(data,javaType);
        return projectService.updateMultiple(reqDtos);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation("删除项目")
    public Result<PermissionResultDto> delete(@ModelAttribute ProjectIdsReqDto dto) throws BaseException {
        return projectService.delete(dto);
    }

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation("获取项目分页数据")
    public Result<PaginationSupport<ProjectPageResDto>> getPage(@ModelAttribute ProjectPageReqDto dto) throws
            BaseException {
        return projectService.getPage(dto);
    }

    @RequestMapping(value = "/get_select", method = RequestMethod.GET)
    @ApiOperation("获取项目数据")
    public Result<List<ProjectPageResDto>> getSelect(@ModelAttribute ProjectSelectReqDto reqDto) throws
            BaseException {
        ProjectPageReqDto dto = new ProjectPageReqDto();
        BeanUtils.copyProperties(reqDto,dto);
        dto.setPageSize(Integer.MAX_VALUE);
        Result<PaginationSupport<ProjectPageResDto>> resDto = projectService.getPage(dto);
        if(resDto != null && resDto.getResult() != null){
            return Result.newSuccessResult(resDto.getResult().getDatas());
        }
        return Result.newSuccessResult();
    }

    @RequestMapping(value = "/get_select_investment", method = RequestMethod.GET)
    @ApiOperation("获取已经投资的项目")
    public Result<PaginationSupport<ProjectSelectResDto>> getSelectInvestment(@ModelAttribute ProjectInvestmentSelectReqDto dto) throws BaseException{
        return HttpUtils.get(AmUrl.GET_PROJECT_INVESTMENT_SELECT, ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<ProjectSelectResDto>>>() {
        });
    }

}
