package com.yundao.tenant.web.controller.project.fund;


import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.fund.FundIdsReqDto;
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
 * 基金关注
 *
 * @author jan
 * @create 2017-11-26 14:20
 **/
@Controller
@RequestMapping("/assets/fund/focus")
@ResponseBody
@Api("基金 - 关注")
public class FundFocusController {

    @RequestMapping(value = "/do", method = RequestMethod.POST)
    @ApiOperation("关注基金")
    public Result<Boolean> focus(@ModelAttribute FundIdsReqDto dto) throws BaseException {
        return HttpUtils.post(AmUrl.FOCUS_FUND, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Boolean>>() {
        });
    }

    @RequestMapping(value = "/undo", method = RequestMethod.POST)
    @ApiOperation("取消关注")
    public Result<Boolean> unFocus(@ModelAttribute FundIdsReqDto dto) throws
            BaseException {
        return HttpUtils.post(AmUrl.UNFOCUS_FUND, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Boolean>>() {
        });
    }

}
