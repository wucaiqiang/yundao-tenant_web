package com.yundao.tenant.web.dto.withdrawal;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by gjl on 2017/11/25.
 */
public class WithdrawalFundPageResDto{
    @ApiModelProperty("项目ID")
    private Long projectId;

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("已退出总额")
    private Double totalWithdrawalAmount;

    @ApiModelProperty("已退出股份")
    private Double totalWithdrawalRatio;

    @ApiModelProperty("投資总额")
    private Double totalInvestmentAmount;

    @ApiModelProperty("投資占股股份")
    private Double totalInvestmentRatio;

    @ApiModelProperty("剩余股份")
    private Double remainingRatio;

    @ApiModelProperty("退出的信息")
    private List<WithdrawalInfoResDto> withdrawalInfoList;


    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Double getTotalWithdrawalAmount() {
        return totalWithdrawalAmount;
    }

    public void setTotalWithdrawalAmount(Double totalWithdrawalAmount) {
        this.totalWithdrawalAmount = totalWithdrawalAmount;
    }

    public Double getTotalWithdrawalRatio() {
        return totalWithdrawalRatio;
    }

    public void setTotalWithdrawalRatio(Double totalWithdrawalRatio) {
        this.totalWithdrawalRatio = totalWithdrawalRatio;
    }

    public Double getRemainingRatio() {
        return remainingRatio;
    }

    public void setRemainingRatio(Double remainingRatio) {
        this.remainingRatio = remainingRatio;
    }

    public List<WithdrawalInfoResDto> getWithdrawalInfoList() {
        return withdrawalInfoList;
    }

    public void setWithdrawalInfoList(List<WithdrawalInfoResDto> withdrawalInfoList) {
        this.withdrawalInfoList = withdrawalInfoList;
    }

    public Double getTotalInvestmentAmount() {
        return totalInvestmentAmount;
    }

    public void setTotalInvestmentAmount(Double totalInvestmentAmount) {
        this.totalInvestmentAmount = totalInvestmentAmount;
    }

    public Double getTotalInvestmentRatio() {
        return totalInvestmentRatio;
    }

    public void setTotalInvestmentRatio(Double totalInvestmentRatio) {
        this.totalInvestmentRatio = totalInvestmentRatio;
    }
}
