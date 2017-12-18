package com.yundao.tenant.web.interceptor;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.constant.RequestHeaderConstant;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.resource.AuthResultDto;
import com.yundao.tenant.web.util.HttpUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 权限资源拦截器
 *
 * @author jan
 * @create 2017-07-02 AM11:59
 **/
public class ResourceInterceptor extends HeaderUserInterceptor {

    private static Log log = LogFactory.getLog(ResourceInterceptor.class);


    /**
     * 请求进入
     *
     * @param request  请求
     * @param response 响应
     * @param handler  对象
     * @return 结果
     * @throws Exception 异常信息
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String logPrefix = "资源拦截器||url校验||";
        String accept = request.getHeader("Accept");
        log.info("Url：%s   Request Accept：%s", request.getRequestURI(), accept);

        //先要调用HeaderUser拦截器，把租户id拿到
        super.preHandle(request, response, handler);
        HeaderUser user = (HeaderUser) request.getAttribute(CommonConstant.HEADER_USER);
        if (user == null) {
            log.info("%s user is null", logPrefix);
            throw new BaseException(CodeConstant.CODE_1200119);
        }

        String requestUrl = request.getRequestURI();

        Result<AuthResultDto> result = this.doAuthenticate(user, requestUrl);

        log.info("%s 鉴权结果 %s", logPrefix, JsonUtils.objectToJson(result));
        AuthResultDto authResult = result.getResult();
        if (authResult.getPermission())
            return true;

        throw new BaseException(CodeConstant.CODE_900002);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        long now = System.currentTimeMillis();
        long consumeTime = now - (Long) request.getAttribute(CommonConstant.BEGIN_TIME);
        log.info("now=" + now + ",consumeTime=" + consumeTime);
    }

    private Result<AuthResultDto> doAuthenticate(HeaderUser user, String requestUrl) throws BaseException {
        Map<String, Object> headerParams = new HashMap<>(2);
        headerParams.put(RequestHeaderConstant.HEADER_USER_ID, user.getUserId());
        headerParams.put(RequestHeaderConstant.HEADER_TENANT_ID, user.getTenantId());

        Map<String, Object> params = new HashMap<>(1);
        params.put("url", requestUrl);

        return HttpUtils.post(TenantUrl.RESOURCE_INTERCEPT_AUTHENTICATE, headerParams, params, new
                BaseTypeReference<Result<AuthResultDto>>() {
                });
    }


}
