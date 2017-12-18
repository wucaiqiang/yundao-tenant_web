
package com.yundao.tenant.web.dto.project.financing;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class FinancingRoundPageResDto extends BaseAmFinancingRound{

    @ApiModelProperty(value = "总金额")
    private Double totalAmount;

    @ApiModelProperty(value = "总占股比例")
    private Double totalRatio;

    @ApiModelProperty("轮次名称")
    private String roundText;

    @ApiModelProperty("投资方信息")
    private List<FinancingPageResDto> financingPage;

    @ApiModelProperty("用户名称")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public String getRoundText() {
        return roundText;
    }

    public void setRoundText(String roundText) {
        this.roundText = roundText;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getTotalRatio() {
        return totalRatio;
    }

    public void setTotalRatio(Double totalRatio) {
        this.totalRatio = totalRatio;
    }

    public List<FinancingPageResDto> getFinancingPage() {
        return financingPage;
    }

    public void setFinancingPage(List<FinancingPageResDto> financingPage) {
        this.financingPage = financingPage;
    }
}
