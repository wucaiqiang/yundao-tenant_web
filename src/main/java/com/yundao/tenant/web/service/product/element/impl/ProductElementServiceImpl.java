package com.yundao.tenant.web.service.product.element.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.service.product.element.ProductElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jan
 * @create 2017-09-21 AM10:10
 **/
@Service
public class ProductElementServiceImpl implements ProductElementService {

    private static Log log = LogFactory.getLog(ProductElementServiceImpl.class);

    @Autowired
    private PermissionService permissionService;

    @Override
    public Result<PermissionResultDto> delete(String ids) throws BaseException {
        return null;
    }
}
