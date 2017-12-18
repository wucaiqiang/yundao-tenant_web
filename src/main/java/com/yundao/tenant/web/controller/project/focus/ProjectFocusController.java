package com.yundao.tenant.web.controller.project.focus;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.project.ProjectIdsReqDto;
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
 * 项目关注
 *
 * @author jan
 * @create 2017-11-18 19:33
 **/
@Controller
@RequestMapping("/assets/project/focus")
@ResponseBody
@Api("项目管理 - 关注")
public class ProjectFocusController {

    @RequestMapping(value = "/do", method = RequestMethod.POST)
    @ApiOperation("关注")
    public Result<Boolean> focus(@ModelAttribute ProjectIdsReqDto dto) throws
            BaseException {
        return HttpUtils.post(AmUrl.FOCUS_PROJECT, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Boolean>>() {
        });
    }

    @RequestMapping(value = "/undo", method = RequestMethod.POST)
    @ApiOperation("取消关注")
    public Result<Boolean> unFocus(@ModelAttribute ProjectIdsReqDto dto) throws
            BaseException {
        return HttpUtils.post(AmUrl.UNFOCUS_PROJECT, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Boolean>>() {
        });
    }
}
