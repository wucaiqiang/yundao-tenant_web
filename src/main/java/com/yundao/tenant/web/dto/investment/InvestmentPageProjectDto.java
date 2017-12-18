package com.yundao.tenant.web.dto.investment;


import io.swagger.annotations.ApiModelProperty;

/**
 * 投资项目
 *
 * @author jan
 * @create 2017-11-27 16:22
 **/
public class InvestmentPageProjectDto {

    @ApiModelProperty(value = "项目id")
    private Long id;

    @ApiModelProperty(value = "基金id")
    private Long fundId;

    @ApiModelProperty(value = "项目名称")
    private String name;

    @ApiModelProperty(value = "轮次")
    private Integer round;

    @ApiModelProperty(value = "轮次文本")
    private String roundText;

    @ApiModelProperty(value = "投资金额")
    private Double investAmount;

    @ApiModelProperty(value = "占股比例")
    private Double shareRatio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoundText() {
        return roundText;
    }

    public void setRoundText(String roundText) {
        this.roundText = roundText;
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

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }
}
