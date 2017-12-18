package com.yundao.tenant.web.dto.withdrawal;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by gjl on 2017/11/25.
 */
public class WithdrawalInfoResDto extends BaseAmWithdrawal{
    @ApiModelProperty("退出方式文本")
    private String withdrawalTypeText;

    @ApiModelProperty("估算回报")
    private Double requite;

    @ApiModelProperty("产品名称")
    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getWithdrawalTypeText() {
        return withdrawalTypeText;
    }

    public void setWithdrawalTypeText(String withdrawalTypeText) {
        this.withdrawalTypeText = withdrawalTypeText;
    }

    public Double getRequite() {
        return requite;
    }

    public void setRequite(Double requite) {
        this.requite = requite;
    }
}
