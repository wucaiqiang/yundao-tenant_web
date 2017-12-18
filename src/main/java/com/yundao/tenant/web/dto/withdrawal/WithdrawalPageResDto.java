package com.yundao.tenant.web.dto.withdrawal;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by gjl on 2017/11/25.
 */
public class WithdrawalPageResDto{
    @ApiModelProperty("基金名称")
    private String fundName;

    @ApiModelProperty("基金ID")
    private Long fundId;

    @ApiModelProperty("已退出总金额")
    private Double totalWithdrawalAmount;

    @ApiModelProperty("退出信息")
    private List<WithdrawalPageInfoResDto> withdrawalPageInfoList;

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }

    public Double getTotalWithdrawalAmount() {
        return totalWithdrawalAmount;
    }

    public void setTotalWithdrawalAmount(Double totalWithdrawalAmount) {
        this.totalWithdrawalAmount = totalWithdrawalAmount;
    }

    public List<WithdrawalPageInfoResDto> getWithdrawalPageInfoList() {
        return withdrawalPageInfoList;
    }

    public void setWithdrawalPageInfoList(List<WithdrawalPageInfoResDto> withdrawalPageInfoList) {
        this.withdrawalPageInfoList = withdrawalPageInfoList;
    }
}
