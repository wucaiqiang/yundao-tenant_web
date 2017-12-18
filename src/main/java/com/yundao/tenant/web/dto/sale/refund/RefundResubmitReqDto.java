package com.yundao.tenant.web.dto.sale.refund;

import io.swagger.annotations.ApiModelProperty;

/**
 * 我的报单申请审核请求数据dto
 *
 * @author jan
 * @create 2017-08-25 AM11:39
 **/
public class RefundResubmitReqDto {

    @ApiModelProperty(value = "退款id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
