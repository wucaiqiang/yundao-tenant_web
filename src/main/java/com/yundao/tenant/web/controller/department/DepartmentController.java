package com.yundao.tenant.web.controller.department;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.department.DepartmentAddReqDto;
import com.yundao.tenant.web.dto.department.DepartmentDetailResDto;
import com.yundao.tenant.web.dto.department.DepartmentListResDto;
import com.yundao.tenant.web.dto.department.DepartmentUpdateReqDto;
import com.yundao.tenant.web.dto.permission.PermissionMultiCodeDto;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门控制器
 *
 * @author jan
 * @create 2017-07-01 PM6:07
 **/
@RestController
@RequestMapping("/department")
@ResponseBody
@Api("系统管理-->部门")
public class DepartmentController {

    @Autowired
    private PermissionService permissionService;

    @ApiOperation(value = "添加部门", notes = "返回部门id")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Long> add(@ModelAttribute DepartmentAddReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.ADD_DEPARTMENT, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @ApiOperation(value = "根据id获取部门")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result<DepartmentDetailResDto> get(@RequestParam Long id) throws BaseException {
        Result<DepartmentDetailResDto> result = HttpUtils.get(TenantUrl.GET_DEPARTMENT, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<DepartmentDetailResDto>>() {
        });

        return result;
    }

    @ApiOperation(value = "部门列表查询")
    @RequestMapping(value = "/gets", method = RequestMethod.GET)
    public Result<List<DepartmentListResDto>> gets() throws BaseException {
        return HttpUtils.get(TenantUrl.GET_DEPARTMENTS, null, new BaseTypeReference<Result<List<DepartmentListResDto>>>() {
        });

    }

    @ApiOperation(value = "修改部门", notes = "返回部门id")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Long> update(@ModelAttribute DepartmentUpdateReqDto dto) throws
            BaseException {
        return HttpUtils.post(TenantUrl.UPDATE_DEPARTMENT, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @ApiOperation(value = "删除部门", notes = "返回部门id")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Long> delete(@RequestParam Long id) throws BaseException {
        return HttpUtils.post(TenantUrl.DELETE_DEPARTMENT, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<Long>>
                () {
        });
    }

}
