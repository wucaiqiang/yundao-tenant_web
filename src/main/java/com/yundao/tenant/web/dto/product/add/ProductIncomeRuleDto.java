package com.yundao.tenant.web.dto.product.add;

import java.util.List;

public class ProductIncomeRuleDto {

    /**
	 * 规则名称
	 */
    private String ruleName;

    /**
	 * 备注
	 */
    private String remark;
    
    /**
     * 收益
     */
    private List<ProductIncomeDto> productIncomeDtos;


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


	public List<ProductIncomeDto> getProductIncomeDtos() {
		return productIncomeDtos;
	}


	public void setProductIncomeDtos(List<ProductIncomeDto> productIncomeDtos) {
		this.productIncomeDtos = productIncomeDtos;
	}
    
    
}
