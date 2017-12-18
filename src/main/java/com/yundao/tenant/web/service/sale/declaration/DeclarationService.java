package com.yundao.tenant.web.service.sale.declaration;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.sale.declaration.DeclarationForProDetailResDto;

/**
 * 报单服务接口
 *
 * @author jan
 * @create 2017-09-11 PM4:03
 **/
public interface DeclarationService {

    /**
     * 获取产品详情页面分页数据
     *
     * @param productId 产品id
     */
    Result<PaginationSupport<DeclarationForProDetailResDto>> getPageForProductDetail(Long productId) throws
            BaseException;
}
