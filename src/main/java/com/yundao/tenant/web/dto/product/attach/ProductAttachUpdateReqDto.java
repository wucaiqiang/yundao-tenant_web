package com.yundao.tenant.web.dto.product.attach;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 添加产品附件请求
 * 
 * @author 欧阳利 2017年7月11日
 */
@ApiModel(value = "添加产品附件请求参数")
public class ProductAttachUpdateReqDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 附件id
	 */
	@ApiModelProperty(value = " 附件id")
	private Long fileId;

	@ApiModelProperty(value = "可见性：0： 全部可见 1：内部可见 2：外部可见 3:全部不可见")
	private Integer showType;


	public Long getFileId() {
	
		return fileId;
	}

	public void setFileId(Long fileId) {
	
		this.fileId = fileId;
	}

	public Integer getShowType() {

		return showType;
	}

	public void setShowType(Integer showType) {

		this.showType = showType;
	}

}
