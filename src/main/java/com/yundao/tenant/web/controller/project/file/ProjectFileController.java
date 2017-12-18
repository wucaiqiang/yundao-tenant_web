package com.yundao.tenant.web.controller.project.file;

import com.yundao.core.code.Result;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.project.file.BaseAmProjectFile;
import com.yundao.tenant.web.dto.project.file.ProjectFilePageReqDto;
import com.yundao.tenant.web.dto.project.file.ProjectFileReqDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by gjl on 2017/11/17.
 */
@Controller
@RequestMapping("/assets/project/file/")
@ResponseBody
@Api("项目管理-->项目文件")
public class ProjectFileController {

    @RequestMapping(value = "get_page",method= RequestMethod.GET)
    @ApiOperation(value="分页查询项目文件")
    public Result<PaginationSupport<BaseAmProjectFile>> getPage(@ModelAttribute ProjectFilePageReqDto dto) throws Exception{
        Map<String,Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.get(AmUrl.PROJECT_FILE_GETS, params, new BaseTypeReference<Result<PaginationSupport<BaseAmProjectFile>>>() {
        });
    }

    @RequestMapping(value = "add",method= RequestMethod.POST)
    @ApiOperation(value="新增项目文件")
    public Result<Long> add(@ModelAttribute ProjectFileReqDto dto) throws Exception{
        //权限校验
        Map<String,Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.post(AmUrl.PROJECT_FILE_ADD, params, new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "delete",method= RequestMethod.POST)
    @ApiOperation(value="删除项目文件")
    public Result<Integer> delete(@RequestParam Long id) throws Exception{
        return HttpUtils.post(AmUrl.PROJECT_FILE_DELETE, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<Integer>>() {
        });
    }



}
