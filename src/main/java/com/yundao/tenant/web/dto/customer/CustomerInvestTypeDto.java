

package com.yundao.tenant.web.dto.customer;

import com.yundao.tenant.web.model.customer.BaseCustomerInvestType;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年8月10日 下午4:03:27 
 * @author   wucq
 * @version   
 */
public class CustomerInvestTypeDto extends BaseCustomerInvestType {

	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 投资偏好中文名
	 */
	private String productTypeIdText;
	public String getProductTypeIdText() {
	
		return productTypeIdText;
	}
	public void setProductTypeIdText(String productTypeIdText) {
	
		this.productTypeIdText = productTypeIdText;
	}
	

}

