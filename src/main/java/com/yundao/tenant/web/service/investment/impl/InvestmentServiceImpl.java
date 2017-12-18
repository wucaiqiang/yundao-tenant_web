package com.yundao.tenant.web.service.investment.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.investment.InvestmentPageReqDto;
import com.yundao.tenant.web.dto.investment.InvestmentPageResDto;
import com.yundao.tenant.web.service.investment.InvestmentService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import org.springframework.stereotype.Service;

/**
 * 投资管理服务实现
 *
 * @author jan
 * @create 2017-11-27 18:32
 **/
@Service
public class InvestmentServiceImpl implements InvestmentService {

    @Override
    public Result<PaginationSupport<InvestmentPageResDto>> getPage(InvestmentPageReqDto dto) throws BaseException {
        return HttpUtils.get(AmUrl.GET_INVESTMENT_PAGE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<InvestmentPageResDto>>>() {
        });
    }
}
