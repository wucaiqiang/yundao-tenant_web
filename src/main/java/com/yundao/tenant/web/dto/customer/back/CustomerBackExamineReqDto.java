package com.yundao.tenant.web.dto.customer.back;

import io.swagger.annotations.ApiModelProperty;

public class CustomerBackExamineReqDto {
	
	@ApiModelProperty(value = "审核记录id集合)")
	private Long id;
	
    @ApiModelProperty(value = "驳回原因")
    private String reason;
    
    @ApiModelProperty(value = "是否审核通过 true:审核通过，false:驳回")
    private Boolean isPass;

    public Boolean getIsPass() {
		return isPass;
	}

	public void setIsPass(Boolean isPass) {
		this.isPass = isPass;
	}

	public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
