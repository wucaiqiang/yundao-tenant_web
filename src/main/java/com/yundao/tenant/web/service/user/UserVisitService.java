package com.yundao.tenant.web.service.user;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.customer.CustomerDetailVisitPageReqDto;
import com.yundao.tenant.web.dto.customer.CustomerDetailVisitPageResDto;
import com.yundao.tenant.web.dto.user.visit.UserVisitPageReqDto;
import com.yundao.tenant.web.dto.user.visit.UserVisitPageResDto;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 客户回访服务接口
 *
 * @author jan
 * @create 2017-08-12 PM2:08
 **/
public interface UserVisitService {

    /**
     * 获取客户详情页面的回访数据
     */
    Result<PaginationSupport<CustomerDetailVisitPageResDto>> getCustomerDetailVisitPage(@ModelAttribute CustomerDetailVisitPageReqDto dto) throws BaseException;

    /**
     * 获取分页数据
     */
    Result<PaginationSupport<UserVisitPageResDto>> getPage(@ModelAttribute UserVisitPageReqDto dto) throws BaseException;
}
