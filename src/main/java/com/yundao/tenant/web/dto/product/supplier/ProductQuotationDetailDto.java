package com.yundao.tenant.web.dto.product.supplier;

import io.swagger.annotations.ApiModelProperty;

public class ProductQuotationDetailDto {
	/**
	 * 报价id
	 */
	@ApiModelProperty("报价id")
	private Long id;
	
    /**
	 * 供应商报价id
	 */
	@ApiModelProperty("供应商报价id")
    private Long productSupplierId;
    /**
	 * 销售金额最大
	 */
	@ApiModelProperty("销售金额最大")
    private Double saleMax;

    /**
	 * 销售金额最小
	 */
	@ApiModelProperty("销售金额最小")
    private Double saleMin;

    /**
	 * 佣金类型
	 */
	@ApiModelProperty("佣金类型")
    private String commissionType;

    /**
	 * 前端佣金
	 */
	@ApiModelProperty("前端佣金")
    private Double frontCommission;

    /**
	 * 后端佣金
	 */
	@ApiModelProperty("后端佣金")
    private Double backCommission;

	public Long getProductSupplierId() {
		return productSupplierId;
	}

	public void setProductSupplierId(Long productSupplierId) {
		this.productSupplierId = productSupplierId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSaleMax() {
		return saleMax;
	}

	public void setSaleMax(Double saleMax) {
		this.saleMax = saleMax;
	}

	public Double getSaleMin() {
		return saleMin;
	}

	public void setSaleMin(Double saleMin) {
		this.saleMin = saleMin;
	}

	public String getCommissionType() {
		return commissionType;
	}

	public void setCommissionType(String commissionType) {
		this.commissionType = commissionType;
	}

	public Double getFrontCommission() {
		return frontCommission;
	}

	public void setFrontCommission(Double frontCommission) {
		this.frontCommission = frontCommission;
	}

	public Double getBackCommission() {
		return backCommission;
	}

	public void setBackCommission(Double backCommission) {
		this.backCommission = backCommission;
	}
}
