package com.yundao.tenant.web.dto.project.investment;

import com.yundao.tenant.web.dto.AbstractBasePageDto;

/**
 * Created by gjl on 2017/11/25.
 */
public class InvestmentFundPageReqDto extends AbstractBasePageDto{
    private String fundId;

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }
}
