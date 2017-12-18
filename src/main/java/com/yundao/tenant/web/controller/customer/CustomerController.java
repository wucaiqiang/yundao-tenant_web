package com.yundao.tenant.web.controller.customer;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.customer.*;
import com.yundao.tenant.web.dto.customer.customer.*;
import com.yundao.tenant.web.dto.customer.v2.CustomerV2PageReqDto;
import com.yundao.tenant.web.dto.customer.v2.CustomerV2PageResDto;
import com.yundao.tenant.web.dto.sale.leads.LeadsForCustomerDetailReqDto;
import com.yundao.tenant.web.enums.customer.CustomerAddTypEnum;
import com.yundao.tenant.web.service.customer.CustomerService;
import com.yundao.tenant.web.service.customer.UpdateAssejtsDto;
import com.yundao.tenant.web.service.customer.UpdateCredentialsDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户控制器
 *
 * @author jan
 * @create 2017-08-09 PM2:45
 **/
@Controller
@RequestMapping("/customer")
@Api("客户管理")
@ResponseBody
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/v2/get_page", method = RequestMethod.GET)
    @ApiOperation(value = "客户页面 获取分页数据")
    public Result<PaginationSupport<CustomerV2PageResDto>> getPageV2(@ModelAttribute CustomerV2PageReqDto dto) throws
            BaseException {
        return customerService.getPageV2(dto);
    }

    @RequestMapping(value = "/get_my_page", method = RequestMethod.GET)
    @ApiOperation(value = "获取我的客户列表数据")
    public Result<PaginationSupport<MyCustomerPageResDto>> getMyPage(@ModelAttribute MyCustomerPageReqDto dto) throws
            BaseException {
        return customerService.getMyPage(dto);
    }

    @RequestMapping(value = "/get_detail", method = RequestMethod.GET)
    @ApiOperation(value = "获取客户表详细信息")
    public Result<CustomerDetailResDto> getDetail(@RequestParam Long id) throws Exception {
        return customerService.getDetail(id);
    }

    @RequestMapping(value = "/update_contact", method = RequestMethod.POST)
    @ApiOperation(value = "获取客户联系信息")
    public Result<Integer> updateContact(@ModelAttribute CustomerContactReqDto reqDto) throws Exception {
        return customerService.updateContact(reqDto);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation(value = "添加客户")
    public Result<Long> add(@ModelAttribute CustomerReqDto reqDto) throws Exception {
        reqDto.setAddCustomerType(1);
        return HttpUtils.post(TenantUrl.CUSTOMER_ADD, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "v2/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加客户 v2")
    public Result<Long> addV2(@ModelAttribute CustomerReqDto reqDto) throws Exception {
        reqDto.setAddCustomerType(CustomerAddTypEnum.CUSTOMER_ADD_TYPE_1.getType());
        return HttpUtils.post(TenantUrl.CUSTOMER_ADD_V2, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "add_pool", method = RequestMethod.POST)
    @ApiOperation(value = "添加客户池")
    public Result<Long> addPool(@ModelAttribute CustomerReqDto reqDto) throws Exception {
        reqDto.setAddCustomerType(2);
        return HttpUtils.post(TenantUrl.CUSTOMER_ADD, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "add_opensea", method = RequestMethod.POST)
    @ApiOperation(value = "添加客户公海")
    public Result<Long> addOpensea(@ModelAttribute CustomerReqDto reqDto) throws Exception {
        reqDto.setAddCustomerType(3);
        return HttpUtils.post(TenantUrl.CUSTOMER_ADD, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "validate_mobile", method = RequestMethod.GET)
    @ApiOperation(value = "验证客户手机号")
    public Result<Boolean> validateMobile(@RequestParam String mobile, @RequestParam(required = false) Long id) throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("mobile", mobile);
        params.put("id", id);
        return HttpUtils.get(TenantUrl.CUSTOMER_VALIDATE_MOBILE, params, new BaseTypeReference<Result<Boolean>>() {
        });
    }

    @RequestMapping(value = "/update_info", method = RequestMethod.POST)
    @ApiOperation(value = "获取客户联系信息")
    public Result<Integer> updateInfo(
            @Validated(value = {Update.class}) @ModelAttribute CustomerExclusiveContactReqDto reqDto,
            BindingResult bindingResult) throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return customerService.updateInfo(reqDto);
    }

    @RequestMapping(value = "/get_my_selections", method = RequestMethod.POST)
    @ApiOperation(value = "获取客户联系信息")
    public Result<List<CustomerSelectionResDto>> getMyCustomerSelections(@ModelAttribute CustomerSelectionReqDto dto) throws
            Exception {
        return customerService.getMyCustomerSelections(dto);
    }

    @RequestMapping(value = "/update_status", method = RequestMethod.POST)
    @ApiOperation(value = "客户有效性处理")
    public Result<Long> updateStatus(@ModelAttribute CustomerUpdateStatusReqDto dto) throws Exception {
        return customerService.updateStatus(dto);
    }

    @RequestMapping(value = "/detail/get_leads_chance_count", method = RequestMethod.GET)
    @ApiOperation("获取客户详情页面线索机会条数")
    public Result<CustomerDetailLeadsChanceResCount> getPageForCustomerDetailCount(@ModelAttribute LeadsForCustomerDetailReqDto dto) throws BaseException {
        return customerService.getPageForCustomerDetailCount(dto);
    }


    @RequestMapping(value = "/get/risk_evaluation_result", method = RequestMethod.GET)
    @ApiOperation(value = "获取分析测评结果(客户id)")
    public Result<CustomerRiskResDto> getRiskEvaluationByCustomerId(@RequestParam Long customerId) throws Exception {
//        if (!customerService.hasReadCustomerPermission(customerId)) {
//            return Result.newFailureResult(CodeConstant.CODE_1220015);
//        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("customerId", customerId);
        return HttpUtils.get(TenantUrl.GET_CUSTOMER_RISK_EVALUATION, map, new BaseTypeReference<Result<CustomerRiskResDto>>() {
        });
    }

    @RequestMapping(value = "update_assets", method = RequestMethod.POST)
    @ApiOperation("修改客户资产证明")
    public Result<Long> updateAssets(@ModelAttribute UpdateAssejtsDto updateAssejtsDto) throws BaseException {
        return HttpUtils.post(TenantUrl.CUSTOMER_UPDATE_ASSETS, ArgsUtils.toMap(updateAssejtsDto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "update_credentials", method = RequestMethod.POST)
    @ApiOperation("修改客户证件")
    public Result<Long> updateCredentials(@ModelAttribute UpdateCredentialsDto credentialsDto) throws BaseException {
        return HttpUtils.post(TenantUrl.CUSTOMER_UPDATE_CREDENTIALS, ArgsUtils.toMap(credentialsDto), new BaseTypeReference<Result<Long>>() {
        });
    }
}
