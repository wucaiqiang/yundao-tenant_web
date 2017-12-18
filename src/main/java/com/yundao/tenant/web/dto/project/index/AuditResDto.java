

package com.yundao.tenant.web.dto.project.index;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月20日 下午7:34:21 
 * @author   欧阳利
 * @version   
 */
public class AuditResDto {
	@ApiModelProperty("申请人id")
    private Long applyUserId;
    @ApiModelProperty("申请人名称")
    private String applyUserName;
    @ApiModelProperty("申请时间")
    private Date applyDate;
    @ApiModelProperty("项目id")
    private Long projectId;
    @ApiModelProperty("项目名称")
    private String projectName;
    @ApiModelProperty("审批项目")
    private String auditItemName;
    @ApiModelProperty("业务id")
    private String businessKey;
    @ApiModelProperty("任务id")
    private String taskId;

	public String getTaskId() {
	
		return taskId;
	}

	public void setTaskId(String taskId) {
	
		this.taskId = taskId;
	}

	public String getBusinessKey() {
	
		return businessKey;
	}

	public void setBusinessKey(String businessKey) {
	
		this.businessKey = businessKey;
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

	public Long getProjectId() {
	
		return projectId;
	}

	public void setProjectId(Long projectId) {
	
		this.projectId = projectId;
	}

	public String getProjectName() {
	
		return projectName;
	}

	public void setProjectName(String projectName) {
	
		this.projectName = projectName;
	}

	public String getAuditItemName() {
	
		return auditItemName;
	}

	public void setAuditItemName(String auditItemName) {
	
		this.auditItemName = auditItemName;
	}


}

