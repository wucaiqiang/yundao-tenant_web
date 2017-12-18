package com.yundao.tenant.web.controller.customer.distribution;


import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.customer.CustomerMultiIdReqDto;
import com.yundao.tenant.web.dto.customer.distribution.CustomerAllotReqDto;
import com.yundao.tenant.web.dto.customer.distribution.CustomerAllotToCsReqDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 客户分配控制器
 *
 * @author jan
 * @create 2017-08-14 PM4:22
 **/
@Controller
@ResponseBody
@RequestMapping("/customer/v2/distribution")
@Api("客户调配V2")
public class CustomerDistributionV2Controller {

    @RequestMapping(value = "/allot_to_fp", method = RequestMethod.POST)
    @ApiOperation("分配客户给理财师")
    public Result<PermissionResultDto> doAllotToFp(@ModelAttribute CustomerAllotReqDto dto)
            throws BaseException {
        return HttpUtils.post(TenantUrl.CUSTOMER_DISTRIBUTION_ALLOT_TO_FP_V2, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<PermissionResultDto>>() {
                });
    }

    @RequestMapping(value = "/recycle", method = RequestMethod.POST)
    @ApiOperation("回收客户")
    public Result<PermissionResultDto> doRecycle(@ModelAttribute CustomerMultiIdReqDto dto)
            throws BaseException {
        return HttpUtils.post(TenantUrl.CUSTOMER_DISTRIBUTION_RECYCLE_V2, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<PermissionResultDto>>() {
                });
    }


    @RequestMapping(value = "/allot_to_cs", method = RequestMethod.POST)
    @ApiOperation("分配回访")
    public Result<Boolean> doAllotToCs(@ModelAttribute CustomerAllotToCsReqDto dto)
            throws BaseException {
        return HttpUtils.post(TenantUrl.CUSTOMER_DISTRIBUTION_ALLOT_TO_CS_V2, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<Boolean>>() {
                });
    }
}
