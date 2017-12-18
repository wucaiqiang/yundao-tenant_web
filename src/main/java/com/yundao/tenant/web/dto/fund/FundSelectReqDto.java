package com.yundao.tenant.web.dto.fund;


import io.swagger.annotations.ApiModelProperty;

/**
 * 基金选项
 *
 * @author jan
 * @create 2017-11-25 18:06
 **/
public class FundSelectReqDto {

    @ApiModelProperty(value = "基金名称")
    private String name;

    @ApiModelProperty(value = "获取条数，默认20")
    private Integer count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
