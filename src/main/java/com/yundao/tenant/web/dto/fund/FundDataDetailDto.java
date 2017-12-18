

package com.yundao.tenant.web.dto.fund;

import java.util.List;

import com.yundao.tenant.web.dto.project.fund.attach.FundAttachListResDto;
import com.yundao.tenant.web.dto.project.fund.income.IncomeRuleDetailDto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月29日 上午9:56:47 
 * @author   欧阳利
 * @version   
 */
public class FundDataDetailDto {


	@ApiModelProperty("基金id")
    private Long id;
	
	@ApiModelProperty("类别id")
	private Long typeId;
	
	@ApiModelProperty("类别名称")
	private String typeIdText;
	
	@ApiModelProperty("关联产品id")
	private Long productId;
	
	@ApiModelProperty("关联产品名称")
	private String productName;
	
	
	@ApiModelProperty("是否关注(1:关注,0:没有关注)")
	private Integer isFocus;

	@ApiModelProperty("是否关注(1:关注,0:没有关注)")
	private FundBaseDto fundDto;
	
	@ApiModelProperty("产品附件列表")
	private  List<FundAttachListResDto> attachDtos;


	@ApiModelProperty("收益")
	private List<IncomeRuleDetailDto> incomeDtos;

	
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

	public FundBaseDto getFundDto() {
	
		return fundDto;
	}

	public void setFundDto(FundBaseDto fundDto) {
	
		this.fundDto = fundDto;
	}

	public List<IncomeRuleDetailDto> getIncomeDtos() {
		return incomeDtos;
	}

	public void setIncomeDtos(List<IncomeRuleDetailDto> incomeDtos) {
		this.incomeDtos = incomeDtos;
	}

	public List<FundAttachListResDto> getAttachDtos() {
	
		return attachDtos;
	}

	public void setAttachDtos(List<FundAttachListResDto> attachDtos) {
	
		this.attachDtos = attachDtos;
	}

}

