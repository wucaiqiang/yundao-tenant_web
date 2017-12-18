package com.yundao.tenant.web.service.product;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.productnotice.ProductNoticeModel;
import com.yundao.tenant.web.enums.access.DataObjectPermissionEnum;

/**
 * Created by gjl on 2017/8/21.
 */
public interface ProductNoticeService {
    Boolean updatePermission(Long id, String code) throws BaseException;

    Result<PermissionResultDto> delete(String ids) throws BaseException;

    void checkUpdatePermission(Result<PaginationSupport<ProductNoticeModel>> result) throws BaseException;

    DataObjectPermissionEnum getDataObjectPermissionEnum() throws BaseException;
}
