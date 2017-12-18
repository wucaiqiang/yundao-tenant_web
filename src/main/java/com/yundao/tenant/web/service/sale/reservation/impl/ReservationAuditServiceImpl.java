package com.yundao.tenant.web.service.sale.reservation.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.sale.reservation.audit.ReservationAuditPageReqDto;
import com.yundao.tenant.web.dto.sale.reservation.audit.ReservationAuditPageResDto;
import com.yundao.tenant.web.service.sale.reservation.ReservationAuditService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import com.yundao.tenant.web.util.access.ResultAccess;
import org.springframework.stereotype.Service;

/**
 * 预约审核服务接口
 *
 * @author jan
 * @create 2017-08-24 PM6:04
 **/
@Service
public class ReservationAuditServiceImpl implements ReservationAuditService {

    @Override
    public Result<PaginationSupport<ReservationAuditPageResDto>> getPage(ReservationAuditPageReqDto dto) throws BaseException {
        Result<PaginationSupport<ReservationAuditPageResDto>> result = HttpUtils.get(TenantUrl.GET_RESERVATION_AUDIT_PAGE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<ReservationAuditPageResDto>>>() {
        });
        PaginationSupport<ReservationAuditPageResDto> pages = result.getResult();
        if (BooleanUtils.isEmpty(pages.getDatas()))
            return result;
        return ResultAccess.newSuccessResultPage(result);
    }
}
