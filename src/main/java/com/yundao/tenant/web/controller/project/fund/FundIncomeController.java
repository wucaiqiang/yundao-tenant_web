package com.yundao.tenant.web.controller.project.fund;

import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.project.fund.income.IncomeRuleUpdateReqDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/assets/fund/income")
@ResponseBody
@Api("项目管理---基金-->收益管理")
public class FundIncomeController {

    @ApiOperation(value = "修改收益")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
	public Result<Integer> updateProductIncome(@ModelAttribute IncomeRuleUpdateReqDto reqDto)throws Exception{
    	 Map<String,Object> params = ArgsUtils.toMap(reqDto);
		  Result<Integer> result =  HttpUtils.post(AmUrl.UPDATE_FUND_INCOME, params, new BaseTypeReference<Result<Integer>>() {
         });
         return result;
	}
	
}
