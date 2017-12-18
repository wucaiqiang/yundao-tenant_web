package com.yundao.tenant.web.cache;

import com.yundao.core.utils.ConfigUtils;

/**
 * 缓存key
 *
 * @author jan
 * @create 2017-07-02 PM1:42
 **/
public class CacheKey {

    public static final String SYS_CODE = ConfigUtils.getValue("id") + ":";

    /**
     * 租户域名列表
     */
    public static final String TENANT_DOMAINS = SYS_CODE + "tenant_domains";

}
