package com.yundao.tenant.web.service.sale.declaration;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.sale.declaration.audit.DeclarationAuditPageReqDto;
import com.yundao.tenant.web.dto.sale.declaration.audit.DeclarationAuditPageResDto;

/**
 * 报单审核服务接口
 *
 * @author jan
 * @create 2017-08-27 PM3:47
 **/
public interface DeclarationAuditService {

    /**
     * 获取分页数据
     */
    Result<PaginationSupport<DeclarationAuditPageResDto>> getPage(DeclarationAuditPageReqDto dto) throws BaseException;
}
