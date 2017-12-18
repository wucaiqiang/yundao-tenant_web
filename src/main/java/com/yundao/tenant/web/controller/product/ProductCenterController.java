
package com.yundao.tenant.web.controller.product;

import com.yundao.tenant.web.dto.sale.declaration.DeclarationReqDto;
import com.yundao.tenant.web.dto.sale.reservation.ReservationAddReqDto;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.product.ProductCenterListReqDto;
import com.yundao.tenant.web.dto.product.ProductCenterListResDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

/**
 * 产品中心
 * 
 * @author 欧阳利
 * 2017年8月24日
 */
@RestController
@RequestMapping("/product/center")
@ResponseBody
@Api("产品-->产品中心")
public class ProductCenterController {
	
	
	/**
	 * 分页产品产品管理列表
	 *
	 * @param reqDto
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value = "/gets", method = RequestMethod.GET)
	@ApiOperation(value = "分页产品中心列表", notes = "分页产品中心列表")
	public Result<PaginationSupport<ProductCenterListResDto>> gets(@ModelAttribute ProductCenterListReqDto reqDto) throws BaseException {
		
		return HttpUtils.get(TenantUrl.GETS_PRODUCT_CENTER, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<PaginationSupport<ProductCenterListResDto>>>() {});
	}

	@RequestMapping(value = "/reservation", method = RequestMethod.POST)
	@ApiOperation("预约")
	public Result<Long> add(@ModelAttribute ReservationAddReqDto dto) throws BaseException {
		return HttpUtils.post(TenantUrl.ADD_RESERVATION, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
		});
	}


	@RequestMapping(value = "/declaration", method = RequestMethod.POST)
	@ApiOperation(value = "新增报单")
	public Result<Integer> add(@ModelAttribute DeclarationReqDto declarationReqDto) throws BaseException {
		Map<String, Object> params = ArgsUtils.toMap(declarationReqDto);
		return HttpUtils.post(TenantUrl.DECLARATION_ADD, params, new BaseTypeReference<Result<Integer>>() {
		});
	}
}
