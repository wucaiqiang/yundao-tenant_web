package com.yundao.tenant.web.controller.msg.message;


import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.BasePageDto;
import com.yundao.tenant.web.dto.msg.MsgFeedResDto;
import com.yundao.tenant.web.dto.msg.MsgMessageCountResDto;
import com.yundao.tenant.web.dto.msg.MsgMessagePageResDto;
import com.yundao.tenant.web.dto.msg.MsgMessageReqDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户动态
 *
 * @author gjl
 * @create 2017-08-16 PM3:35
 **/
@Controller
@RequestMapping("/msg/message/")
@ResponseBody
@Api("消息")
public class MsgMessageController {

    private static Integer MESSAGE_TYPE = 2;

    @RequestMapping(value = "get_unread_count", method = RequestMethod.GET)
    @ApiOperation(value = "获取未读数")
    public Result<MsgMessageCountResDto> getUnreadCount() throws BaseException {
        return HttpUtils.get(TenantUrl.MESSAGE_UNREAD_COUNT, null, new BaseTypeReference<Result<MsgMessageCountResDto>>() {});
    }

    @RequestMapping(value = "read", method = RequestMethod.POST)
    @ApiOperation(value = "已读数")
    public Result<Integer> read(@RequestParam String ids) throws BaseException {
        Map<String,Object> params = new HashMap<>();
        params.put("ids",ids);
        return HttpUtils.get(TenantUrl.MESSAGE_READ, params, new BaseTypeReference<Result<Integer>>() {});
    }

    @RequestMapping(value = "readAll", method = RequestMethod.POST)
    @ApiOperation(value = "全部读数")
    public Result<Integer> read() throws BaseException {
        Map<String,Object> params = new HashMap<>();
        params.put("type",MESSAGE_TYPE);
        return HttpUtils.get(TenantUrl.MESSAGE_READ_ALL, params, new BaseTypeReference<Result<Integer>>() {});
    }

    @RequestMapping(value = "get_my_page", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询自己的消息")
    public Result<PaginationSupport<MsgMessagePageResDto>> getMyPage(@ModelAttribute MsgMessageReqDto pageDto) throws BaseException {
        Map<String,Object> params = ArgsUtils.toMap(pageDto);
        return HttpUtils.get(TenantUrl.MESSAGE_GET_MY, params, new BaseTypeReference<Result<PaginationSupport<MsgMessagePageResDto>>>() {});
    }
}
