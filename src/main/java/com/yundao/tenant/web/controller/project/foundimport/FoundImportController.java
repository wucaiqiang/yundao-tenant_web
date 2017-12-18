package com.yundao.tenant.web.controller.project.foundimport;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.project.financing.*;
import com.yundao.tenant.web.dto.project.foundimport.FoundImportPageReqDto;
import com.yundao.tenant.web.dto.project.foundimport.FoundImportPageResDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by gjl on 2017/11/17.
 */
@Controller
@RequestMapping("/assets/project/found/")
@ResponseBody
@Api("项目管理 - 项目成立导入")
public class FoundImportController {

    @RequestMapping(value = "/get_list", method = RequestMethod.GET)
    @ApiOperation("获取需要导入成立的项目管理")
    public Result<List<FoundImportPageResDto>> getPage(@ModelAttribute FoundImportPageReqDto dto) throws Exception{
        Map<String,Object> params = ArgsUtils.toMap(dto);
        params.put("isImport", CommonConstant.ZERO);
        params.put("isClear", CommonConstant.ZERO);
        return HttpUtils.get(AmUrl.FOUND_GET_LIST, params, new BaseTypeReference<Result<List<FoundImportPageResDto>>>() {
        });
    }

    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    @ApiOperation("关闭项目导入")
    public Result<Long> clear(@RequestParam Long id) throws BaseException {
        return HttpUtils.post(AmUrl.FOUND_CLEAR, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "/import", method = RequestMethod.POST)
    @ApiOperation("项目导入")
    public Result<Long> foundImport(@RequestParam Long id) throws BaseException {
        return HttpUtils.post(AmUrl.FOUND_IMPORT, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<Long>>() {
        });
    }
}
