package com.yundao.tenant.web.dto.product.field;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class FieldDto {
	
	/**
	 * 字段id
	 */
	@ApiModelProperty(value = "字段id")
	private Long id;
	
   
	@ApiModelProperty(value = "字段英文名称")
	private String name;
	
	/**
     * 名称
     */
    @ApiModelProperty(value = "字段显示名称")
    private String label;

    /**
     * 类型
     */
    @ApiModelProperty(value = "字段类型")
    private Integer type;
    
    @ApiModelProperty(value = "字段类型code")
    private String typeCode;
    
    @ApiModelProperty(value = "字段类型名称")
    private String typeName;
    
    @ApiModelProperty(value = "是否必填，0：否；1：是")
    private Integer isMandatory;
    
    /**
     * 下拉选项，单选选项，复选选项
     */
    @ApiModelProperty(value = "适用 下拉选项，单选选项，复选选项")
    private List<SelectConfigDto> selectDtos;
    
    /**
     * 数字配置
     */
    @ApiModelProperty(value = "数字配置(只适用数字和数字区间)")
    private NumberConfigDto numberDto;
    
    /**
     * 字段配置
     */
    @ApiModelProperty(value = "字段配置(适用所有的字段)")
    private FieldConfigDto fieldConfigDto;



	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIsMandatory() {
		return isMandatory;
	}

	public void setIsMandatory(Integer isMandatory) {
		this.isMandatory = isMandatory;
	}

	public List<SelectConfigDto> getSelectDtos() {
		return selectDtos;
	}

	public void setSelectDtos(List<SelectConfigDto> selectDtos) {
		this.selectDtos = selectDtos;
	}

	public NumberConfigDto getNumberDto() {
		return numberDto;
	}

	public void setNumberDto(NumberConfigDto numberDto) {
		this.numberDto = numberDto;
	}

	public FieldConfigDto getFieldConfigDto() {
		return fieldConfigDto;
	}

	public void setFieldConfigDto(FieldConfigDto fieldConfigDto) {
		this.fieldConfigDto = fieldConfigDto;
	}
    
}
