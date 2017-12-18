package com.yundao.tenant.web.dto.sale.declaration;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by gjl on 2017/8/24.
 */
public class DeclarationModel extends BaseDeclaration {
    private String productName;

    private String customerName;

    private String statusName;

    private String createUserName;
    
    
    @ApiModelProperty("是否能申请退款")
    private Boolean canApplyRefund;
    @ApiModelProperty("不能申请退款的提示信息")
    private String notCanApplyRefundTitle;

	public String getNotCanApplyRefundTitle() {
	
		return notCanApplyRefundTitle;
	}

	public void setNotCanApplyRefundTitle(String notCanApplyRefundTitle) {
	
		this.notCanApplyRefundTitle = notCanApplyRefundTitle;
	}

	public Boolean getCanApplyRefund() {
	
		return canApplyRefund;
	}

	public void setCanApplyRefund(Boolean canApplyRefund) {
	
		this.canApplyRefund = canApplyRefund;
	}


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }
}
