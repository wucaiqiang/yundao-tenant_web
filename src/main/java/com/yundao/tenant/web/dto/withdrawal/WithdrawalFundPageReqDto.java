package com.yundao.tenant.web.dto.withdrawal;

import com.yundao.tenant.web.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by gjl on 2017/11/25.
 */
public class WithdrawalFundPageReqDto extends AbstractBasePageDto{
    @ApiModelProperty("基金ID")
    private Long fundId;

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }
}
