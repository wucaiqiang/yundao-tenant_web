

package com.yundao.tenant.web.dto.sale.refund;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月16日 下午5:36:39 
 * @author   欧阳利
 * @version   
 */
public class RefundAuditReqDto {
    @ApiModelProperty(value = "退款id")
    private Long id;
    
    @ApiModelProperty(value = "动作，1：通过  2：驳回 ")
    private Integer action;

    @ApiModelProperty(value = "驳回/取消原因")
    private String reason;

	public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}

	public Integer getAction() {
	
		return action;
	}

	public void setAction(Integer action) {
	
		this.action = action;
	}

	public String getReason() {
	
		return reason;
	}

	public void setReason(String reason) {
	
		this.reason = reason;
	}


    
    
}

