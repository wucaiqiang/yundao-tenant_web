package com.yundao.tenant.web.dto.fund;

import com.yundao.tenant.web.dto.common.DataPermissionDto;
import com.yundao.tenant.web.dto.project.fund.FundFieldDto;

import io.swagger.annotations.ApiModelProperty;

public class FundBaseDto {
	@ApiModelProperty("产品信息字段和销售信息")
    private FundFieldDto data;
	@ApiModelProperty("权限")
	private DataPermissionDto permission;
	public FundFieldDto getData() {
		return data;
	}
	public void setData(FundFieldDto data) {
		this.data = data;
	}
	public DataPermissionDto getPermission() {
		return permission;
	}
	public void setPermission(DataPermissionDto permission) {
		this.permission = permission;
	}
	
}
