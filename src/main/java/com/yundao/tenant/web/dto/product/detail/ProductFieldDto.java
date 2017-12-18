package com.yundao.tenant.web.dto.product.detail;

import java.util.List;

import com.yundao.tenant.web.dto.field.FieldDetailDto;

import io.swagger.annotations.ApiModelProperty;

public class ProductFieldDto {
	@ApiModelProperty("产品信息字段")
	private List<FieldDetailDto> productFieldDtos;
	
	@ApiModelProperty("销售信息")
	private List<FieldDetailDto> productSaleFieldDtos;

	public List<FieldDetailDto> getProductFieldDtos() {
		return productFieldDtos;
	}

	public void setProductFieldDtos(List<FieldDetailDto> productFieldDtos) {
		this.productFieldDtos = productFieldDtos;
	}

	public List<FieldDetailDto> getProductSaleFieldDtos() {
		return productSaleFieldDtos;
	}

	public void setProductSaleFieldDtos(List<FieldDetailDto> productSaleFieldDtos) {
		this.productSaleFieldDtos = productSaleFieldDtos;
	}
	
}
