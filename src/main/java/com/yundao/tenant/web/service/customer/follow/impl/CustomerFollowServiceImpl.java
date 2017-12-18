package com.yundao.tenant.web.service.customer.follow.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.customer.follow.BaseCustomerFollowUp;
import com.yundao.tenant.web.dto.customer.follow.CustomerFollowUpPageDto;
import com.yundao.tenant.web.dto.customer.follow.CustomerFollowUpReqDto;
import com.yundao.tenant.web.service.customer.follow.CustomerFollowService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import org.springframework.stereotype.Service;

/**
 * 客户跟进服务实现
 *
 * @author jan
 * @create 2017-09-06 AM11:16
 **/
@Service
public class CustomerFollowServiceImpl implements CustomerFollowService {

    @Override
    public Result<Long> add(CustomerFollowUpReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.CUSTOMER_FOLLOW_ADD, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @Override
    public Result<PaginationSupport<BaseCustomerFollowUp>> get_page(CustomerFollowUpPageDto dto) throws Exception {
        String url = TenantUrl.CUSTOMER_FOLLOW_GETS_PUBLIC;
        return HttpUtils.get(url, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<PaginationSupport<BaseCustomerFollowUp>>>() {
                });

    }
}
