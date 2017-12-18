package com.yundao.tenant.web.controller.project.record;


import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.project.record.ProjectRecordDownloadReqDto;
import com.yundao.tenant.web.dto.project.record.ProjectRecordPageReqDto;
import com.yundao.tenant.web.dto.project.record.ProjectRecordPageResDto;
import com.yundao.tenant.web.service.am.project.ProjectPermissionService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目记录控制器
 *
 * @author jan
 * @create 2017-11-17 13:52
 **/
@Controller
@RequestMapping("/assets/project/record/")
@ResponseBody
@Api("项目管理 - 项目记录")
public class ProjectRecordController {

    @Autowired
    private ProjectPermissionService projectPermissionService;

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation("获取分页数据")
    public Result<PaginationSupport<ProjectRecordPageResDto>> getPage(@ModelAttribute ProjectRecordPageReqDto dto)
            throws BaseException {
        boolean isPermission = projectPermissionService.checkRead(dto.getProjectId());
        if (!isPermission) {
            return Result.newSuccessResult(new PaginationSupport<ProjectRecordPageResDto>());
        }

        return HttpUtils.get(AmUrl.GET_PROJECT_RECORD_PAGE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<ProjectRecordPageResDto>>>() {
        });
    }

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    @ApiOperation("获取分页数据")
    public Result<Boolean> download(@ModelAttribute ProjectRecordDownloadReqDto dto) throws BaseException {
        return HttpUtils.post(AmUrl.REPORT_PROJECT_RECORD_FOR_DOWNLOAD, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<Boolean>>() {
                });
    }

}