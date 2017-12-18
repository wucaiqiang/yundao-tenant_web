package com.yundao.tenant.web.dto.project.decision;


import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 立项详情
 *
 * @author jan
 * @create 2017-11-19 14:06
 **/
public class DecisionDetailResDto {

    @ApiModelProperty(value = "立项id")
    private Long id;

    @ApiModelProperty(value = "投前估值")
    private String valuationBefore;

    @ApiModelProperty(value = "当前状态")
    private Integer status;

    @ApiModelProperty(value = "当前状态文本")
    private String statusText;

    @ApiModelProperty(value = "投资主体id")
    private Long fundId;

    @ApiModelProperty(value = "投资主体")
    private String fundName;

    @ApiModelProperty(value = "领投/跟投")
    private Integer investLevel;

    @ApiModelProperty(value = "领投/跟投 文本")
    private String investLevelText;

    @ApiModelProperty(value = "投资金额")
    private String investmentAmount;

    @ApiModelProperty(value = "投资轮次")
    private Integer round;

    @ApiModelProperty(value = "投资轮次 文本")
    private String roundText;

    @ApiModelProperty(value = "占股比例")
    private String shareRatio;

    @ApiModelProperty(value = "投后估值")
    private String valuationAfter;

    @ApiModelProperty(value = "投资方式")
    private Integer investType;

    @ApiModelProperty(value = "投资方式文本")
    private String investTypeText;

    @ApiModelProperty(value = "是否已结束，1：是，0：否")
    private Integer isOver;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "是否出资")
    private Integer investOrNot;

    @ApiModelProperty(value = "是否出资文本")
    private String investOrNotText;

    @ApiModelProperty(value = "流程节点")
    private List<DecisionFlowDto> decisionFlowDtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValuationBefore() {
        return valuationBefore;
    }

    public void setValuationBefore(String valuationBefore) {
        this.valuationBefore = valuationBefore;
    }

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public Integer getInvestLevel() {
        return investLevel;
    }

    public void setInvestLevel(Integer investLevel) {
        this.investLevel = investLevel;
    }

    public String getInvestLevelText() {
        return investLevelText;
    }

    public void setInvestLevelText(String investLevelText) {
        this.investLevelText = investLevelText;
    }

    public String getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(String investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public String getRoundText() {
        return roundText;
    }

    public void setRoundText(String roundText) {
        this.roundText = roundText;
    }

    public String getShareRatio() {
        return shareRatio;
    }

    public void setShareRatio(String shareRatio) {
        this.shareRatio = shareRatio;
    }

    public String getValuationAfter() {
        return valuationAfter;
    }

    public void setValuationAfter(String valuationAfter) {
        this.valuationAfter = valuationAfter;
    }

    public Integer getInvestType() {
        return investType;
    }

    public void setInvestType(Integer investType) {
        this.investType = investType;
    }

    public String getInvestTypeText() {
        return investTypeText;
    }

    public void setInvestTypeText(String investTypeText) {
        this.investTypeText = investTypeText;
    }

    public List<DecisionFlowDto> getDecisionFlowDtos() {
        return decisionFlowDtos;
    }

    public void setDecisionFlowDtos(List<DecisionFlowDto> decisionFlowDtos) {
        this.decisionFlowDtos = decisionFlowDtos;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Integer getIsOver() {
        return isOver;
    }

    public void setIsOver(Integer isOver) {
        this.isOver = isOver;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getInvestOrNot() {
        return investOrNot;
    }

    public void setInvestOrNot(Integer investOrNot) {
        this.investOrNot = investOrNot;
    }

    public String getInvestOrNotText() {
        return investOrNotText;
    }

    public void setInvestOrNotText(String investOrNotText) {
        this.investOrNotText = investOrNotText;
    }
}
