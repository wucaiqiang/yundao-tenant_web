package com.yundao.tenant.web.dto.field;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class FiledSelectDto {
	@ApiModelProperty("字段显示名称")
    private String lable;
	@ApiModelProperty("字段名称")
    private String name;
	@ApiModelProperty("选项值")
    private List<SelectConfigStringValueDto> fieldConfigDtos;
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<SelectConfigStringValueDto> getFieldConfigDtos() {
		return fieldConfigDtos;
	}
	public void setFieldConfigDtos(List<SelectConfigStringValueDto> fieldConfigDtos) {
		this.fieldConfigDtos = fieldConfigDtos;
	}

	
}
