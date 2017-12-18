

package com.yundao.tenant.web.dto.project.index;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月22日 上午9:27:02 
 * @author   欧阳利
 * @version   
 */
public class ProjectCountDto {
	@ApiModelProperty("项目个数")
    private Integer projectCount;
	@ApiModelProperty("项目立项个数")
    private Integer projectDecisionCount;
	@ApiModelProperty("项目出资个数")
	private Integer projectInvestCount;
	@ApiModelProperty("项目退出个数")
	private Integer ProjectWithdrawal;
	public Integer getProjectCount() {
	
		return projectCount;
	}
	public void setProjectCount(Integer projectCount) {
	
		this.projectCount = projectCount;
	}
	public Integer getProjectDecisionCount() {
	
		return projectDecisionCount;
	}
	public void setProjectDecisionCount(Integer projectDecisionCount) {
	
		this.projectDecisionCount = projectDecisionCount;
	}
	public Integer getProjectInvestCount() {
	
		return projectInvestCount;
	}
	public void setProjectInvestCount(Integer projectInvestCount) {
	
		this.projectInvestCount = projectInvestCount;
	}
	public Integer getProjectWithdrawal() {
	
		return ProjectWithdrawal;
	}
	public void setProjectWithdrawal(Integer projectWithdrawal) {
	
		ProjectWithdrawal = projectWithdrawal;
	}
	
}

