package com.yundao.tenant.web.dto.fund;


import io.swagger.annotations.ApiModelProperty;

/**
 * 基金
 *
 * @author jan
 * @create 2017-11-26 15:46
 **/
public class FundOwnerIdResDto {

    @ApiModelProperty(value = "基金id")
    private Long id;

    @ApiModelProperty(value = "基金负责人id")
    private Long ownerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
