package com.yundao.tenant.web.service.sale.declaration.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.sale.declaration.DeclarationForProDetailResDto;
import com.yundao.tenant.web.service.sale.declaration.DeclarationService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import com.yundao.tenant.web.util.access.ResultAccess;
import org.springframework.stereotype.Service;

/**
 * 报单服务实现
 *
 * @author jan
 * @create 2017-09-11 PM4:04
 **/
@Service
public class DeclarationServiceImpl implements DeclarationService {

    @Override
    public Result<PaginationSupport<DeclarationForProDetailResDto>> getPageForProductDetail(Long productId) throws BaseException {
        Result<PaginationSupport<DeclarationForProDetailResDto>> result = HttpUtils.get(TenantUrl.GET_DECLARATION_PAGE_FOR_PRO_DETAIL, ArgsUtils.toIdMap(productId, "productId"), new BaseTypeReference<Result<PaginationSupport<DeclarationForProDetailResDto>>>() {
        });
        if (!result.getSuccess())
            return result;

        if (BooleanUtils.isEmpty(result.getResult().getDatas()))
            return Result.newSuccessResult(new PaginationSupport<DeclarationForProDetailResDto>());

        return ResultAccess.newSuccessResultPage(result);
    }
}
