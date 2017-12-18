

package com.yundao.tenant.web.dto.project.index;

import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月22日 下午6:27:56 
 * @author   欧阳利
 * @version   
 */
public class ReportDto {
	@ApiModelProperty("行业布局")
	private List<IndustryAmountLayoutDto> industryLayout;
	@ApiModelProperty("项目漏斗")
	private List<ProjectCountResDto> projectFunnel;
	
	public List<IndustryAmountLayoutDto> getIndustryLayout() {
	
		return industryLayout;
	}
	public void setIndustryLayout(List<IndustryAmountLayoutDto> industryLayout) {
	
		this.industryLayout = industryLayout;
	}
	public List<ProjectCountResDto> getProjectFunnel() {
	
		return projectFunnel;
	}
	public void setProjectFunnel(List<ProjectCountResDto> projectFunnel) {
	
		this.projectFunnel = projectFunnel;
	}

	
}

