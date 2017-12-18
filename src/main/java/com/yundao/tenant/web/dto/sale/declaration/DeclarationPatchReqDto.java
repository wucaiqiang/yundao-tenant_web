
package com.yundao.tenant.web.dto.sale.declaration;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class DeclarationPatchReqDto {
	@ApiModelProperty(value = "产品id")
	private Long productId;
	
	@ApiModelProperty(value = "客户id")
	private Long customerId;
	
    @ApiModelProperty(value = "打款日期")
    private Date payDate;

    @ApiModelProperty(value = "认购金额")
    private Double dealAmount;

    @ApiModelProperty(value = "备注")
    private String remark;

    public Long getProductId() {
	
		return productId;
	}

	public void setProductId(Long productId) {
	
		this.productId = productId;
	}

	public Long getCustomerId() {
	
		return customerId;
	}

	public void setCustomerId(Long customerId) {
	
		this.customerId = customerId;
	}

    public Date getPayDate (){
        return payDate;
    }

    public void setPayDate (Date payDate){
        this.payDate = payDate;
    }

    public String getRemark (){
        return remark;
    }

    public void setRemark (String remark){
        this.remark = remark;
    }

    public Double getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(Double dealAmount) {
        this.dealAmount = dealAmount;
    }
}
