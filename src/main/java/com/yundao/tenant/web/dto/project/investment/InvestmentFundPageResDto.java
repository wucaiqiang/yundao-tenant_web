package com.yundao.tenant.web.dto.project.investment;

import java.util.List;

/**
 * Created by gjl on 2017/11/27.
 */
public class InvestmentFundPageResDto {
    private String projectName;
    private Long projectId;
    private Double totalAmount;
    private Double totalRatio;
    private Double withdrawalAmount;
    private Double withdrawalRatio;
    List<InvestmentProjectResDto> projectResDtoList;

    public Double getTotalRatio() {
        return totalRatio;
    }

    public void setTotalRatio(Double totalRatio) {
        this.totalRatio = totalRatio;
    }


    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<InvestmentProjectResDto> getProjectResDtoList() {
        return projectResDtoList;
    }

    public void setProjectResDtoList(List<InvestmentProjectResDto> projectResDtoList) {
        this.projectResDtoList = projectResDtoList;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(Double withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public Double getWithdrawalRatio() {
        return withdrawalRatio;
    }

    public void setWithdrawalRatio(Double withdrawalRatio) {
        this.withdrawalRatio = withdrawalRatio;
    }
}
