package com.yundao.tenant.web.dto.product.detail;

import java.util.List;

import com.yundao.tenant.web.dto.product.attach.ProductAttachListResDto;
import com.yundao.tenant.web.dto.product.income.IncomeRuleDetailDto;

import io.swagger.annotations.ApiModelProperty;

public class ProductDataDetailDto {

	@ApiModelProperty("产品id")
    private Long id;
	
	@ApiModelProperty("类别id")
	private Long typeId;
	
	@ApiModelProperty("类别名称")
	private String typeIdText;
	
	@ApiModelProperty("是否关注(1:关注,0:没有关注)")
	private Integer isFocus;

	@ApiModelProperty("是否关注(1:关注,0:没有关注)")
	private ProductBaseDto productDto;
	
	@ApiModelProperty("产品附件列表")
	private  List<ProductAttachListResDto> attachDtos;
	
	@ApiModelProperty("佣金规则")
	private ProductCommissionDto commissionDto;

	@ApiModelProperty("收益")
	private List<IncomeRuleDetailDto> incomeDtos;
	
	@ApiModelProperty("供应商报价")
	private ProductSupplierDto supplierDto;
	
    @ApiModelProperty("发行状态")
    private Integer issuedStatus;
    @ApiModelProperty("发行状态文本")
    private String issuedStatusText;
    @ApiModelProperty("审核状态")
    private  Integer examineStatus;
    @ApiModelProperty("审核状态文本")
    private  String examineStatusText;
	public Integer getIssuedStatus() {
		return issuedStatus;
	}

	public void setIssuedStatus(Integer issuedStatus) {
		this.issuedStatus = issuedStatus;
	}

	public String getIssuedStatusText() {
		return issuedStatusText;
	}

	public void setIssuedStatusText(String issuedStatusText) {
		this.issuedStatusText = issuedStatusText;
	}

	public Integer getExamineStatus() {
		return examineStatus;
	}

	public void setExamineStatus(Integer examineStatus) {
		this.examineStatus = examineStatus;
	}

	public String getExamineStatusText() {
		return examineStatusText;
	}

	public void setExamineStatusText(String examineStatusText) {
		this.examineStatusText = examineStatusText;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeIdText() {
		return typeIdText;
	}

	public void setTypeIdText(String typeIdText) {
		this.typeIdText = typeIdText;
	}

	public Integer getIsFocus() {
		return isFocus;
	}

	public void setIsFocus(Integer isFocus) {
		this.isFocus = isFocus;
	}

	public ProductBaseDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductBaseDto productDto) {
		this.productDto = productDto;
	}

	public List<ProductAttachListResDto> getAttachDtos() {
		return attachDtos;
	}

	public void setAttachDtos(List<ProductAttachListResDto> attachDtos) {
		this.attachDtos = attachDtos;
	}

	public ProductCommissionDto getCommissionDto() {
		return commissionDto;
	}

	public void setCommissionDto(ProductCommissionDto commissionDto) {
		this.commissionDto = commissionDto;
	}

	public List<IncomeRuleDetailDto> getIncomeDtos() {
		return incomeDtos;
	}

	public void setIncomeDtos(List<IncomeRuleDetailDto> incomeDtos) {
		this.incomeDtos = incomeDtos;
	}

	public ProductSupplierDto getSupplierDto() {
		return supplierDto;
	}

	public void setSupplierDto(ProductSupplierDto supplierDto) {
		this.supplierDto = supplierDto;
	}
	
}
