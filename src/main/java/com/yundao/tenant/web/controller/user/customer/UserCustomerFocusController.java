package com.yundao.tenant.web.controller.user.customer;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 客户关注
 *
 * @author jan
 * @create 2017-08-10 PM2:04
 **/
@Controller
@RequestMapping("/user/customer")
@ResponseBody
@Api("客户关注")
public class UserCustomerFocusController {


    @RequestMapping(value = "/focus", method = RequestMethod.POST)
    @ApiOperation("批量关注")
    public Result<Boolean> focus(@RequestParam String customerIds) throws BaseException {
        return HttpUtils.post(TenantUrl.FOCUS_CUSTOMER, ArgsUtils.toIdMap(customerIds, "customerIds"), new BaseTypeReference<Result<Boolean>>() {
        });
    }

    @RequestMapping(value = "/v2/focus", method = RequestMethod.POST)
    @ApiOperation("批量关注v2版接口")
    public Result<Boolean> focusV2(@RequestParam String customerIds) throws BaseException {
        return HttpUtils.post(TenantUrl.FOCUS_CUSTOMER_V2, ArgsUtils.toIdMap(customerIds, "customerIds"), new BaseTypeReference<Result<Boolean>>() {
        });
    }

    @RequestMapping(value = "/unfocus", method = RequestMethod.POST)
    @ApiOperation("取消关注")
    public Result<Boolean> reverse(@RequestParam Long customerId) throws BaseException {
        return HttpUtils.post(TenantUrl.UNFOCUS_CUSTOMER, ArgsUtils.toIdMap(customerId, "customerId"), new BaseTypeReference<Result<Boolean>>() {
        });
    }

}
