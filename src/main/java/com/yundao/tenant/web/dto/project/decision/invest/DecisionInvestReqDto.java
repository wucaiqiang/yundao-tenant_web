package com.yundao.tenant.web.dto.project.decision.invest;


import io.swagger.annotations.ApiModelProperty;

/**
 * 立项投决投资信息dto
 *
 * @author jan
 * @create 2017-11-20 18:35
 **/
public class DecisionInvestReqDto {

    /**
     * 立项投决id
     */
    @ApiModelProperty(value = "立项投决id")
    private Long decisionId;

    /**
     * 是否出资，1：是，0：否
     */
    @ApiModelProperty(value = " 是否出资，1：是，0：否")
    private Integer investOrNot;

    /**
     * 投资主体（基金id）
     */
    @ApiModelProperty(value = "投资主体（基金id）")
    private Long fundId;

    /**
     * 出资金额
     */
    @ApiModelProperty(value = "出资金额")
    private Double investmentAmount;

    /**
     * 占股比例
     */
    @ApiModelProperty(value = "占股比例")
    private Double shareRatio;

    /**
     * 投前估值
     */
    @ApiModelProperty(value = "投前估值")
    private Double valuationBefore;

    /**
     * 投后估值
     */
    @ApiModelProperty(value = "投后估值")
    private Double valuationAfter;

    /**
     * 投资等级 1、领投  2、跟投
     */
    @ApiModelProperty(value = "投资等级 1、领投  2、跟投")
    private Integer investLevel;

    /**
     * 投资方式  1、增资  2、股权转让  3、增资&股权转让
     */
    @ApiModelProperty(value = "投资方式")
    private Integer investType;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    public Long getDecisionId() {
        return decisionId;
    }

    public void setDecisionId(Long decisionId) {
        this.decisionId = decisionId;
    }

    public Integer getInvestOrNot() {
        return investOrNot;
    }

    public void setInvestOrNot(Integer investOrNot) {
        this.investOrNot = investOrNot;
    }

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
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

    public Integer getInvestLevel() {
        return investLevel;
    }

    public void setInvestLevel(Integer investLevel) {
        this.investLevel = investLevel;
    }

    public Integer getInvestType() {
        return investType;
    }

    public void setInvestType(Integer investType) {
        this.investType = investType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
