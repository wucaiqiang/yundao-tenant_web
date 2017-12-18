package com.yundao.tenant.web.dto.finance.receipt.plan;

import io.swagger.annotations.ApiModelProperty;

/**
 * 关联报单请求dto
 *
 * @author jan
 * @create 2017-10-16 08:24
 **/
public class DeclarationRelAddReqDto {

    @ApiModelProperty(value = "回款计划id")
    private Long receiptPlanId;

    @ApiModelProperty(value = "报单id，多个逗号分隔")
    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public Long getReceiptPlanId() {
        return receiptPlanId;
    }

    public void setReceiptPlanId(Long receiptPlanId) {
        this.receiptPlanId = receiptPlanId;
    }
}
