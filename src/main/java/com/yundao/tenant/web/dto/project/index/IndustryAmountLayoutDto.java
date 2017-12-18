

package com.yundao.tenant.web.dto.project.index;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月22日 下午5:36:13 
 * @author   欧阳利
 * @version   
 */
public class IndustryAmountLayoutDto {
	@ApiModelProperty("行业id")
	private Long id;
	@ApiModelProperty("行业名称")
    private String name;
	@ApiModelProperty("投资净额")
    private Double sumAmount;
	public String getName() {
	
		return name;
	}
	public void setName(String name) {
	
		this.name = name;
	}
	public Double getSumAmount() {
	
		return sumAmount;
	}
	public void setSumAmount(Double sumAmount) {
	
		this.sumAmount = sumAmount;
	}

	
}

