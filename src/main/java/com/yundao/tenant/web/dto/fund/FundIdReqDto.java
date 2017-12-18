package com.yundao.tenant.web.dto.fund;


import io.swagger.annotations.ApiModelProperty;

/**
 * 基金id
 *
 * @author jan
 * @create 2017-11-25 16:35
 **/
public class FundIdReqDto {

    @ApiModelProperty(value = "基金id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
