package com.yundao.tenant.web.dto.project.fund.attach;

import com.yundao.tenant.web.dto.AbstractBasePageDto;

/**
 * 附件列表查询
 * 
 * @author 欧阳利
 * 2017年7月11日
 */
public class FundAttachListReqDto extends AbstractBasePageDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 产品id
	 */
	private Long fundId;

	public Long getFundId() {
	
		return fundId;
	}

	public void setFundId(Long fundId) {
	
		this.fundId = fundId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
}
