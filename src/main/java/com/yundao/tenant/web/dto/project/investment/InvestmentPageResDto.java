package com.yundao.tenant.web.dto.project.investment;

import java.util.List;

/**
 * Created by gjl on 2017/11/27.
 */
public class InvestmentPageResDto{
    private String fundName;
    private Long fundId;
    private Double totalAmount;
    private Double totalInvestedAmount;
    private Double totalRatio;
    List<InvestmentProjectResDto> projectResDtoList;

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }

    public Double getTotalRatio() {
        return totalRatio;
    }

    public void setTotalRatio(Double totalRatio) {
        this.totalRatio = totalRatio;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getTotalInvestedAmount() {
        return totalInvestedAmount;
    }

    public void setTotalInvestedAmount(Double totalInvestedAmount) {
        this.totalInvestedAmount = totalInvestedAmount;
    }

    public List<InvestmentProjectResDto> getProjectResDtoList() {
        return projectResDtoList;
    }

    public void setProjectResDtoList(List<InvestmentProjectResDto> projectResDtoList) {
        this.projectResDtoList = projectResDtoList;
    }

}
