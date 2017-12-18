package com.yundao.tenant.web.dto.finance.receipt.plan;

import io.swagger.annotations.ApiModelProperty;

/**
 * 回款计划请求dto
 *
 * @author jan
 * @create 2017-10-12 13:56
 **/
public class ReceiptPlanAddReqDto {

    @ApiModelProperty(value = "回款计划名称")
    private String name;

    @ApiModelProperty(value = "回款产品id")
    private Long productId;

    @ApiModelProperty(value = "供应商id")
    private Long supplierId;

    @ApiModelProperty(value = "计划回款金额")
    private Double amount;

    @ApiModelProperty(value = "回款单位")
    private String payUnit;

    @ApiModelProperty(value = "回款备注")
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPayUnit() {
        return payUnit;
    }

    public void setPayUnit(String payUnit) {
        this.payUnit = payUnit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
