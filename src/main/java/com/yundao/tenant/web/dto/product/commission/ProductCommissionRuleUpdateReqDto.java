package com.yundao.tenant.web.dto.product.commission;

import io.swagger.annotations.ApiModelProperty;

public class ProductCommissionRuleUpdateReqDto {
	/**
	 * 产品id
	 */
	@ApiModelProperty(value="产品id")
    private Long productId;
    
    /**
     * 产品规则列表
     */
    @ApiModelProperty(value="产品佣金规则列表: [{\"id(佣金规则id)\": , \"ruleName(规则名称)\": '', \"remark(备注)\": '',\"productCommissionDtos(单个规则详情)\": "
    		+ "[{\"id(佣金id)\": ,  \"saleMax(销售金额最大)\": '', \"saleMin(销售金额最小)\": '',\"commissionType(佣金类型)\": '',\"frontCommission(前端)\": '',\"backCommission(后端)\": '' }] }]")
	private String commissionDtos;

	public Long getProductId() {
		return productId;
	}

	public String getCommissionDtos() {
		return commissionDtos;
	}

	public void setCommissionDtos(String commissionDtos) {
		this.commissionDtos = commissionDtos;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

    
}
