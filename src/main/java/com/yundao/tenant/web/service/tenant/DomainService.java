package com.yundao.tenant.web.service.tenant;

import com.yundao.core.exception.BaseException;

/**
 * 租户域名服务接口
 *
 * @author jan
 * @create 2017-07-21 PM3:12
 **/
public interface DomainService {

    /**
     * 清楚租户域名数据缓存
     */
    void flushCache() throws BaseException;


}
