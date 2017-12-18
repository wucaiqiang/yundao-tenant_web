package com.yundao.tenant.web.dto.project.fund.attach;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 添加产品附件请求
 * 
 * @author 欧阳利
 * 2017年7月11日
 */
@ApiModel(value="添加产品附件请求参数")
public class FundAttachAddReqDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "基金id")
	private Long fundId;
	

	@ApiModelProperty(value = "文件名称")
    private String sourceName;

	@ApiModelProperty(value = "文件url")
    private String url;

	@ApiModelProperty(value = "排序")
    private Double sort;
	
	@ApiModelProperty(value = "文件类型")
	private String type;

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public Long getFundId() {
	
		return fundId;
	}

	public void setFundId(Long fundId) {
	
		this.fundId = fundId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Double getSort() {
		return sort;
	}

	public void setSort(Double sort) {
		this.sort = sort;
	}

}
