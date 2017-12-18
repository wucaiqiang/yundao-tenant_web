package com.yundao.tenant.web.controller.product.income;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.product.income.IncomeRuleUpdateReqDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product/income")
@ResponseBody
@Api("产品-->产品收益管理")
public class ProductIncomeController {

	
	/**
	 * 修改收益
	 * @param reqDto
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "修改收益")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
	public Result<Integer> updateProductIncome(@ModelAttribute IncomeRuleUpdateReqDto reqDto)throws Exception{
    	return HttpUtils.post(TenantUrl.UPDATE_PRODUCT_INCOME, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<Integer>>() {});
	}
	
}
