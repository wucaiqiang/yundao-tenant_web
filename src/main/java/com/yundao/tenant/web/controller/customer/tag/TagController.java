package com.yundao.tenant.web.controller.customer.tag;

import com.yundao.core.code.Result;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.customer.tag.BaseTag;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户标签
 * Created by gjl on 2017/8/8.
 */
@RestController
@RequestMapping("/customer/tag/")
@ResponseBody
@Api("客户标签")
public class TagController {

    @RequestMapping(value = "get_top", method= RequestMethod.GET)
    @ApiOperation(value="查询所有标签信息")
    public Result<List<BaseTag>> getTop()throws Exception{
        return HttpUtils.get(TenantUrl.TAG_GET_TOP, null, new BaseTypeReference<Result<List<BaseTag>>>() {
        });
    }

    @RequestMapping(value = "get_customer_tag", method=RequestMethod.GET)
    @ApiOperation(value="获取客户标签")
    public Result<List<BaseTag>> setCustomerTag(@RequestParam Long customerId)throws Exception{
        Map<String, Object> params = new HashMap<>();
        params.put("customerId", customerId);
        return HttpUtils.get(TenantUrl.TAG_GET_CUSTOMER, params, new BaseTypeReference<Result<List<BaseTag>>>() {});
    }
}
