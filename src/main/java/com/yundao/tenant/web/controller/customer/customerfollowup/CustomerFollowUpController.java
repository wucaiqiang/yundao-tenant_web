package com.yundao.tenant.web.controller.customer.customerfollowup;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.customer.follow.BaseCustomerFollowUp;
import com.yundao.tenant.web.dto.customer.follow.CustomerFollowUpPageDto;
import com.yundao.tenant.web.dto.customer.follow.CustomerFollowUpReqDto;
import com.yundao.tenant.web.service.customer.follow.CustomerFollowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 客户跟进控制器
 *
 * @author gjl
 * @create 2017-08-10 PM2:45
 **/
@Controller
@RequestMapping("/customer/follow")
@Api("客户跟进管理")
@ResponseBody
public class CustomerFollowUpController {

    @Autowired
    private CustomerFollowService customerFollowService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加跟进")
    public Result<Long> add(@ModelAttribute CustomerFollowUpReqDto dto) throws BaseException {
        return customerFollowService.add(dto);
    }

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation(value = "获取客户跟进记录")
    public Result<PaginationSupport<BaseCustomerFollowUp>> get_page(@ModelAttribute CustomerFollowUpPageDto dto) throws Exception {
        return customerFollowService.get_page(dto);
    }
}
