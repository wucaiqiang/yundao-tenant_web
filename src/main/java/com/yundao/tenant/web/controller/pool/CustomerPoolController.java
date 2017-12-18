package com.yundao.tenant.web.controller.pool;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.customer.pool.CustomerPoolPageReqDto;
import com.yundao.tenant.web.dto.customer.pool.CustomerPoolPageResDto;
import com.yundao.tenant.web.service.pool.CustomerPoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 客户池控制器
 *
 * @author jan
 * @create 2017-08-14 AM11:47
 **/
@Controller
@RequestMapping("/customer/pool")
@ResponseBody
@Api("客户池")
public class CustomerPoolController {

    @Autowired
    private CustomerPoolService customerPoolService;

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation("获取客户池分页数据数据")
    public Result<PaginationSupport<CustomerPoolPageResDto>> getPage(@ModelAttribute CustomerPoolPageReqDto dto) throws BaseException {
        return customerPoolService.getPage(dto);
    }




}
