package com.yundao.tenant.web.service.sale.declaration.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.sale.declaration.audit.DeclarationAuditPageReqDto;
import com.yundao.tenant.web.dto.sale.declaration.audit.DeclarationAuditPageResDto;
import com.yundao.tenant.web.service.sale.declaration.DeclarationAuditService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import com.yundao.tenant.web.util.access.ResultAccess;
import org.springframework.stereotype.Service;

/**
 * 报单审核服务实现
 *
 * @author jan
 * @create 2017-08-27 PM3:48
 **/
@Service
public class DeclarationAuditServiceImpl implements DeclarationAuditService {

    @Override
    public Result<PaginationSupport<DeclarationAuditPageResDto>> getPage(DeclarationAuditPageReqDto dto) throws BaseException {
        Result<PaginationSupport<DeclarationAuditPageResDto>> result = HttpUtils.get(TenantUrl.DECLARATION_AUDIT_GET_PAGE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<DeclarationAuditPageResDto>>>() {
        });
        PaginationSupport<DeclarationAuditPageResDto> pages = result.getResult();
        if (BooleanUtils.isEmpty(pages.getDatas()))
            return result;
        return ResultAccess.newSuccessResultPage(result);
    }
}
