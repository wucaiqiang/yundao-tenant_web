package com.yundao.tenant.web.dto.project.industry;

import io.swagger.annotations.ApiModelProperty;

/**
 * 添加行业
 *
 * @author jan
 * @create 2017-11-18 08:15
 **/
public class IndustryAddReqDto {

    @ApiModelProperty(value = "名称")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}