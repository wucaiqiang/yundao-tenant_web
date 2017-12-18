package com.yundao.tenant.web.service.tenant.impl;

import com.yundao.core.cache.redis.JedisUtils;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.web.cache.CacheKey;
import com.yundao.tenant.web.service.tenant.DomainService;

/**
 * 租户域名服务实现类
 *
 * @author jan
 * @create 2017-07-21 PM3:13
 **/
public class DomainServiceImpl implements DomainService {


    @Override
    public void flushCache() throws BaseException {
        JedisUtils.remove(CacheKey.TENANT_DOMAINS);
    }
}
