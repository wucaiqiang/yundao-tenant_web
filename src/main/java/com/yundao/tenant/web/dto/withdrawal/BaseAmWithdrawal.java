package com.yundao.tenant.web.dto.withdrawal;

import com.yundao.core.base.model.BaseModel;

import java.io.Serializable;
import java.util.Date;

public class BaseAmWithdrawal extends BaseModel implements Serializable {
    /**
	 * 基金ID
	 */
    private Long fundId;

    /**
	 * 项目ID
	 */
    private Long projectId;

    /**
	 * 1、被并购  2、IPO上市  3、股权转让
	 */
    private Integer withdrawalType;

    /**
	 * 投资金额
	 */
    private Double withdrawalAmount;

    /**
	 * 投资占股比例
	 */
    private Double withdrawalShareRatio;

    /**
	 * 投资日期
	 */
    private Date withdrawalDate;

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

    public Integer getWithdrawalType() {
        return withdrawalType;
    }

    public void setWithdrawalType(Integer withdrawalType) {
        this.withdrawalType = withdrawalType;
    }

    public Double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(Double withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public Double getWithdrawalShareRatio() {
        return withdrawalShareRatio;
    }

    public void setWithdrawalShareRatio(Double withdrawalShareRatio) {
        this.withdrawalShareRatio = withdrawalShareRatio;
    }

    public Date getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(Date withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }
}