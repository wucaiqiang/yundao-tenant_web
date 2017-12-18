

package com.yundao.tenant.web.dto.project.index.audithistory;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月20日 下午7:33:24 
 * @author   欧阳利
 * @version   
 */
public class AuditHistoryResDto {
	
	@ApiModelProperty("项目id")
	private Long id;
	@ApiModelProperty("项目名称")
	private String projectName;
	@ApiModelProperty("公司名称")
	private String companyName;
	@ApiModelProperty("行业名称")
	private String industryName;
	@ApiModelProperty("优先级")
	private Integer priority;
	@ApiModelProperty("优先级名称")
	private String priorityText;
	@ApiModelProperty("轮次")
	private Integer round;
	@ApiModelProperty("轮次名称")
	private String roundText;
	@ApiModelProperty("申请人id")
	private Long applyUserId;
	@ApiModelProperty("申请人名称")
	private String applyUserName;
	@ApiModelProperty("申请时间")
	private Date applyDate;
	@ApiModelProperty("操作时间")
    private Date auditDate;
	private Integer status;
	@ApiModelProperty("审批事项")
	private String statusText;
	@ApiModelProperty("审批结果")
	private Integer auditStatus;
	@ApiModelProperty("审批结果")
	private String auditStatusText;
	
	public String getStatusText() {
	
		return statusText;
	}
	public void setStatusText(String statusText) {
	
		this.statusText = statusText;
	}
	public String getAuditStatusText() {
	
		return auditStatusText;
	}
	public void setAuditStatusText(String auditStatusText) {
	
		this.auditStatusText = auditStatusText;
	}

	public Integer getStatus() {
	
		return status;
	}
	public void setStatus(Integer status) {
	
		this.status = status;
	}

	public Integer getAuditStatus() {
	
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
	
		this.auditStatus = auditStatus;
	}
	public Long getId() {
	
		return id;
	}
	public void setId(Long id) {
	
		this.id = id;
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
	public Integer getPriority() {
	
		return priority;
	}
	public void setPriority(Integer priority) {
	
		this.priority = priority;
	}
	public String getPriorityText() {
	
		return priorityText;
	}
	public void setPriorityText(String priorityText) {
	
		this.priorityText = priorityText;
	}
	public Integer getRound() {
	
		return round;
	}
	public void setRound(Integer round) {
	
		this.round = round;
	}

	public String getRoundText() {
	
		return roundText;
	}
	public void setRoundText(String roundText) {
	
		this.roundText = roundText;
	}
	public Long getApplyUserId() {
	
		return applyUserId;
	}
	public void setApplyUserId(Long applyUserId) {
	
		this.applyUserId = applyUserId;
	}

	public String getApplyUserName() {
	
		return applyUserName;
	}
	public void setApplyUserName(String applyUserName) {
	
		this.applyUserName = applyUserName;
	}
	public Date getApplyDate() {
	
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
	
		this.applyDate = applyDate;
	}
	public Date getAuditDate() {
	
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
	
		this.auditDate = auditDate;
	}
	
}

