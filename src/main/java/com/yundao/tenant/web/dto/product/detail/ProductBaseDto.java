package com.yundao.tenant.web.dto.product.detail;

import com.yundao.tenant.web.dto.common.DataPermissionDto;

import io.swagger.annotations.ApiModelProperty;

public class ProductBaseDto {
	@ApiModelProperty("产品信息字段和销售信息")
    private ProductFieldDto data;
	@ApiModelProperty("权限")
	private DataPermissionDto permission;
	public ProductFieldDto getData() {
		return data;
	}
	public void setData(ProductFieldDto data) {
		this.data = data;
	}
	public DataPermissionDto getPermission() {
		return permission;
	}
	public void setPermission(DataPermissionDto permission) {
		this.permission = permission;
	}
	
}
