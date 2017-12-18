package com.yundao.tenant.web.controller.msg.feed;


import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.BasePageDto;
import com.yundao.tenant.web.dto.msg.MsgFeedResDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 客户动态
 *
 * @author gjl
 * @create 2017-08-16 PM3:35
 **/
@Controller
@RequestMapping("/msg/feed/")
@ResponseBody
@Api("客户动态")
public class MsgFeedController {

    @RequestMapping(value = "/get_customer_page", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询客户动态")
    public Result<PaginationSupport<MsgFeedResDto>> apply(@RequestParam Long customerId,@RequestParam(required = false) Integer firstType, @ModelAttribute BasePageDto pageDto) throws BaseException {
        Map<String,Object> params = ArgsUtils.toMap(pageDto);
        params.put("customerId",customerId);
        params.put("firstType",firstType);
        return HttpUtils.get(TenantUrl.GET_CUSTOMER_FEED, params, new BaseTypeReference<Result<PaginationSupport<MsgFeedResDto>>>() {});
    }
}
