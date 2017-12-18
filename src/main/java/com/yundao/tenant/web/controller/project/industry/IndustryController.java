package com.yundao.tenant.web.controller.project.industry;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.project.industry.IndustryAddReqDto;
import com.yundao.tenant.web.dto.project.industry.IndustryDelReqDto;
import com.yundao.tenant.web.dto.project.industry.IndustryResDto;
import com.yundao.tenant.web.dto.project.industry.IndustryUpdateReqDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 行业领域控制器
 *
 * @author jan
 * @create 2017-11-18 08:52
 **/
@Controller
@ResponseBody
@RequestMapping("/assets/project/industry")
@Api("项目管理 - 行业领域")
public class IndustryController {


    @RequestMapping(value = "/gets", method = RequestMethod.GET)
    @ApiOperation("获取列表")
    private Result<List<IndustryResDto>> getList() throws BaseException {
        return HttpUtils.get(AmUrl.GETS_PROJECT_INDUSTRY, null, new BaseTypeReference<Result<List<IndustryResDto>>>() {
        });
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("添加")
    private Result<Long> insert(@ModelAttribute IndustryAddReqDto dto) throws BaseException {
        return HttpUtils.post(AmUrl.ADD_PROJECT_INDUSTRY, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<Long>>() {
                });
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation("更新")
    private Result<Long> update(@ModelAttribute IndustryUpdateReqDto dto) throws
            BaseException {
        return HttpUtils.post(AmUrl.UPDATE_PROJECT_INDUSTRY, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<Long>>() {
                });
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation("删除")
    private Result<Boolean> delete(@ModelAttribute IndustryDelReqDto dto) throws
            BaseException {
        return HttpUtils.post(AmUrl.DELETE_PROJECT_INDUSTRY, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<Boolean>>() {
                });
    }

}
