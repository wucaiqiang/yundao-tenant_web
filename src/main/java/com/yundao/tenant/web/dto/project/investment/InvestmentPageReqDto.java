package com.yundao.tenant.web.dto.project.investment;

import com.yundao.tenant.web.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by gjl on 2017/11/25.
 */
public class InvestmentPageReqDto extends AbstractBasePageDto{
    @ApiModelProperty(value = "基金名称")
    private String fundName;

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }
}
