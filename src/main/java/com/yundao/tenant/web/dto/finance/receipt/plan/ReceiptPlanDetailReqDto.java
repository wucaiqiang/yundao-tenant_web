package com.yundao.tenant.web.dto.finance.receipt.plan;


import io.swagger.annotations.ApiModelProperty;

/**
 * 回款计划详情请求dto
 *
 * @author jan
 * @create 2017-10-13 16:51
 **/
public class ReceiptPlanDetailReqDto {

    @ApiModelProperty(value = "回款计划id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
