package com.yundao.tenant.web.dto.product.detail;

import java.util.List;

import com.yundao.tenant.web.dto.common.DataPermissionDto;
import com.yundao.tenant.web.dto.product.supplier.ProductSupplierQuotationDetailDto;

import io.swagger.annotations.ApiModelProperty;

public class ProductSupplierDto {
	/**
	 * 供应商报价
	 */
	@ApiModelProperty("供应商报价数据")
	private List<ProductSupplierQuotationDetailDto> data;
	@ApiModelProperty("权限")
	private DataPermissionDto permission;

	public DataPermissionDto getPermission() {
		return permission;
	}
	public void setPermission(DataPermissionDto permission) {
		this.permission = permission;
	}
	public List<ProductSupplierQuotationDetailDto> getData() {
		return data;
	}
	public void setData(List<ProductSupplierQuotationDetailDto> data) {
		this.data = data;
	}
	
}
