

package com.yundao.tenant.web.dto.project.fund;

import io.swagger.annotations.ApiModelProperty;

/**
 *
 */
public class FundProjectResDto {
	@ApiModelProperty("产品id")
	private Long productId;
	@ApiModelProperty("产品id")
	private String productName;
	@ApiModelProperty("已预约")
	private Double totalReservation;
	@ApiModelProperty("确认预约")
	private Double confirmReservation;
	@ApiModelProperty("已报单")
	private Double totalDeclaration;
	@ApiModelProperty("确认的报单")
	private Double confirmDeclaration;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getTotalReservation() {
		return totalReservation;
	}

	public void setTotalReservation(Double totalReservation) {
		this.totalReservation = totalReservation;
	}

	public Double getConfirmReservation() {
		return confirmReservation;
	}

	public void setConfirmReservation(Double confirmReservation) {
		this.confirmReservation = confirmReservation;
	}

	public Double getTotalDeclaration() {
		return totalDeclaration;
	}

	public void setTotalDeclaration(Double totalDeclaration) {
		this.totalDeclaration = totalDeclaration;
	}

	public Double getConfirmDeclaration() {
		return confirmDeclaration;
	}

	public void setConfirmDeclaration(Double confirmDeclaration) {
		this.confirmDeclaration = confirmDeclaration;
	}
}

