package com.yundao.tenant.web.dto.project.foundimport;

import com.yundao.core.base.model.BaseModel;

import java.io.Serializable;

public class BaseAmProjectFoundImport extends BaseModel implements Serializable {
    /**
	 * 项目ID
	 */
    private Long projectId;

    /**
	 * 轮次ID
	 */
    private Long decisionId;

    /**
	 * 投资金额
	 */
    private Double investmentAmount;

    /**
	 * 投资占比
	 */
    private Double shareRatio;

    /**
	 * 导入类型；项目：project，基金：fund
	 */
    private String type;

    /**
	 * 是否已经导入
	 */
    private Integer isImport;

    /**
	 * 是否取消导入
	 */
    private Integer isClear;

    private static final long serialVersionUID = 1L;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getDecisionId() {
        return decisionId;
    }

    public void setDecisionId(Long decisionId) {
        this.decisionId = decisionId;
    }

    public Double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(Double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public Double getShareRatio() {
        return shareRatio;
    }

    public void setShareRatio(Double shareRatio) {
        this.shareRatio = shareRatio;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIsImport() {
        return isImport;
    }

    public void setIsImport(Integer isImport) {
        this.isImport = isImport;
    }

    public Integer getIsClear() {
        return isClear;
    }

    public void setIsClear(Integer isClear) {
        this.isClear = isClear;
    }
}