package com.yundao.tenant.web.service.investment;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.investment.InvestmentPageReqDto;
import com.yundao.tenant.web.dto.investment.InvestmentPageResDto;

/**
 * 投资管理服务接口
 *
 * @author jan
 * @create 2017-11-27 18:31
 **/
public interface InvestmentService {

    Result<PaginationSupport<InvestmentPageResDto>> getPage(InvestmentPageReqDto dto) throws BaseException;
}
