package com.yundao.tenant.web.service.resource.impl;

import com.yundao.core.code.Result;
import com.yundao.core.constant.HeaderConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.resource.ResourceResDto;
import com.yundao.tenant.web.service.resource.ResourceService;
import com.yundao.tenant.web.util.HttpUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 资源服务实现
 *
 * @author jan
 * @create 2017-09-23 PM2:25
 **/
@Service
public class ResourceServiceImpl extends AbstractService implements ResourceService {

    private static Log log = LogFactory.getLog(ResourceServiceImpl.class);

    @Override
    public ResourceResDto getMenu(Long tenantId, Long userId, String realName) throws BaseException {
        String logPrefix = "资源服务||获取当前用户的资源||";
        log.info("%s tenantId:%s,userId:%s,realName:%s", logPrefix, tenantId, userId, realName);
        Map<String, Object> headerParams = new HashMap<>();
        headerParams.put(HeaderConstant.HEADER_USER_ID, userId);
        headerParams.put(HeaderConstant.HEADER_REAL_NAME, realName);
        headerParams.put(HeaderConstant.HEADER_TENANT_ID, tenantId);
        Result<ResourceResDto> result = HttpUtils.get(TenantUrl.GET_MENU, headerParams, null, new
                BaseTypeReference<Result<ResourceResDto>>() {
                });
        return result.getResult();
    }

    @Override
    public ResourceResDto getMenu() throws BaseException {
        Long tenantId = super.getHeaderTenantId();
        Long userId = super.getHeaderUserId();
        String realName = super.getRealName();
        return this.getMenu(tenantId, userId, realName);
    }
}
