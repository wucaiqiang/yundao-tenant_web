package com.yundao.tenant.web.service.resource;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.web.dto.resource.ResourceResDto;

/**
 * 资源服务接口
 *
 * @author jan
 * @create 2017-09-23 PM2:25
 **/
public interface ResourceService {

    /**
     * 获取当前用户拥有的菜单资源
     */
    ResourceResDto getMenu(Long tenantId, Long userId, String realName) throws BaseException;

    /**
     * 获取当前用户拥有的菜单资源
     */
    ResourceResDto getMenu() throws BaseException;
}
