package com.yundao.tenant.web.service.customer.follow;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.customer.follow.BaseCustomerFollowUp;
import com.yundao.tenant.web.dto.customer.follow.CustomerFollowUpPageDto;
import com.yundao.tenant.web.dto.customer.follow.CustomerFollowUpReqDto;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 客户跟进服务接口
 *
 * @author jan
 * @create 2017-09-06 AM11:15
 **/
public interface CustomerFollowService {

    /**
     * 跟进
     */
    Result<Long> add(CustomerFollowUpReqDto dto) throws BaseException;

    Result<PaginationSupport<BaseCustomerFollowUp>> get_page(@ModelAttribute CustomerFollowUpPageDto dto) throws Exception;

}
