package com.yundao.tenant.web.dto.project.fund.income;

import java.util.List;

public class IncomeRuleDetailDto {
	/**
	 * 规则id
	 */
	private Long id;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 规则名称
	 */
	private String ruleName;
	/**
	 * 佣金详情列表
	 */
    private List<FundIncomeDetailDto> FundIncomeDtos;
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
	public List<FundIncomeDetailDto> getFundIncomeDtos() {
		return FundIncomeDtos;
	}
	public void setFundIncomeDtos(List<FundIncomeDetailDto> FundIncomeDtos) {
		this.FundIncomeDtos = FundIncomeDtos;
	}
    
}
