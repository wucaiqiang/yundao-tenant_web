package com.yundao.tenant.web.dto.project.fund.attach;

import io.swagger.annotations.ApiModelProperty;

/**
 * 产品列表信息
 * 
 * @author 欧阳利
 * 2017年7月11日
 */
public class FundAttachListResDto {
	
	/**
	 * 产品附件id
	 */
	@ApiModelProperty("产品附件id")
	private Long id;
	
    /**
	 * 文件名称
	 */
	@ApiModelProperty("文件名称")
    private String sourceName;

    /**
	 * url
	 */
	@ApiModelProperty("url")
    private String url;
    
    /**
     * 基金id
     */
	@ApiModelProperty("基金id")
    private Long fundId;
	
    /**
	 * 附件类型
	 */
	@ApiModelProperty("附件类型")
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

    
}
