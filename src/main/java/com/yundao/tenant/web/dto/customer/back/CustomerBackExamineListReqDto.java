package com.yundao.tenant.web.dto.customer.back;

import java.util.Date;

import com.yundao.tenant.web.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 客户回退审核列表查询DTO
 * 
 * @author 欧阳利
 * 2017年8月14日
 */
public class CustomerBackExamineListReqDto extends AbstractBasePageDto{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("客户名称")
	private String customerName;
	@ApiModelProperty("客户编号")
    private String customerNumber;
	@ApiModelProperty("客户手机号码")
    private String customerMobile;
	@ApiModelProperty("申请发起人")
    private String applyUserName;
	@ApiModelProperty("回退原因")
    private String reason;
	@ApiModelProperty("申请开始时间")
    private Date applyStartDate;
	@ApiModelProperty("申请结束时间")
    private Date applyEndDate;
	@ApiModelProperty("审核开始时间")
    private Date examineStartDate;
	@ApiModelProperty("审核结束时间")
    private Date examineEndDate;
	@ApiModelProperty("客户性别")
    private String customerSexs;
	@ApiModelProperty("客户等级")
    private String customerLevels;
	@ApiModelProperty("省集合")
    private String provinceCodes;
	@ApiModelProperty("市集合")
    private String cityCodes;
	
	public String getCustomerSexs() {
		return customerSexs;
	}

	public void setCustomerSexs(String customerSexs) {
		this.customerSexs = customerSexs;
	}

	public String getCustomerLevels() {
		return customerLevels;
	}

	public void setCustomerLevels(String customerLevels) {
		this.customerLevels = customerLevels;
	}

	public String getProvinceCodes() {
		return provinceCodes;
	}

	public void setProvinceCodes(String provinceCodes) {
		this.provinceCodes = provinceCodes;
	}

	public String getCityCodes() {
		return cityCodes;
	}

	public void setCityCodes(String cityCodes) {
		this.cityCodes = cityCodes;
	}

	public String getApplyUserName() {
		return applyUserName;
	}

	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getApplyStartDate() {
		return applyStartDate;
	}

	public void setApplyStartDate(Date applyStartDate) {
		this.applyStartDate = applyStartDate;
	}

	public Date getApplyEndDate() {
		return applyEndDate;
	}

	public void setApplyEndDate(Date applyEndDate) {
		this.applyEndDate = applyEndDate;
	}


	public Date getExamineStartDate() {
		return examineStartDate;
	}

	public void setExamineStartDate(Date examineStartDate) {
		this.examineStartDate = examineStartDate;
	}

	public Date getExamineEndDate() {
		return examineEndDate;
	}

	public void setExamineEndDate(Date examineEndDate) {
		this.examineEndDate = examineEndDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

    
    
}
