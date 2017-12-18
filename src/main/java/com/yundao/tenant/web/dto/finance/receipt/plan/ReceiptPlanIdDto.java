package com.yundao.tenant.web.dto.finance.receipt.plan;


import io.swagger.annotations.ApiModelProperty;

/**
 * 回款计划id
 *
 * @author jan
 * @create 2017-10-18 21:10
 **/
public class ReceiptPlanIdDto {

    @ApiModelProperty(value = "回款计划id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}