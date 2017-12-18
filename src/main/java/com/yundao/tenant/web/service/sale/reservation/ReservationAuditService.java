package com.yundao.tenant.web.service.sale.reservation;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.sale.reservation.audit.ReservationAuditPageReqDto;
import com.yundao.tenant.web.dto.sale.reservation.audit.ReservationAuditPageResDto;

/**
 * 预约审核服务接口
 *
 * @author jan
 * @create 2017-08-24 PM6:03
 **/
public interface ReservationAuditService {

    /**
     * 获取分页数据
     */
    Result<PaginationSupport<ReservationAuditPageResDto>> getPage(ReservationAuditPageReqDto dto) throws BaseException;
}
