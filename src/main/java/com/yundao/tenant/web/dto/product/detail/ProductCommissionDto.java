package com.yundao.tenant.web.dto.product.detail;

import java.util.List;

import com.yundao.tenant.web.dto.common.DataPermissionDto;
import com.yundao.tenant.web.dto.product.commission.ProductCommissionRuleDetailDto;

import io.swagger.annotations.ApiModelProperty;

public class ProductCommissionDto {
	/**
	 * 佣金规则
	 */
	@ApiModelProperty("佣金规则数据")
	private List<ProductCommissionRuleDetailDto> data;
	@ApiModelProperty("权限")
	private DataPermissionDto permission;

	public DataPermissionDto getPermission() {
		return permission;
	}
	public void setPermission(DataPermissionDto permission) {
		this.permission = permission;
	}
	public List<ProductCommissionRuleDetailDto> getData() {
		return data;
	}
	public void setData(List<ProductCommissionRuleDetailDto> data) {
		this.data = data;
	}
	
}
