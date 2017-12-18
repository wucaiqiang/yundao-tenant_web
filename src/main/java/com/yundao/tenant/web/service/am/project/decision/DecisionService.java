package com.yundao.tenant.web.service.am.project.decision;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.web.dto.project.decision.DecisionAddReqDto;
import com.yundao.tenant.web.dto.project.decision.DecisionAuditReqDto;
import com.yundao.tenant.web.dto.project.decision.DecisionAuditSubmitReqDto;
import com.yundao.tenant.web.dto.project.decision.invest.DecisionInvestReqDto;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 立项投决服务接口
 *
 * @author jan
 * @create 2017-11-20 19:13
 **/
public interface DecisionService {

    /**
     * 添加立项
     */
    Result<Long> add(DecisionAddReqDto dto) throws BaseException;

    /**
     * 编辑最终决定
     */
    Result<Long> updateInvest(DecisionInvestReqDto dto) throws BaseException;

    /**
     * 发起人 提交操作
     */
    Result<Boolean> submit(@ModelAttribute DecisionAuditSubmitReqDto dto) throws BaseException;

    /**
     * 立项审批
     */
    Result<Boolean> auditDecisioning(@ModelAttribute DecisionAuditReqDto dto) throws BaseException;

    /**
     * 尽职调查审批
     */
    Result<Boolean> auditDueDiligence(@ModelAttribute DecisionAuditReqDto dto) throws BaseException;

    /**
     * 初审审批
     */
    Result<Boolean> auditFirstTrial(@ModelAttribute DecisionAuditReqDto dto) throws BaseException;

    /**
     * 投委会审批
     */
    Result<Boolean> auditInvestmentCommission(@ModelAttribute DecisionAuditReqDto dto) throws BaseException;

    /**
     * 出资审批
     */
    Result<Boolean> auditInvest(@ModelAttribute DecisionAuditReqDto dto) throws BaseException;
}

