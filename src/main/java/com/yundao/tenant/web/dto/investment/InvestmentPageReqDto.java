package com.yundao.tenant.web.dto.investment;


import com.yundao.tenant.web.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * 投资分页数据请求dto
 *
 * @author jan
 * @create 2017-11-27 16:44
 **/
public class InvestmentPageReqDto extends AbstractBasePageDto {

    @ApiModelProperty(value = "基金名称")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
