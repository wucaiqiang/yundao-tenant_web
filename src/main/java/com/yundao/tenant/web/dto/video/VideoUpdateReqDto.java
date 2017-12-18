
package com.yundao.tenant.web.dto.video;

import java.io.Serializable;


import io.swagger.annotations.ApiModelProperty;

public class VideoUpdateReqDto implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "视频ID")
	private Long id;
	@ApiModelProperty(value = "视频名称")
	private String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}


}
