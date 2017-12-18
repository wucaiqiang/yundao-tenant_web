

package com.yundao.tenant.web.dto.project.fund.team;


import com.yundao.tenant.web.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月27日 下午2:23:29 
 * @author   欧阳利
 * @version   
 */
public class TeamPageReqDto extends AbstractBasePageDto{

	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
    
	@ApiModelProperty("基金id")
	private Long fundId;

	public Long getFundId() {
	
		return fundId;
	}

	public void setFundId(Long fundId) {
	
		this.fundId = fundId;
	}
}

