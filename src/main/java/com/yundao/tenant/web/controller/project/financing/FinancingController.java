package com.yundao.tenant.web.controller.project.financing;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.project.file.BaseAmProjectFile;
import com.yundao.tenant.web.dto.project.file.ProjectFilePageReqDto;
import com.yundao.tenant.web.dto.project.file.ProjectFileReqDto;
import com.yundao.tenant.web.dto.project.financing.*;
import com.yundao.tenant.web.service.am.project.ProjectPermissionService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by gjl on 2017/11/17.
 */
@Controller
@RequestMapping("/assets/project/financing/")
@ResponseBody
@Api("项目管理 - 融资信息")
public class FinancingController {

    @Autowired
    private ProjectPermissionService projectPermissionService;
    @RequestMapping(value = "get_page",method= RequestMethod.GET)
    @ApiOperation(value="分页查询项目融资信息")
    public Result<PaginationSupport<FinancingRoundPageResDto>> getPage(@ModelAttribute FinancingRoundPageReqDto dto) throws Exception{
        Map<String,Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.get(AmUrl.PROJECT_FINANCING_ROUND_GETS, params, new BaseTypeReference<Result<PaginationSupport<FinancingRoundPageResDto>>>() {
        });
    }

    @RequestMapping(value = "add_round",method= RequestMethod.POST)
    @ApiOperation(value="新增项目融资轮次")
    public Result<Long> addRound(@ModelAttribute FinancingRoundAddReqDto dto) throws Exception{
        boolean isAuth = projectPermissionService.checkEdit(dto.getProjectId());
        if(!isAuth){
            throw new BaseException(CodeConstant.CODE_1220016);
        }
            Map<String,Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.post(AmUrl.PROJECT_FINANCING_ROUND_ADD, params, new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "update_round",method= RequestMethod.POST)
    @ApiOperation(value="修改项目融资轮次")
    public Result<Long> upodateRound(@ModelAttribute FinancingRoundUpadateReqDto dto) throws Exception{
//        boolean isAuth = projectPermissionService.checkEdit(dto.getProjectId());
//        if(!isAuth){
//            throw new BaseException(CodeConstant.CODE_1220016);
//        }
        Map<String,Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.post(AmUrl.PROJECT_FINANCING_ROUND_UPDATE, params, new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "delete_round",method= RequestMethod.POST)
    @ApiOperation(value="删除项目文件")
    public Result<Integer> deleteRound(@RequestParam Long id) throws Exception{
        return HttpUtils.post(AmUrl.PROJECT_FINANCING_ROUND_DELETE, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<Integer>>() {
        });
    }

    @RequestMapping(value = "add_info",method= RequestMethod.POST)
    @ApiOperation(value="新增项目融资信息")
    public Result<Long> addInfo(@ModelAttribute FinancingAddReqDto dto) throws Exception{
        Map<String,Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.post(AmUrl.PROJECT_FINANCING_ADD, params, new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "delete_info",method= RequestMethod.POST)
    @ApiOperation(value="删除项目融资信息")
    public Result<Integer> deleteInfo(@RequestParam Long id) throws Exception{
        return HttpUtils.post(AmUrl.PROJECT_FINANCING_DELETE, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<Integer>>() {
        });
    }

    @RequestMapping(value = "update_info",method= RequestMethod.POST)
    @ApiOperation(value="修改项目融资信息")
    public Result<Long> updateInfo(@ModelAttribute FinancingUpdateReqDto dto) throws Exception{
        Map<String,Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.post(AmUrl.PROJECT_FINANCING_UPDATE, params, new BaseTypeReference<Result<Long>>() {
        });
    }

}
