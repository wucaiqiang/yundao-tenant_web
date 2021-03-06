package com.yundao.tenant.web.service.customer;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by gjl on 2017/9/18.
 */
public class UpdateAssejtsDto {
    @ApiModelProperty("客户资产附件")
    private String assets;

    @ApiModelProperty("客户ID")
    private Long id;

    @ApiModelProperty("投资者类型")
    private Integer type;

    public String getAssets() {
        return assets;
    }

    public void setAssets(String assets) {
        this.assets = assets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
