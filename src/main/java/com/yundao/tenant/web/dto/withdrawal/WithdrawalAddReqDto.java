package com.yundao.tenant.web.dto.withdrawal;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by gjl on 2017/11/25.
 */
public class WithdrawalAddReqDto {
    @ApiModelProperty("项目ID")
    private Long projectId;

    @ApiModelProperty("基金ID")
    private Long fundId;

    @ApiModelProperty("退出方式 1、被并购  2、IPO上市  3、股权转让")
    private Integer withdrawalType;

    @ApiModelProperty("退出金额")
    private Double withdrawalAmount;

    @ApiModelProperty("退出占股比例")
    private Double withdrawalShareRatio;

    @ApiModelProperty("投资日期")
    private Date withdrawalDate;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
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
