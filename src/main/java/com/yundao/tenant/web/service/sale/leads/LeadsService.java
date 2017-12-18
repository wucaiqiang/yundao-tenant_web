package com.yundao.tenant.web.service.sale.leads;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.sale.leads.*;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 销售线索服务接口
 *
 * @author jan
 * @create 2017-09-07 PM9:46
 **/
public interface LeadsService {

    Result<PaginationSupport<LeadsPageResDto>> getPage(@ModelAttribute LeadsPageReqDto dto) throws BaseException;

    Result<PaginationSupport<LeadsForCustomerDetailResDto>> getPageForCustomerDetail(@ModelAttribute LeadsForCustomerDetailReqDto dto) throws BaseException;

    /**
     * 处理线索
     */
    Result<Long> doProcess(@ModelAttribute LeadsUpdateStatusReqDto dto) throws BaseException;

}
