package com.yundao.tenant.web.controller.resource;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.utils.CookieUtils;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.resource.MenuResDto;
import com.yundao.tenant.web.dto.resource.ResourceResDto;
import com.yundao.tenant.web.service.resource.ResourceService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限资源控制器
 *
 * @author jan
 * @create 2017-06-30 PM5:16
 **/
@Controller
@ResponseBody
@RequestMapping("/resource")
@Api("系统管理-->权限资源")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    /**
     * 获取当前用户的菜单资源
     *
     * @return 菜单资源
     * @throws BaseException 异常信息
     */
    @RequestMapping(value = "/get_menu", method = RequestMethod.GET)
    @ApiOperation(value = "获取当前用户的菜单", notes = "当前用户：userId在请求头设置即可")
    public Result<ResourceResDto> getMenu() throws BaseException {
        return Result.newSuccessResult(resourceService.getMenu());
    }


    /**
     * 获取角色的资源
     *
     * @param roleId 角色id
     * @return 角色资源
     * @throws BaseException 异常信息
     */
    @RequestMapping(value = "/get_by_role_id", method = RequestMethod.GET)
    @ApiOperation(value = "获取角色资源", notes = "管理员给该角色设置权限资源时使用")
    public Result<List<MenuResDto>> getByRoleId(@RequestParam Long roleId) throws BaseException {
        return HttpUtils.get(TenantUrl.GET_RESOURCE_BY_ROLE_ID, ArgsUtils.toIdMap(roleId, "roleId"), new BaseTypeReference<Result<List<MenuResDto>>>
                () {
        });
    }


    /**
     * 设置角色的资源
     *
     * @param resourceIds 多个资源id,以逗号分隔
     * @param roleId      角色id
     * @return 操作结果
     * @throws BaseException 异常信息
     */
    @RequestMapping(value = "/update_by_role_id", method = RequestMethod.POST)
    @ApiOperation(value = "设置角色资源", notes = "管理员为该角色设置权限资源")
    public Result<Integer> updateByRoleId(@RequestParam String resourceIds, @RequestParam Long roleId) throws
            BaseException {
        Map<String, Object> parmas = new HashMap<>(2);
        parmas.put("resourceIds", resourceIds);
        parmas.put("roleId", roleId);
        return HttpUtils.post(TenantUrl.UPDATE_RESOURCE_BY_ROLE_ID, parmas, new
                BaseTypeReference<Result<Integer>>() {
                });
    }

    @RequestMapping(value = "/gets", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有资源")
    public Result<List<MenuResDto>> gets() throws
            BaseException {
        return HttpUtils.get(TenantUrl.GET_REOUSRCES, null, new BaseTypeReference<Result<List<MenuResDto>>>
                () {
        });
    }

    @RequestMapping(value = "set", method = RequestMethod.GET)
    public String setUser(HttpServletResponse response) throws BaseException {
        CookieUtils.addCookie(response, CommonConstant.USERID, "1");
        CookieUtils.addCookie(response, CommonConstant.REAL_NAME, "招财猫");
        return "success";
    }

}
