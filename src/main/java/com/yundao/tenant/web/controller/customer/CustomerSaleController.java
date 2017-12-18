package com.yundao.tenant.web.controller.customer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.MapUtils;
import com.yundao.core.utils.ObjectCopyUtil;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.customer.CustomerSaleCountResDto;
import com.yundao.tenant.web.dto.customer.CustomerSaleReservationReqDto;
import com.yundao.tenant.web.dto.customer.CustomerSaleReservationResDto;
import com.yundao.tenant.web.dto.sale.declaration.DeclarationModel;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.service.customer.CustomerService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/customer/sale")
@ResponseBody
@Api("客户交易信息")
public class CustomerSaleController {

	@Autowired
	PermissionService permissionService;
	
	@Autowired
	CustomerService customerService;

    @RequestMapping(value = "gets_reservation", method = RequestMethod.GET)
    @ApiOperation(value = "获取客户详情的交易信息-- 预约")
    public Result<PaginationSupport<CustomerSaleReservationResDto>> getReservations(@ModelAttribute CustomerSaleReservationReqDto dto) throws BaseException {
//        if(!customerService.hasReadCustomerPermission(dto.getCustomerId())){
//        	return Result.newFailureResult(CodeConstant.CODE_1220015);
//        }
    	return HttpUtils.get(TenantUrl.CUSTOMER_SALE_GETS_RESERVATION, ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<CustomerSaleReservationResDto>>>() {
         });
    }
    
    @RequestMapping(value = "gets_count", method = RequestMethod.GET)
    @ApiOperation(value = "获取客户详情的交易信息-- 预约和报单的个数")
    public Result<CustomerSaleCountResDto> getCount(@RequestParam Long customerId) throws BaseException {
//        if(!customerService.hasReadCustomerPermission(customerId)){
//        	return Result.newFailureResult(CodeConstant.CODE_1220015);
//        }
    	 Map<String, Object> map= new HashMap<String, Object>();
    	 map.put("customerId", customerId);
    	 return HttpUtils.get(TenantUrl.CUSTOMER_SALE_GET_COUNT, map, new BaseTypeReference<Result<CustomerSaleCountResDto>>() {
         });
    }

    @RequestMapping(value = "/gets_declaration", method = RequestMethod.GET)
    @ApiOperation(value = "获取客户详情的交易信息--报单")
    public Result<PaginationSupport<DeclarationModel>> getPage(@ModelAttribute CustomerSaleReservationReqDto customerSaleReservationReqDto) throws BaseException {
//        if(!customerService.hasReadCustomerPermission(customerSaleReservationReqDto.getCustomerId())){
//        	return Result.newFailureResult(CodeConstant.CODE_1220015);
//        }
    	Map<String, String> params = ObjectCopyUtil.beanToMap(customerSaleReservationReqDto);
        Result<PaginationSupport<DeclarationModel>> result = HttpUtils.get(TenantUrl.CUSTOMER_SALE_GETS_DECLARATION, MapUtils.cast(params), new BaseTypeReference<Result<PaginationSupport<DeclarationModel>>>() {});
        return result;
    }

}
