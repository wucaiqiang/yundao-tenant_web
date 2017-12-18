package com.yundao.tenant.web.service.login;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.web.dto.user.UserDetailResDto;
import com.yundao.tenant.web.dto.user.password.UserloginReqDto;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gjl on 2017/12/1.
 */
public interface LoginlogService {
    void logError(UserloginReqDto loginReqDto, HttpServletRequest request, Exception e) throws BaseException;

    void logSuccess(UserloginReqDto loginReqDto, HttpServletRequest request, Result<UserDetailResDto> result) throws BaseException;
}
