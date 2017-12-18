package com.yundao.tenant.web.dto.project.fund;

import java.util.List;

import com.yundao.tenant.web.dto.field.FieldDetailDto;
import com.yundao.tenant.web.dto.project.fund.attach.FundAttachListResDto;
import com.yundao.tenant.web.dto.project.fund.income.IncomeRuleDetailDto;

import io.swagger.annotations.ApiModelProperty;

public class FundDetailDto {

	@ApiModelProperty("基金id")
    private Long id;
	
	@ApiModelProperty("类别id")
	private Long typeId;
	
	@ApiModelProperty("类别名称")
	private String typeIdText;
	
	@ApiModelProperty("是否关注(1:关注,0:没有关注)")
	private Integer isFocus;
	
	@ApiModelProperty("关联产品id")
	private Long productId;
	@ApiModelProperty("关联产品名称")
	private String productName;
	
	@ApiModelProperty("基金信息字段")
	private List<FieldDetailDto> fundFieldDtos;
	
	@ApiModelProperty("基金募集信息")
	private List<FieldDetailDto> fundRaiseFieldDtos;
	
	@ApiModelProperty("基金附件列表")
	private  List<FundAttachListResDto> attachDtos;

	@ApiModelProperty("收益")
	private List<IncomeRuleDetailDto> incomeDtos;
	
	@ApiModelProperty("创建者id")
	private Long createUserId;
    @ApiModelProperty("发行状态")
    private Integer issuedStatus;
    @ApiModelProperty("发行状态文本")
    private String issuedStatusText;

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


	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getIsFocus() {
		return isFocus;
	}

	public void setIsFocus(Integer isFocus) {
		this.isFocus = isFocus;
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

	public List<FieldDetailDto> getFundFieldDtos() {
	
		return fundFieldDtos;
	}

	public void setFundFieldDtos(List<FieldDetailDto> fundFieldDtos) {
	
		this.fundFieldDtos = fundFieldDtos;
	}

	public List<FieldDetailDto> getFundRaiseFieldDtos() {
	
		return fundRaiseFieldDtos;
	}

	public void setFundRaiseFieldDtos(List<FieldDetailDto> fundRaiseFieldDtos) {
	
		this.fundRaiseFieldDtos = fundRaiseFieldDtos;
	}

	public List<FundAttachListResDto> getAttachDtos() {
	
		return attachDtos;
	}

	public void setAttachDtos(List<FundAttachListResDto> attachDtos) {
	
		this.attachDtos = attachDtos;
	}

	public List<IncomeRuleDetailDto> getIncomeDtos() {
	
		return incomeDtos;
	}

	public void setIncomeDtos(List<IncomeRuleDetailDto> incomeDtos) {
	
		this.incomeDtos = incomeDtos;
	}

}
