package com.yundao.tenant.web.controller.user;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.threadlocal.ThreadLocalUtils;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.StringUtils;
import com.yundao.tenant.web.constant.url.ScmUrl;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.tenant.TenantDto;
import com.yundao.tenant.web.dto.user.*;
import com.yundao.tenant.web.dto.user.password.UserCheckPwdReqDto;
import com.yundao.tenant.web.dto.user.role.UserRolePageReqDto;
import com.yundao.tenant.web.dto.user.role.UserRolePageResDto;
import com.yundao.tenant.web.service.user.UserService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用户管理
 *
 * @author 欧阳利
 *         2017年6月22日
 */
@RestController
@RequestMapping("/user")
@ResponseBody
@Api("系统管理-->用户管理")
public class UserController {

    private static Log log = LogFactory.getLog(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 添加用户信息
     *
     * @param userReqDto
     * @return
     */
    @ApiOperation(value = "添加用户", notes = "添加用户信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Long> addUser(@ModelAttribute UserAddReqDto userReqDto) throws Exception {
        log.info("添加用户：" + userReqDto.getMobile());
        return HttpUtils.post(TenantUrl.ADD_USER, ArgsUtils.toMap(userReqDto), new BaseTypeReference<Result<Long>>() {
        });
    }

    /**
     * 修改用户信息
     */
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    public Result<Long> modifyUser(@ModelAttribute UserUpdateReqDto UseReqDto) throws Exception {
        return userService.modifyUser(UseReqDto);
    }


    /**
     * 查询用户详细信息
     */
    @RequestMapping(value = "/get_by_id", method = RequestMethod.GET)
    @ApiOperation(value = "通过用户id查询用户详情", notes = "通过用户id查询用户详情")
    public Result<UserDetailResDto> getUserDetail(@RequestParam Long id) throws BaseException {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return HttpUtils.get(TenantUrl.GET_USER_BY_ID, map, new BaseTypeReference<Result<UserDetailResDto>>() {
        });
    }


//    /**
//     * 查询离职用户列表
//     */
//    @RequestMapping(value = "/get_dimission_users", method = RequestMethod.GET)
//    @ApiOperation(value = "分页查询离职用户列表", notes = "分页查询离职用户列表")
//    public Result<PaginationSupport<UserDimissionListResDto>> getDimissionUsers(@ModelAttribute UserDimissionListReqDto reqDto) throws BaseException {
//        return HttpUtils.get(TenantUrl.GETS_USER_DIMISSION, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<PaginationSupport<UserDimissionListResDto>>>() {
//        });
//    }

    /**
     * 查询离职用户列表
     */
    @RequestMapping(value = "/get_cease_users", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询停用的用户列表", notes = "分页查询离职用户列表")
    public Result<PaginationSupport<UserDimissionListResDto>> getCeaseUsers(@ModelAttribute UserDimissionListReqDto reqDto) throws BaseException {
        return HttpUtils.get(TenantUrl.GETS_USER_CEASE, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<PaginationSupport<UserDimissionListResDto>>>() {
        });
    }


//    /**
//     * 查询在职用户列表
//     */
//    @RequestMapping(value = "/get_not_dimission_users", method = RequestMethod.GET)
//    @ApiOperation(value = "分页查询在职用户列表", notes = "分页查询在职用户列表")
//    public Result<PaginationSupport<UserDimissionListResDto>> getNotDimissionUsers(@ModelAttribute UserDimissionListReqDto reqDto) throws BaseException {
//        return HttpUtils.get(TenantUrl.GETS_USER_NOT_DIMISSION, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<PaginationSupport<UserDimissionListResDto>>>() {
//        });
//    }

    /**
     * 查询在职用户列表
     */
    @RequestMapping(value = "/get_enabled_users", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询在职用户列表", notes = "分页查询在职用户列表")
    public Result<PaginationSupport<UserDimissionListResDto>> getEnabledUsers(@ModelAttribute UserDimissionListReqDto reqDto) throws BaseException {
        return HttpUtils.get(TenantUrl.GETS_USER_ENABLED, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<PaginationSupport<UserDimissionListResDto>>>() {
        });
    }

    /**
     * 查询在职用户列表
     */
    @RequestMapping(value = "/get_users", method = RequestMethod.GET)
    @ApiOperation(value = "查询在职用户列表", notes = "查询在职用户列表")
    public Result<List<UserDimissionListResDto>> getUsers(@ModelAttribute UserDimissionListReqDto reqDto) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(reqDto);
        params.put("pageSize", Integer.MAX_VALUE);
        Result<PaginationSupport<UserDimissionListResDto>> result = HttpUtils.get(TenantUrl.GETS_USER_ENABLED, params, new BaseTypeReference<Result<PaginationSupport<UserDimissionListResDto>>>() {
        });
        List<UserDimissionListResDto> resDtos = result.getResult().getDatas();
        return Result.newSuccessResult(resDtos);
    }


//     * 用户离职
//     */
//    @ApiOperation(value = "用户离职", notes = "用户离职")
//    @RequestMapping(value = "/dimission", method = RequestMethod.POST)
//    public Result<Integer> dimission(@RequestParam List<Long> ids) throws BaseException {
//        if (BooleanUtils.isEmpty(ids)) {
//            return Result.newFailureResult(1, "参数不能为空", null);
//        }
//        Map<String, Object> map = new HashMap<>();
//        map.put("ids", StringUtils.toString(ids));
//        return HttpUtils.post(TenantUrl.USER_DIMISSION, map, new BaseTypeReference<Result<Integer>>() {
//        });
//    }
//    /**

    /**
     * 用户停用
     */
    @ApiOperation(value = "用户停用", notes = "用户停用")
    @RequestMapping(value = "/cease", method = RequestMethod.POST)
    public Result<Integer> cease(@RequestParam List<Long> ids) throws BaseException {
        if (BooleanUtils.isEmpty(ids)) {
            return Result.newFailureResult(1, "参数不能为空", null);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("ids", StringUtils.toString(ids));
        return HttpUtils.post(TenantUrl.USER_CEASE, map, new BaseTypeReference<Result<Integer>>() {
        });
    }

    /**
     * 用户启用
     */
    @ApiOperation(value = "用户启用", notes = "用户启用")
    @RequestMapping(value = "/enabled", method = RequestMethod.POST)
    public Result<Integer> enabled(@RequestParam List<Long> ids) throws BaseException {
        if (BooleanUtils.isEmpty(ids)) {
            return Result.newFailureResult(1, "参数不能为空", null);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("ids", StringUtils.toString(ids));
        return HttpUtils.post(TenantUrl.USER_ENABLED, map, new BaseTypeReference<Result<Integer>>() {
        });
    }

    /**
     * 获取角色关联的用户分页数据
     */
    @RequestMapping(value = "/get_by_role", method = RequestMethod.GET)
    public Result<PaginationSupport<UserRolePageResDto>> getUserRolePage(@ModelAttribute UserRolePageReqDto dto) throws BaseException {
        return HttpUtils.get(TenantUrl.GETS_USER_BY_ROLE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<UserRolePageResDto>>>() {
        });
    }


    /**
     * 检查手机号码是否已经存在
     *
     * @param mobile
     * @return
     */
    @RequestMapping(value = "/check_mobile_exist", method = RequestMethod.GET)
    @ApiOperation(value = "检查手机号码是否已经使用", notes = "检查手机号码是否已经使用")
    public Result<CheckMobileResDto> checkMobileExist(@RequestParam String mobile) throws BaseException {
        Map<String, Object> map = new HashMap<>();
        map.put("mobile", mobile);
        return HttpUtils.get(TenantUrl.CHECK_USER_MOBILE_EXIST, map, new BaseTypeReference<Result<CheckMobileResDto>>() {
        });
    }


    /**
     * 检查用户名是否已经存在
     */
    @RequestMapping(value = "/check_username_exist", method = RequestMethod.GET)
    @ApiOperation(value = "检查登录用户名是否已经使用", notes = "检查登录用户名码是否已经使用")
    public Result<Boolean> checkUsernameExist(@RequestParam String username) throws BaseException {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        return HttpUtils.get(TenantUrl.CHECK_USER_USERNAME_EXIST, map, new BaseTypeReference<Result<Boolean>>() {
        });
    }

    /**
     * 检查工号是否已经存在
     *
     * @param jobNumber
     * @return
     */
    @ApiOperation(value = "检查工号是否存在", notes = "检查工号是否存在")
    @RequestMapping(value = "/check_job_number_exist", method = RequestMethod.GET)
    public Result<Boolean> checkJobNumberExist(@RequestParam String jobNumber) throws BaseException {
        Map<String, Object> map = new HashMap<>();
        map.put("jobNumber", jobNumber);
        return HttpUtils.get(TenantUrl.CHECK_USER_JOB_NUMBER_EXIST, map, new BaseTypeReference<Result<Boolean>>() {
        });
    }

    /**
     * 通过真实姓名查找在职用户
     *
     * @param realName
     * @return
     */
    @ApiOperation(value = "通过真实姓名查找在职用户", notes = "通过真实姓名查找在职用户")
    @RequestMapping(value = "/get_users_by_realName", method = RequestMethod.GET)
    public Result<List<UserOptionResDto>> getUsersByRealName(@RequestParam String realName) throws BaseException {
        Map<String, Object> map = new HashMap<>();
        map.put("realName", realName);
        return HttpUtils.get(TenantUrl.GETS_USER_BY_REALNAME, map, new BaseTypeReference<Result<List<UserOptionResDto>>>() {
        });
    }

    /**
     * 获取当前用户的租户
     *
     * @return
     */
    @ApiOperation(value = "获取当前用户的租户", notes = "获取当前用户的租户")
    @RequestMapping(value = "/get_tenants", method = RequestMethod.GET)
    public Result<List<TenantDto>> getTenantss() throws BaseException {
        HeaderUser user = (HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
        Map<String, Object> map = new HashMap<>();
        map.put("accountId", user.getUserId());
        return HttpUtils.get(ScmUrl.GET_USER_TENANTS, map, new BaseTypeReference<Result<List<TenantDto>>>() {
        });
    }

    @ApiOperation(value = "组织架构用户详情")
    @RequestMapping(value = "/get_for_org", method = RequestMethod.GET)
    public Result<UserOrgDetailDto> getForOrg(@RequestParam Long id) throws BaseException {
        return HttpUtils.get(TenantUrl.GETS_USER_FOR_ORG, ArgsUtils.toIdMap(id), new
                BaseTypeReference<Result<UserOrgDetailDto>>() {
                });
    }

    @RequestMapping(value = "/check_pwd", method = RequestMethod.GET)
    @ApiOperation("校验用户密码")
    public Result<Boolean> checkPwd(@ModelAttribute UserCheckPwdReqDto dto) throws BaseException {
        Map<String, Object> map = ArgsUtils.toMap(dto);
        HeaderUser user = (HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
        map.put("id", user.getUserId());
        Result<Boolean> result = HttpUtils.get(ScmUrl.CHECK_USER_PASSWORD, map, new BaseTypeReference<Result<Boolean>>
                () {
        });
        return result;
    }

    @ApiOperation(value = "检查是否能够添加员工，true:可以添加，false：不可添加")
    @RequestMapping(value = "/check_can_add", method = RequestMethod.GET)
    public Result<Boolean> checkCanAdd() throws BaseException {
        return HttpUtils.get(TenantUrl.CHECK_CAN_ADD, null, new BaseTypeReference<Result<Boolean>>
                () {
        });
    }
}
