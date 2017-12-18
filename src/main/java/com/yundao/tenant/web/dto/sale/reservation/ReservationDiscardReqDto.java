package com.yundao.tenant.web.dto.sale.reservation;

import io.swagger.annotations.ApiModelProperty;

public class ReservationDiscardReqDto {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "作废原因")
    private String reason;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
