package com.yundao.tenant.web.controller.sale.leads;


import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.customer.customer.CustomerIdReqDto;
import com.yundao.tenant.web.dto.sale.leads.*;
import com.yundao.tenant.web.service.sale.leads.LeadsService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.DateUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 销售线索
 *
 * @author jan
 * @create 2017-09-06 PM7:59
 **/
@Controller
@ResponseBody
@RequestMapping("/leads")
@Api("销售管理-->销售线索")
public class LeadsController {

    @Autowired
    private LeadsService leadsService;

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation("获取分页数据")
    public Result<PaginationSupport<LeadsPageResDto>> getPage(@ModelAttribute LeadsPageReqDto dto) throws BaseException {
        if (BooleanUtils.isNotEmpty(dto.getCreateDateEnd()))
            dto.setCreateDateEnd(DateUtils.toEndDate(dto.getCreateDateEnd()));
        return leadsService.getPage(dto);
    }

    @RequestMapping(value = "/customer/detail/get_page", method = RequestMethod.GET)
    @ApiOperation("获取客户详情页面销售线索列表")
    public Result<PaginationSupport<LeadsForCustomerDetailResDto>> getPageForCustomerDetail(@ModelAttribute LeadsForCustomerDetailReqDto dto) throws BaseException {
        return leadsService.getPageForCustomerDetail(dto);
    }

    @RequestMapping(value = "/customer/get_unallot", method = RequestMethod.GET)
    @ApiOperation("获取客户的未分配线索")
    public Result<List<LeadsRemindUnAllotResDto>> getUnAllot(@ModelAttribute CustomerIdReqDto dto) throws BaseException {
        return HttpUtils.get(TenantUrl.GET_LEADS_UN_ALLOT, ArgsUtils.toMap(dto), new BaseTypeReference<Result<List<LeadsRemindUnAllotResDto>>>() {
        });
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    @ApiOperation("处理销售线索")
    public Result<Long> doProcess(@ModelAttribute LeadsUpdateStatusReqDto dto) throws BaseException {
        return leadsService.doProcess(dto);
    }

    @RequestMapping(value = "/allot", method = RequestMethod.POST)
    @ApiOperation("分配回访")
    public Result<Boolean> allot(@ModelAttribute LeadsAllotReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.ALLOT_LEADS, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Boolean>>() {
        });
    }

    @RequestMapping(value = "/allot_to_fp", method = RequestMethod.POST)
    @ApiOperation("分配给理财师")
    public Result<Boolean> allotToFp(@ModelAttribute LeadsAllotToFpReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.ALLOT_LEADS_TO_FP, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Boolean>>() {
        });
    }

    @RequestMapping(value = "/try_allot", method = RequestMethod.POST)
    @ApiOperation("尝试分配回访")
    public Result<List<LeadsRemindResDto>> tryAllot(@ModelAttribute LeadsAllotReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.ALLOT_TRY_LEADS, ArgsUtils.toMap(dto), new BaseTypeReference<Result<List<LeadsRemindResDto>>>() {
        });
    }

}
