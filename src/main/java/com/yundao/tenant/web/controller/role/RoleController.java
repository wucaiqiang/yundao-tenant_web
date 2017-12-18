package com.yundao.tenant.web.controller.role;

import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.role.RoleDetailResDto;
import com.yundao.tenant.web.dto.role.RoleReqDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色控制器
 *
 * @author jan
 * @create 2017-07-01 PM3:34
 **/
@Controller
@RequestMapping("/role")
@ResponseBody
@Api("系统管理-->角色")
public class RoleController {


    /**
     * 添加角色
     *
     * @param dto 请求dto
     * @return 操作结果
     * @throws BaseException 异常信息
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加角色", notes = "参数id不需填写，返回角色id")
    public Result<Long> add(@ModelAttribute RoleReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.ADD_ROLE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    /**
     * 修改角色
     *
     * @param dto 请求dto
     * @return 操作结果
     * @throws BaseException 异常信息
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "修改角色", notes = "返回角色id")
    public Result<Long> edit(@ModelAttribute RoleReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.UPDATE_ROLE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }


    /**
     * 获取角色
     *
     * @param id 角色id
     * @return 操作结果
     * @throws BaseException 异常信息
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation(value = "根据id获取角色")
    public Result<RoleDetailResDto> get(@RequestParam Long id) throws BaseException {
        return HttpUtils.get(TenantUrl.GET_ROLE, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<RoleDetailResDto>>() {
        });
    }

    /**
     * 获取角色
     *
     * @return 操作结果
     * @throws BaseException 异常信息
     */
    @RequestMapping(value = "/gets", method = RequestMethod.GET)
    @ApiOperation(value = "获取租户角色列表")
    public Result<List<RoleDetailResDto>> gets() throws BaseException {
        return HttpUtils.get(TenantUrl.GET_ROLES, null, new BaseTypeReference<Result<List<RoleDetailResDto>>>() {
        });
    }

    /**
     * 删除角色
     *
     * @param id 角色id
     * @return 操作结果
     * @throws BaseException 异常信息
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除角色")
    public Result<Boolean> delete(@RequestParam Long id) throws BaseException {
        return HttpUtils.post(TenantUrl.DELETE_ROLE, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<Boolean>>() {
        });
    }

}