package com.yundao.tenant.web.dto.withdrawal;

import com.yundao.tenant.web.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by gjl on 2017/11/25.
 */
public class WithdrawalPageReqDto extends AbstractBasePageDto{
    @ApiModelProperty("基金名称")
    private String fundName;

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }
}
