package com.yundao.tenant.web.controller.user.visit;


import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.customer.CustomerDetailVisitPageReqDto;
import com.yundao.tenant.web.dto.customer.CustomerDetailVisitPageResDto;
import com.yundao.tenant.web.dto.user.visit.UserVisitAddReqDto;
import com.yundao.tenant.web.dto.user.visit.UserVisitDetailForLeads;
import com.yundao.tenant.web.dto.user.visit.UserVisitPageReqDto;
import com.yundao.tenant.web.dto.user.visit.UserVisitPageResDto;
import com.yundao.tenant.web.service.user.UserVisitService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.DateUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 客户回访控制器
 *
 * @author jan
 * @create 2017-08-11 AM10:19
 **/
@Controller
@RequestMapping("/user/visit")
@ResponseBody
@Api("客户回访")
public class UserVisitController {

    @Autowired
    private UserVisitService userVisitService;

    @RequestMapping(value = "/get_page_for_customer_detail", method = RequestMethod.GET)
    @ApiOperation("获取客户详情页面的回访数据")
    public Result<PaginationSupport<CustomerDetailVisitPageResDto>> getCustomerDetailVisitPage(@ModelAttribute CustomerDetailVisitPageReqDto dto) throws BaseException {
        return userVisitService.getCustomerDetailVisitPage(dto);
    }

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation("分页数据")
    public Result<PaginationSupport<UserVisitPageResDto>> getCustomerDetailVisitPage(@ModelAttribute UserVisitPageReqDto dto) throws BaseException {
        if (BooleanUtils.isNotEmpty(dto.getSubDateEnd()))
            dto.setSubDateEnd(DateUtils.toEndDate(dto.getSubDateEnd()));
        if (BooleanUtils.isNotEmpty(dto.getVisitDateEnd()))
            dto.setVisitDateEnd(DateUtils.toEndDate(dto.getVisitDateEnd()));
        return userVisitService.getPage(dto);
    }

    @RequestMapping(value = "/do", method = RequestMethod.POST)
    @ApiOperation("回访")
    public Result<Long> doVisit(@Validated @ModelAttribute UserVisitAddReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.ADD_USER_VISIT, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "/get_detail_for_leads", method = RequestMethod.GET)
    @ApiOperation("获取销售线索页面回访详情")
    public Result<UserVisitDetailForLeads> getDetailForLeads(Long leadsId) throws BaseException {
        return HttpUtils.get(TenantUrl.GET_USER_VISIT_FOR_LEADS, ArgsUtils.toIdMap(leadsId, "leadsId"), new
                BaseTypeReference<Result<UserVisitDetailForLeads>>() {
                });
    }


}