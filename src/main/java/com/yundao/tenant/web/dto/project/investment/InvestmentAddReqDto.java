package com.yundao.tenant.web.dto.project.investment;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by gjl on 2017/11/25.
 */
public class InvestmentAddReqDto {

    @ApiModelProperty("项目Id")
    private Long projectId;

    @ApiModelProperty(value = "基金ID")
    private Long fundId;

    @ApiModelProperty("轮次ID")
    private Integer round;

    @ApiModelProperty("投资金额")
    private Double investAmount;

    @ApiModelProperty("投资占股比例")
    private Double shareRatio;

    @ApiModelProperty("投资等级 1、领投  2、跟投")
    private Integer investLevel;

    @ApiModelProperty("投前估值")
    private Double valuationBefore;

    @ApiModelProperty("投后估值")
    private Double valuationAfter;

    @ApiModelProperty("投资方式 1、增资  2、股权转让  3、增资&股权转让")
    private Integer investType;

    @ApiModelProperty("投资日期")
    private Date investDate;


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

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }
}
