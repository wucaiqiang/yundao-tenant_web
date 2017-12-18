package com.yundao.tenant.web.constant.url;

import com.yundao.core.utils.ConfigUtils;
import com.yundao.tenant.web.enums.url.UrlEnum;

/**
 * @author jan
 * @create 2017-08-08 PM2:51
 **/
public interface ScmUrl {

    /**
     * HOST地址
     */
    String BASE_URL = ConfigUtils.getValue(UrlEnum.SCM_URL.getKey());


    /**
     * 获取租户id
     */
    String GET_TENANT_ID = BASE_URL + "/domainname/get_tenant";

    /**
     * 获取所有可用的租户域名
     */
    String GET_TENANT_DOMAIN = BASE_URL + "/domainname/get_tenant_domain";
    String GET_TENANT = BASE_URL + "/tenant/get";
    String TICKET_VALIDATE = BASE_URL + "/ticket/validate";
    String USER_LOGINOUT = BASE_URL + "/user/logout";
    /**
     * 获取租户密钥对
     */
    String KEY_PAIR_GET_BY_TENANT_ID = BASE_URL + "/keypair/get_by_tenant_id";
    String USER_LOGIN = BASE_URL + "/user/login";
    String USER_SEND_RETRIEVE_CAPTCHA = BASE_URL + "/user/send_retrieve_captcha";
    String USER_RETRIEVE_PASSWORD = BASE_URL + "/user/retrieve_password";
    String USER_CHECK_ACCOUNT = BASE_URL + "/user/check_account";

    String GET_USER_TENANTS = BASE_URL + "/tenant/gets_by_account_id";

    /**
     * 校验用户密码
     */
    String CHECK_USER_PASSWORD = BASE_URL + "/user/check_pwd";
}
