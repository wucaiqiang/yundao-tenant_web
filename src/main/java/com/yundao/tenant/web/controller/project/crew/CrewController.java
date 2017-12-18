package com.yundao.tenant.web.controller.project.crew;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.UpdateOnlyReqDto;
import com.yundao.tenant.web.dto.project.ProjectIdReqDto;
import com.yundao.tenant.web.dto.project.company.CompanyDetailResDto;
import com.yundao.tenant.web.dto.project.crew.CrewUpdateReqDto;
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
 * Created by gjl on 2017/11/20.
 */
@Controller
@RequestMapping("/assets/project/crew")
@ResponseBody
@Api("项目管理 - 项目组员")
public class CrewController {

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation("修改项目组员")
    public Result<Long> update(@ModelAttribute CrewUpdateReqDto dto) throws BaseException {
        return HttpUtils.post(AmUrl.PROJECT_CREW_UPDATE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }
}
