package com.yundao.tenant.web.controller.customer.back;


import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.customer.back.CustomerBackApplyReqDto;
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
 * 客户回退
 *
 * @author jan
 * @create 2017-08-10 PM3:35
 **/
@Controller
@RequestMapping("/customer/v2/back")
@ResponseBody
@Api("客户回退 V2版本")
public class CustomerBackV2Controller {

    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    @ApiOperation(value = "放弃客户")
    public Result<PermissionResultDto> apply(@ModelAttribute CustomerBackApplyReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.BACK_CUSTOMER_APPLY_V2, ArgsUtils.toMap(dto), new BaseTypeReference<Result<PermissionResultDto>>
                () {
        });
    }
}
