package com.yundao.tenant.web.service.am.project.decision.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.project.decision.DecisionAddReqDto;
import com.yundao.tenant.web.dto.project.decision.DecisionAuditReqDto;
import com.yundao.tenant.web.dto.project.decision.DecisionAuditSubmitReqDto;
import com.yundao.tenant.web.dto.project.decision.invest.DecisionInvestReqDto;
import com.yundao.tenant.web.service.am.project.DecisionFlowPermissionService;
import com.yundao.tenant.web.service.am.project.DecisionPermissionService;
import com.yundao.tenant.web.service.am.project.ProjectPermissionService;
import com.yundao.tenant.web.service.am.project.decision.DecisionService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 立项投决服务接口
 *
 * @author jan
 * @create 2017-11-20 19:15
 **/
@Service
public class DecisionServiceImpl implements DecisionService {

    @Autowired
    private ProjectPermissionService projectPermissionService;

    @Autowired
    private DecisionPermissionService decisionPermissionService;

    @Autowired
    private DecisionFlowPermissionService decisionFlowPermissionService;

    @Override
    public Result<Long> add(DecisionAddReqDto dto) throws BaseException {
        projectPermissionService.checkEditAndThrow(dto.getProjectId());
        return HttpUtils.post(AmUrl.ADD_DECISION, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @Override
    public Result<Long> updateInvest(DecisionInvestReqDto dto) throws BaseException {
        decisionPermissionService.checkEditAndThrow(dto.getDecisionId());
        return HttpUtils.post(AmUrl.UPDATE_DECISION_INVEST, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @Override
    public Result<Boolean> submit(DecisionAuditSubmitReqDto dto) throws BaseException {
        decisionFlowPermissionService.checkEditAndThrow(dto.getFlowId());
        return HttpUtils.post(AmUrl.SUBMIT_DECISION, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<Boolean>>() {
                });
    }

    @Override
    public Result<Boolean> auditDecisioning(DecisionAuditReqDto dto) throws BaseException {
        decisionPermissionService.checkEditAndThrow(dto.getDecisionId());
        return HttpUtils.post(AmUrl.DECISION_AUDIT_DECISIONING, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<Boolean>>() {
                });
    }

    @Override
    public Result<Boolean> auditDueDiligence(DecisionAuditReqDto dto) throws BaseException {
        decisionPermissionService.checkEditAndThrow(dto.getDecisionId());
        return HttpUtils.post(AmUrl.DECISION_AUDIT_DUE_DILIGENCE, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<Boolean>>() {
                });
    }

    @Override
    public Result<Boolean> auditFirstTrial(DecisionAuditReqDto dto) throws BaseException {
        decisionPermissionService.checkEditAndThrow(dto.getDecisionId());
        return HttpUtils.post(AmUrl.DECISION_AUDIT_FIRST_TRIAL, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<Boolean>>() {
                });
    }

    @Override
    public Result<Boolean> auditInvestmentCommission(DecisionAuditReqDto dto) throws BaseException {
        decisionPermissionService.checkEditAndThrow(dto.getDecisionId());
        return HttpUtils.post(AmUrl.DECISION_AUDIT_INVESTMENT_COMMISSION, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<Boolean>>() {
                });
    }

    @Override
    public Result<Boolean> auditInvest(DecisionAuditReqDto dto) throws BaseException {
        decisionPermissionService.checkEditAndThrow(dto.getDecisionId());
        return HttpUtils.post(AmUrl.DECISION_AUDIT_INVEST, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<Boolean>>() {
                });
    }


}
