

package com.yundao.tenant.web.dto.workflow;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月27日 上午9:12:39 
 * @author   欧阳利
 * @version   
 */
public class WorkFlowRecordReqDto {

	@ApiModelProperty("业务对象id")
	private Long id;
	@ApiModelProperty("业务对象编码(产品公告：product_notice) ")
	private String code;
	public Long getId() {
	
		return id;
	}
	public void setId(Long id) {
	
		this.id = id;
	}
	public String getCode() {
	
		return code;
	}
	public void setCode(String code) {
	
		this.code = code;
	}
	
}

