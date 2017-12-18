
package com.yundao.tenant.web.dto.roadshow;

import java.io.Serializable;

import com.yundao.core.validator.length.Length;
import com.yundao.core.validator.number.Number;

import io.swagger.annotations.ApiModelProperty;

public class RoadshowColumnAddReqDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "平台ID")
	private Long platformId;
	@ApiModelProperty(value = "名称")
	private String name;
	@ApiModelProperty(value = "编码")
	private String code;
	@ApiModelProperty(value = "状态，0：停用，1：启用")
	private Integer status;
	@ApiModelProperty(value = "排序，越小越靠前")
	private Integer sequence;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getPlatformId() {

		return platformId;
	}

	public void setPlatformId(Long platformId) {

		this.platformId = platformId;
	}

	public Integer getStatus() {

		return status;
	}

	public void setStatus(Integer status) {

		this.status = status;
	}

	public Integer getSequence() {

		return sequence;
	}

	public void setSequence(Integer sequence) {

		this.sequence = sequence;
	}

}
