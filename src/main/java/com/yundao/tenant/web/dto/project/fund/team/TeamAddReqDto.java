

package com.yundao.tenant.web.dto.project.fund.team;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月27日 下午1:48:42 
 * @author   欧阳利
 * @version   
 */
public class TeamAddReqDto {
	@ApiModelProperty("姓名")
    private String name;
	@ApiModelProperty("职位")
	private String position;
	@ApiModelProperty("简介")
	private String remark;
	@ApiModelProperty("基金id")
    private Long fundId;
	public String getName() {
	
		return name;
	}
	public void setName(String name) {
	
		this.name = name;
	}
	public String getPosition() {
	
		return position;
	}
	public void setPosition(String position) {
	
		this.position = position;
	}
	public String getRemark() {
	
		return remark;
	}
	public void setRemark(String remark) {
	
		this.remark = remark;
	}
	public Long getFundId() {
	
		return fundId;
	}
	public void setFundId(Long fundId) {
	
		this.fundId = fundId;
	}

    
}

