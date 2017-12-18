package com.yundao.tenant.web.controller.opensea;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.customer.CustomerDetailResDto;
import com.yundao.tenant.web.dto.customer.opensea.CustomerOpenSeaPageReqDto;
import com.yundao.tenant.web.dto.customer.opensea.CustomerOpenSeaPageResDto;
import com.yundao.tenant.web.service.pool.CustomerPoolService;
import com.yundao.tenant.web.util.DateUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户池控制器
 *
 * @author jan
 * @create 2017-08-14 AM11:47
 **/
@Controller
@RequestMapping("/customer/opensea")
@ResponseBody
@Api("客户公海")
public class CustomerOpenSeaController {

    @Autowired
    private CustomerPoolService customerPoolService;


    @ApiOperation("获取公海分页数据数据")
    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    public Result<PaginationSupport<CustomerOpenSeaPageResDto>> getOpenSeaPage(@ModelAttribute CustomerOpenSeaPageReqDto dto) throws BaseException {
        dto.setCreateDateEnd(DateUtils.toEndDate(dto.getCreateDateEnd()));
        dto.setDealDateEnd(DateUtils.toEndDate(dto.getDealDateEnd()));
        return customerPoolService.getOpenSeaPage(dto);
    }


    @ApiOperation("领取公海客户")
    @RequestMapping(value = "/receive_customer", method = RequestMethod.POST)
    public Result<Integer> receiveCustomer(@RequestParam Long customerId) throws BaseException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("customerId", customerId);
        return HttpUtils.post(TenantUrl.RECEIVE_CUSTOMER_OPENSEA, map, new BaseTypeReference<Result<Integer>>() {
        });
    }

    @RequestMapping(value = "/get_detail", method = RequestMethod.GET)
    @ApiOperation(value = "获取公海客户表详细信息")
    public Result<CustomerDetailResDto> getDetail(@RequestParam Long id) throws Exception {
        return customerPoolService.getDetail(id);
    }

}
