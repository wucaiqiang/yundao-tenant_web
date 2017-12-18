

package com.yundao.tenant.web.dto.project.fund;

import java.util.List;

import com.yundao.tenant.web.dto.field.FieldDetailDto;
import com.yundao.tenant.web.dto.product.field.FieldDto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月23日 下午8:33:11 
 * @author   欧阳利
 * @version   
 */
public class FundFieldDto {
	@ApiModelProperty("基金信息")
    private List<FieldDetailDto> fundFieldDtos;
	@ApiModelProperty("销售信息")
    private List<FieldDetailDto> fundRaiseFieldDtos;
	public List<FieldDetailDto> getFundFieldDtos() {
	
		return fundFieldDtos;
	}
	public void setFundFieldDtos(List<FieldDetailDto> fundFieldDtos) {
	
		this.fundFieldDtos = fundFieldDtos;
	}
	public List<FieldDetailDto> getFundRaiseFieldDtos() {
	
		return fundRaiseFieldDtos;
	}
	public void setFundRaiseFieldDtos(List<FieldDetailDto> fundRaiseFieldDtos) {
	
		this.fundRaiseFieldDtos = fundRaiseFieldDtos;
	}




}

