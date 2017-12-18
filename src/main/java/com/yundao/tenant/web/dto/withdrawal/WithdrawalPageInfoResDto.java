package com.yundao.tenant.web.dto.withdrawal;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by gjl on 2017/11/25.
 */
public class WithdrawalPageInfoResDto{

    @ApiModelProperty("剩余股份")
    private Double remainingRatio;

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("项目Id")
    private String projectId;

    @ApiModelProperty("基金ID")
    private Long fundId;

    @ApiModelProperty("退出总金额")
    private Double totalWithdrawalAmount;

    @ApiModelProperty("退出总股份")
    private Double totalWithdrawalShareRaio;

    public Double getRemainingRatio() {
        return remainingRatio;
    }

    public void setRemainingRatio(Double remainingRatio) {
        this.remainingRatio = remainingRatio;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Double getTotalWithdrawalAmount() {
        return totalWithdrawalAmount;
    }

    public void setTotalWithdrawalAmount(Double totalWithdrawalAmount) {
        this.totalWithdrawalAmount = totalWithdrawalAmount;
    }

    public Double getTotalWithdrawalShareRaio() {
        return totalWithdrawalShareRaio;
    }

    public void setTotalWithdrawalShareRaio(Double totalWithdrawalShareRaio) {
        this.totalWithdrawalShareRaio = totalWithdrawalShareRaio;
    }

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }
}
