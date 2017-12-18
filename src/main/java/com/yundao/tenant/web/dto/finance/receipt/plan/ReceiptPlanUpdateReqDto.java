package com.yundao.tenant.web.dto.finance.receipt.plan;


import io.swagger.annotations.ApiModelProperty;

/**
 * 回款计划更新数据请求dto
 *
 * @author jan
 * @create 2017-10-13 18:23
 **/
public class ReceiptPlanUpdateReqDto {

    @ApiModelProperty(value = "回款计划id")
    private Long id;

    @ApiModelProperty(value = "回款计划名称")
    private String name;

    @ApiModelProperty(value = "计划回款金额")
    private Double amount;

    @ApiModelProperty(value = "回款单位")
    private String payUnit;

    @ApiModelProperty(value = "回款备注")
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
