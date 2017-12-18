

package com.yundao.tenant.web.dto.project.index.audithistory;

import java.util.Date;

import com.yundao.tenant.web.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月20日 下午7:33:15 
 * @author   欧阳利
 * @version   
 */
public class AuditHistoryReqDto extends AbstractBasePageDto{

	
	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("项目名称")
   private String projectName;
	@ApiModelProperty("公司名称")
   private String companyName;
	@ApiModelProperty("行业名称")
   private String industryName;
	@ApiModelProperty("优先级，用逗号分割开")
   private String prioritys;
	@ApiModelProperty("申请人名称")
	private String applyUserName;
	@ApiModelProperty("操作时间开始时间")
	private Date auditStartDate;
	@ApiModelProperty("操作时间结束时间")
	private Date auditEndDate;
	@ApiModelProperty("审批状态，用逗号分割开")
	private String auditStatuss;
	@ApiModelProperty("轮次，用逗号分割开")
	private String rounds;
	@ApiModelProperty("行业，用逗号分割开")
	private String industrys;
	public String getIndustrys() {
	
		return industrys;
	}
	public void setIndustrys(String industrys) {
	
		this.industrys = industrys;
	}
	public static long getSerialversionuid() {
	
		return serialVersionUID;
	}
	public String getRounds() {
	
		return rounds;
	}
	public void setRounds(String rounds) {
	
		this.rounds = rounds;
	}
	public String getProjectName() {
	
		return projectName;
	}
	public void setProjectName(String projectName) {
	
		this.projectName = projectName;
	}
	public String getCompanyName() {
	
		return companyName;
	}
	public void setCompanyName(String companyName) {
	
		this.companyName = companyName;
	}
	public String getIndustryName() {
	
		return industryName;
	}
	public void setIndustryName(String industryName) {
	
		this.industryName = industryName;
	}
	public String getPrioritys() {
	
		return prioritys;
	}
	public void setPrioritys(String prioritys) {
	
		this.prioritys = prioritys;
	}
	public String getApplyUserName() {
	
		return applyUserName;
	}
	public void setApplyUserName(String applyUserName) {
	
		this.applyUserName = applyUserName;
	}
	public Date getAuditStartDate() {
	
		return auditStartDate;
	}
	public void setAuditStartDate(Date auditStartDate) {
	
		this.auditStartDate = auditStartDate;
	}
	public Date getAuditEndDate() {
	
		return auditEndDate;
	}
	public void setAuditEndDate(Date auditEndDate) {
	
		this.auditEndDate = auditEndDate;
	}
	public String getAuditStatuss() {
	
		return auditStatuss;
	}
	public void setAuditStatuss(String auditStatuss) {
	
		this.auditStatuss = auditStatuss;
	}
	
	


}

