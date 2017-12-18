package com.yundao.tenant.web.controller.login;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.constant.HeaderConstant;
import com.yundao.core.enums.AppTypeEnum;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.CookieUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.constant.url.ScmUrl;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.login.RetrievePasswordDto;
import com.yundao.tenant.web.dto.login.RsaPublicResDto;
import com.yundao.tenant.web.dto.resource.ResourceResDto;
import com.yundao.tenant.web.dto.user.UserDetailResDto;
import com.yundao.tenant.web.dto.user.password.UserUpdatePasswordReqDto;
import com.yundao.tenant.web.dto.user.password.UserloginReqDto;
import com.yundao.tenant.web.service.login.LoginService;
import com.yundao.tenant.web.service.login.LoginlogService;
import com.yundao.tenant.web.service.resource.ResourceService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import com.yundao.tenant.web.util.SignUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户管理
 *
 * @author 欧阳利 2017年6月22日
 */
@RestController
@ResponseBody
@RequestMapping("/user")
@Api("系统管理-->密码管理")
public class LoginController {

    private static Log log = LogFactory.getLog(LoginController.class);

    @Autowired
    private LoginService loginService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private LoginlogService loginlogService;

    /**
     * 获取公钥 getKeyPairPublic:
     *
     * @return
     * @throws Exception
     * @author: wucq
     * @description:
     */
    @RequestMapping(value = "/get_key_public", method = RequestMethod.GET)
    @ApiOperation(value = "获取密钥对", notes = "获取密钥对")
    public Result<RsaPublicResDto> getKeyPairPublic() throws Exception {
        return loginService.selectKeyPairPublic();
    }

    /**
     * 修改用户密码
     *
     * @param userReqDto
     * @return
     */
    @RequestMapping(value = "/update_password", method = RequestMethod.POST)
    @ApiOperation(value = "修改用户密码", notes = "修改用户密码")
    public Result<Integer> updateUserPassword(@ModelAttribute UserUpdatePasswordReqDto userReqDto) throws Exception {
        return HttpUtils.post(TenantUrl.UPDATE_USER_PASSWORD, ArgsUtils.toMap(userReqDto),
                new BaseTypeReference<Result<Integer>>() {
                });
    }

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录", notes = "登录")
    public Result<UserDetailResDto> login(@ModelAttribute UserloginReqDto loginReqDto, HttpServletRequest request,
                                          HttpServletResponse response) throws Exception {
        Result<UserDetailResDto> result = null;
        try {
            result = loginService.login(loginReqDto, request);
        }catch (Exception e){
            log.error(e.getMessage());
            //记录登录日志日志
            boolean isLog = true;
            if(e instanceof BaseException){
                BaseException baseException = (BaseException) e;
                if(baseException.getCode() == 1000019 || baseException.getCode() == 1250001){
                    isLog = false;
                }
            }
            if(isLog) {
                loginlogService.logError(loginReqDto, request, e);
            }
            throw e;
        }

        if (result.getSuccess()) {
            UserDetailResDto dto = result.getResult();
//            if (dto.getIsDimission().equals(1)) {
//                return Result.newFailureResult(CodeConstant.CODE_1200117);
//            }
            if(dto.getIsEnabled().equals(0)){
                return Result.newFailureResult(CodeConstant.CODE_1200118);
            }

            CookieUtils.addCookie(response, CommonConstant.USERID, dto.getId().toString());
            CookieUtils.addCookie(response, CommonConstant.TICKET, dto.getTicket());
            CookieUtils.addCookie(response, CommonConstant.REAL_NAME, dto.getRealName());
            CookieUtils.addCookie(response, CommonConstant.TENANT_ID, dto.getTenantId().toString());
            CookieUtils.addCookie(response, HeaderConstant.HEADER_APP_TYPE, AppTypeEnum.B_PC.getType());
            long now = System.currentTimeMillis();
            String sign = SignUtils.getSign(String.valueOf(dto.getId()), dto.getTicket(), now);
            CookieUtils.addCookie(response, CommonConstant.COOKIE_SIGN, sign);
            CookieUtils.addCookie(response, CommonConstant.COOKIE_TIME, String.valueOf(now));
            String userId = dto.getId().toString();
            String realName = dto.getRealName();
            String tenantId = dto.getTenantId().toString();
            ResourceResDto resDto = resourceService.getMenu(Long.valueOf(tenantId), Long.valueOf(userId), realName);
            log.info("从后置系统返回resDto结果：%s", JsonUtils.objectToJson(resDto));
            if (resDto == null)
                resDto = new ResourceResDto();
            dto.setAuth(resDto.getAuth());
            dto.setMenu(resDto.getMenu());
        }
        loginlogService.logSuccess(loginReqDto, request, result);
        return result;
    }

    /**
     * 退出
     *
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ApiOperation(value = "退出", notes = "退出")
    public Result<Integer> logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Result<Boolean> result = loginService.logout();
        if (result.getSuccess()) {
            CookieUtils.deleteCookie(request, response, CommonConstant.USERID);
            CookieUtils.deleteCookie(request, response, CommonConstant.TICKET);
            CookieUtils.deleteCookie(request, response, CommonConstant.REAL_NAME);
            CookieUtils.deleteCookie(request, response, CommonConstant.TENANT_ID);
            CookieUtils.deleteCookie(request, response, HeaderConstant.HEADER_APP_TYPE);
        }
        return Result.newSuccessResult();
    }

    @RequestMapping(value = "/send_retrieve_captcha", method = RequestMethod.POST)
    @ApiOperation(value = "发送找回密码验证码", notes = "发送找回密码验证码")
    public Result<Boolean> sendRetrieveCaptcha(@RequestParam String mobile) throws BaseException {
        Map<String, Object> params = new HashMap<>();
        params.put("mobile", mobile);
        return HttpUtils.post(ScmUrl.USER_SEND_RETRIEVE_CAPTCHA, params, new BaseTypeReference<Result<Boolean>>() {
        });
    }

    @RequestMapping(value = "/retrieve_password", method = RequestMethod.POST)
    @ApiOperation(value = "找回密码", notes = "找回密码")
    public Result<Boolean> retrieveCaptcha(@ModelAttribute RetrievePasswordDto mobile) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(mobile);
        return HttpUtils.post(ScmUrl.USER_RETRIEVE_PASSWORD, params, new BaseTypeReference<Result<Boolean>>() {
        });
    }

}
