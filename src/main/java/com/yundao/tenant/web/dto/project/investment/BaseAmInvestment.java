package com.yundao.tenant.web.dto.project.investment;

import com.yundao.core.base.model.BaseModel;

import java.io.Serializable;
import java.util.Date;

public class BaseAmInvestment extends BaseModel implements Serializable {
    /**
	 * 基金ID
	 */
    private Long fundId;

    /**
	 * 项目ID
	 */
    private Long projectId;

    /**
	 * 投资轮次
	 */
    private Integer round;

    /**
	 * 投资金额
	 */
    private Double investAmount;

    /**
	 * 投资占股比例
	 */
    private Double shareRatio;

    /**
	 * 投资等级 1、领投  2、跟投
	 */
    private Integer investLevel;

    /**
	 * 投前估值
	 */
    private Double valuationBefore;

    private Double valuationAfter;

    /**
	 * 1、增资  2、股权转让  3、增资&股权转让
	 */
    private Integer investType;

    /**
	 * 投资日期
	 */
    private Date investDate;

    private static final long serialVersionUID = 1L;

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }

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

    public Double getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(Double investAmount) {
        this.investAmount = investAmount;
    }

    public Double getShareRatio() {
        return shareRatio;
    }

    public void setShareRatio(Double shareRatio) {
        this.shareRatio = shareRatio;
    }

    public Integer getInvestLevel() {
        return investLevel;
    }

    public void setInvestLevel(Integer investLevel) {
        this.investLevel = investLevel;
    }

    public Double getValuationBefore() {
        return valuationBefore;
    }

    public void setValuationBefore(Double valuationBefore) {
        this.valuationBefore = valuationBefore;
    }

    public Double getValuationAfter() {
        return valuationAfter;
    }

    public void setValuationAfter(Double valuationAfter) {
        this.valuationAfter = valuationAfter;
    }

    public Integer getInvestType() {
        return investType;
    }

    public void setInvestType(Integer investType) {
        this.investType = investType;
    }

    public Date getInvestDate() {
        return investDate;
    }

    public void setInvestDate(Date investDate) {
        this.investDate = investDate;
    }
}