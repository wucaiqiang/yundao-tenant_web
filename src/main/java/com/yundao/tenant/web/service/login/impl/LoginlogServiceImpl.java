package com.yundao.tenant.web.service.login.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.threadlocal.ThreadLocalUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.login.LoginLogAddReqDto;
import com.yundao.tenant.web.dto.user.UserDetailResDto;
import com.yundao.tenant.web.dto.user.password.UserloginReqDto;
import com.yundao.tenant.web.service.login.LoginlogService;
import com.yundao.tenant.web.util.AddressData;
import com.yundao.tenant.web.util.AddressUtils;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by gjl on 2017/12/1.
 */
@Service
public class LoginlogServiceImpl extends AbstractService implements LoginlogService {

    private static Log log = LogFactory.getLog(LoginlogServiceImpl.class);
    @Override
    public void logError(UserloginReqDto loginReqDto, HttpServletRequest request, Exception e) throws BaseException {
        LoginLogAddReqDto logAddReqDto = getCommon(request);
        logAddReqDto.setLoginAccount(loginReqDto.getUserName());
        loginReqDto.setPassword(null);
        String params = JsonUtils.objectToJson(loginReqDto);
        logAddReqDto.setParams(params);
        logAddReqDto.setResult(0);
        String message = e.getMessage();
        if(e instanceof BaseException){
            BaseException baseException = (BaseException) e;
            message = JsonUtils.objectToJson(baseException);
        }
        logAddReqDto.setResultMessage(message);
        Map<String,Object> paramsMap= ArgsUtils.toMap(logAddReqDto);
        log.info("新增用户登录错误日志：" + paramsMap);
        Result<Long> result = HttpUtils.post(TenantUrl.LOGIN_LOG_ADD, paramsMap,new BaseTypeReference<Result<Long>>() {});
        log.info("新增用户登录错误日志返回：" + JsonUtils.objectToJson(result));
    }

    private LoginLogAddReqDto getCommon(HttpServletRequest request) {
        LoginLogAddReqDto addReqDto = new LoginLogAddReqDto();
        String ip = ThreadLocalUtils.getIp();
        addReqDto.setLoginIp(ip);
        AddressData addressData = AddressUtils.getAddresses(ip);
        addReqDto.setLoginAddress(addressData);
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        addReqDto.setModel(userAgent.toString());
        return addReqDto;
    }

    @Override
    public void logSuccess(UserloginReqDto loginReqDto, HttpServletRequest request, Result<UserDetailResDto> result) throws BaseException {
        LoginLogAddReqDto logAddReqDto = getCommon(request);
        logAddReqDto.setLoginAccount(loginReqDto.getUserName());
        loginReqDto.setPassword(null);
        String params = JsonUtils.objectToJson(loginReqDto);
        logAddReqDto.setParams(params);
        //资源和权限不记录
        logAddReqDto.setResult(result.getSuccess() ? 1 : 0);
        if(result.getSuccess()) {
            UserDetailResDto userDetailResDto = result.getResult();
            UserDetailResDto newUserDetail = new UserDetailResDto();
            BeanUtils.copyProperties(userDetailResDto, newUserDetail);
            newUserDetail.setMenu(null);
            newUserDetail.setAuth(null);
            logAddReqDto.setResultMessage(JsonUtils.objectToJson(newUserDetail));
            logAddReqDto.setUserAccountId(userDetailResDto.getId());
        }else{
            logAddReqDto.setResultMessage(JsonUtils.objectToJson(result.getResult()));
        }
        Map<String,Object> paramsMap= ArgsUtils.toMap(logAddReqDto);
        log.info("新增用户日志：" + paramsMap);
        Result<Long> logResult = HttpUtils.post(TenantUrl.LOGIN_LOG_ADD, paramsMap,new BaseTypeReference<Result<Long>>() {});
        log.info("新增用户日志返回：" + JsonUtils.objectToJson(logResult));
    }
}
