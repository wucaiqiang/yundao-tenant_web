package com.yundao.tenant.web.dto.product.income;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class IncomeRuleDetailDto {
	/**
	 * 规则id
	 */
	@ApiModelProperty("收益规则id")
	private Long id;
	
	/**
	 * 备注
	 */
	@ApiModelProperty("收益规则备注")
	private String remark;
	
	/**
	 * 规则名称
	 */
	@ApiModelProperty("收益规则名称")
	private String ruleName;
	/**
	 * 收益详情列表
	 */
	@ApiModelProperty(" 收益详情列表")
    private List<ProductIncomeDetailDto> productIncomeDtos;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public List<ProductIncomeDetailDto> getProductIncomeDtos() {
		return productIncomeDtos;
	}
	public void setProductIncomeDtos(List<ProductIncomeDetailDto> productIncomeDtos) {
		this.productIncomeDtos = productIncomeDtos;
	}
    
}
