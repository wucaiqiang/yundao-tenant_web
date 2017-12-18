
package com.yundao.tenant.web.dto.video;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class VideoAddReqDto implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "文件ID")
	private String fileId;
	@ApiModelProperty(value = "视频名称")
	private String name;
	@ApiModelProperty(value = "文件大小")
	private Long size;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileId() {
	
		return fileId;
	}

	public void setFileId(String fileId) {
	
		this.fileId = fileId;
	}

	public Long getSize() {
	
		return size;
	}

	public void setSize(Long size) {
	
		this.size = size;
	}
	

}
