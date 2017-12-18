package com.yundao.tenant.web.dto.project.decision;

import com.yundao.core.base.model.BaseModel;

import java.io.Serializable;
import java.util.Date;

public class BaseAmDecision extends BaseModel implements Serializable {
    /**
	 * 项目id
	 */
    private Long projectId;

    /**
	 * 轮次
	 */
    private Integer round;

    /**
	 * 状态
	 */
    private Integer status;

    /**
	 * 是否已结束，1：是，0：否
	 */
    private Integer isOver;

    /**
	 * 流程发起人
	 */
    private Long applyUserId;

    /**
	 * 最后审批原因
	 */
    private String auditRemark;

    /**
	 * 发起时间
	 */
    private Date applytDate;

    private static final long serialVersionUID = 1L;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsOver() {
        return isOver;
    }

    public void setIsOver(Integer isOver) {
        this.isOver = isOver;
    }

    public Long getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Long applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    public Date getApplytDate() {
        return applytDate;
    }

    public void setApplytDate(Date applytDate) {
        this.applytDate = applytDate;
    }
}