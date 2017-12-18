package com.yundao.tenant.web.controller.project.decision.suggestion;


import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.project.decision.DecisionIdReqDto;
import com.yundao.tenant.web.dto.project.decision.suggestion.*;
import com.yundao.tenant.web.service.am.project.decision.suggestion.DecisionSuggestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 立项意见控制器
 *
 * @author jan
 * @create 2017-11-20 21:23
 **/
@Controller
@RequestMapping("/assets/project/decision/suggestion")
@ResponseBody
@Api("项目管理 - 立项投决 - 意见")
public class DecisionSuggestionController {

    @Autowired
    private DecisionSuggestionService decisionSuggestionService;

    @RequestMapping(value = "/gets", method = RequestMethod.GET)
    @ApiOperation("获取列表")
    public Result<DecisionSuggestionListResDto> add(@ModelAttribute DecisionSuggestionListReqDto dto) throws
            BaseException {
        return decisionSuggestionService.gets(dto);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("添加")
    public Result<Long> add(@ModelAttribute DecisionSuggestionAddReqDto dto) throws
            BaseException {
        return decisionSuggestionService.insert(dto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation("编辑")
    public Result<Long> update(@ModelAttribute DecisionSuggestionUpdateReqDto dto)
            throws
            BaseException {
        return decisionSuggestionService.update(dto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation("删除")
    public Result<PermissionResultDto> delete(@ModelAttribute DecisionSuggestionDelReqDto dto) throws BaseException {
        return decisionSuggestionService.delete(dto);
    }
}
