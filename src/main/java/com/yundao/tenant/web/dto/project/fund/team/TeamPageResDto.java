

package com.yundao.tenant.web.dto.project.fund.team;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月27日 下午2:23:49 
 * @author   欧阳利
 * @version   
 */
public class TeamPageResDto {
	@ApiModelProperty("成员id")
	private Long id;
	@ApiModelProperty("成员名称")
    private String name;
	@ApiModelProperty("简介")
	private String remark;
	@ApiModelProperty("职位")
	private String position;
	@ApiModelProperty("基金id")
    private Long fundId;
	public Long getId() {
	
		return id;
	}
	public void setId(Long id) {
	
		this.id = id;
	}
	public String getName() {
	
		return name;
	}
	public void setName(String name) {
	
		this.name = name;
	}
	public String getRemark() {
	
		return remark;
	}
	public void setRemark(String remark) {
	
		this.remark = remark;
	}
	public String getPosition() {
	
		return position;
	}
	public void setPosition(String position) {
	
		this.position = position;
	}
	public Long getFundId() {
	
		return fundId;
	}
	public void setFundId(Long fundId) {
	
		this.fundId = fundId;
	}
	
}

