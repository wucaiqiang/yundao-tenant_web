package com.yundao.tenant.web.dto.product.supplier;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class ProductSupplierQuotationDetailDto {
	/**
	 * 供应商报价id
	 */
	@ApiModelProperty("供应商报价id")
	private Long id;
	
	/**
	 * 供应商名称
	 */
	@ApiModelProperty("供应商名称")
	private String supplierName;
	
    /**
	 * 供应商id
	 */
	@ApiModelProperty("供应商id")
    private Long supplierId;
	
	/**
	 * 备注
	 */
	@ApiModelProperty("供应商报价备注")
	private String remark;
	
	/**
	 * 产品供应商报价
	 */
	@ApiModelProperty("供应商报价详情列表")
    private List<ProductQuotationDetailDto> productQuotationDtos;

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<ProductQuotationDetailDto> getProductQuotationDtos() {
		return productQuotationDtos;
	}

	public void setProductQuotationDtos(List<ProductQuotationDetailDto> productQuotationDtos) {
		this.productQuotationDtos = productQuotationDtos;
	}
    
}
