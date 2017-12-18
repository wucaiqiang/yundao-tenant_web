package com.yundao.tenant.web.controller.product.commission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.product.commission.ProductCommissionRuleUpdateReqDto;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.service.product.ProductService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product/commission")
@ResponseBody
@Api("产品-->产品佣金管理")
public class ProductCommissionController {
	
	@Autowired
	private ProductService productService;
	/**
	 * 修改佣金
	 * @param reqDto
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "修改佣金")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
	public Result<Integer> updateProductCommission(@ModelAttribute ProductCommissionRuleUpdateReqDto reqDto)throws Exception{
		Boolean isPass =productService.updatePermission(reqDto.getProductId(),DataObjectEnum.COMMISSION.getCode());
		if (!isPass){
			throw new BaseException(CodeConstant.CODE_1220016);
		}
		
    	Result<Integer>  result = HttpUtils.post(TenantUrl.UPDATE_PRODUCT_COMMISSION, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<Integer>>() {});
    	return result;
	}
}
