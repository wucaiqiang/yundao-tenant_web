

package com.yundao.tenant.web.service.login;

import javax.servlet.http.HttpServletRequest;

import com.yundao.core.code.Result;
import com.yundao.tenant.web.dto.login.RsaPublicResDto;
import com.yundao.tenant.web.dto.login.UserAccountModel;
import com.yundao.tenant.web.dto.user.UserDetailResDto;
import com.yundao.tenant.web.dto.user.password.UserloginReqDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年7月27日 下午4:03:04 
 * @author   wucq
 * @version   
 */
public interface LoginService {
	public Result<RsaPublicResDto> selectKeyPairPublic()throws Exception;
	 /**
     * 用户登录
     * @param loginReqDto
     * @return
     */
    public Result<UserDetailResDto> login(UserloginReqDto loginReqDto,HttpServletRequest request)throws Exception;
    /**
     * ticket校验
     * validate:
     * @author: wucq
     * @param ticket
     * @return
     * @throws Exception
     * @description:
     */
    public Result<Boolean> validate(String ticket)throws Exception;
    /**
     * 用户退出
     * @param userId
     * @return
     */
    public Result<Boolean> logout()throws Exception;
}

