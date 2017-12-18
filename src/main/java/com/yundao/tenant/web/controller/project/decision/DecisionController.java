package com.yundao.tenant.web.controller.project.decision;


import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.project.ProjectIdReqDto;
import com.yundao.tenant.web.dto.project.decision.*;
import com.yundao.tenant.web.dto.project.decision.invest.DecisionInvestReqDto;
import com.yundao.tenant.web.service.am.project.decision.DecisionService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 立项控制器
 *
 * @author jan
 * @create 2017-11-17 13:49
 **/
@Controller
@RequestMapping("/assets/project/decision")
@ResponseBody
@Api("项目管理 - 立项投决")
public class DecisionController {

    @Autowired
    private DecisionService decisionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("添加")
    public Result<Long> add(@ModelAttribute DecisionAddReqDto dto) throws BaseException {
        return decisionService.add(dto);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation("获取")
    public Result<DecisionDetailResDto> get(@ModelAttribute DecisionIdReqDto dto) throws BaseException {
        return HttpUtils.get(AmUrl.GET_DECISION, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<DecisionDetailResDto>>() {
                });
    }

    @RequestMapping(value = "/exist_not_over", method = RequestMethod.GET)
    @ApiOperation("检查项目下是否存在未结束的立项")
    public Result<Boolean> checkExistNotOverDescision(@ModelAttribute ProjectIdReqDto dto) throws BaseException {
        return HttpUtils.get(AmUrl.EXIST_NOT_OVER_DECISION, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<Boolean>>() {
                });
    }

    @RequestMapping(value = "/invest/update", method = RequestMethod.POST)
    @ApiOperation("最终决定编辑")
    public Result<Long> update(@ModelAttribute DecisionInvestReqDto dto) throws BaseException {
        return decisionService.updateInvest(dto);
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ApiOperation("发起人 提交操作")
    public Result<Boolean> submit(@ModelAttribute DecisionAuditSubmitReqDto dto) throws BaseException {
        return decisionService.submit(dto);
    }

    @RequestMapping(value = "/audit_decisioning", method = RequestMethod.POST)
    @ApiOperation("立项审批")
    public Result<Boolean> auditDecisioning(@ModelAttribute DecisionAuditReqDto dto) throws BaseException {
        return decisionService.auditDecisioning(dto);
    }

    @RequestMapping(value = "/audit_due_diligence", method = RequestMethod.POST)
    @ApiOperation("尽职调查审批")
    public Result<Boolean> auditDueDiligence(@ModelAttribute DecisionAuditReqDto dto) throws BaseException {
        return decisionService.auditDueDiligence(dto);
    }

    @RequestMapping(value = "/audit_first_trial", method = RequestMethod.POST)
    @ApiOperation("初审审批")
    public Result<Boolean> auditFirstTrial(@ModelAttribute DecisionAuditReqDto dto) throws BaseException {
        return decisionService.auditFirstTrial(dto);
    }

    @RequestMapping(value = "/audit_investment_commission", method = RequestMethod.POST)
    @ApiOperation("投委会审批")
    public Result<Boolean> auditInvestmentCommission(@ModelAttribute DecisionAuditReqDto dto) throws BaseException {
        return decisionService.auditInvestmentCommission(dto);
    }

    @RequestMapping(value = "/audit_invest", method = RequestMethod.POST)
    @ApiOperation("出资审批")
    public Result<Boolean> auditInvest(@ModelAttribute DecisionAuditReqDto dto) throws BaseException {
        return decisionService.auditInvest(dto);
    }

    @RequestMapping(value = "/get_page_over", method = RequestMethod.GET)
    @ApiOperation("获取项目已经结束的历史投决")
    public Result<List<DecisionOverResDto>> getPageOver(@RequestParam Long projectId) throws BaseException {
        Map<String, Object> params = new HashMap<>();
        params.put("projectId", projectId);
        return HttpUtils.get(AmUrl.DECISION_GET_PAGE_OVER, params, new BaseTypeReference<Result<List<DecisionOverResDto>>>() {
        });
    }
}
