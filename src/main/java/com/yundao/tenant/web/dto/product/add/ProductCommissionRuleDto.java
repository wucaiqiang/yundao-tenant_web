package com.yundao.tenant.web.dto.product.add;

import java.util.List;

public class ProductCommissionRuleDto {
	
	/**
	 * 规则名称
	 */
	private String ruleName;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 佣金详情
	 */
    private List<ProductCommissionDto> productCommissionDtos;


	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<ProductCommissionDto> getProductCommissionDtos() {
		return productCommissionDtos;
	}

	public void setProductCommissionDtos(List<ProductCommissionDto> productCommissionDtos) {
		this.productCommissionDtos = productCommissionDtos;
	}
    
    
}
