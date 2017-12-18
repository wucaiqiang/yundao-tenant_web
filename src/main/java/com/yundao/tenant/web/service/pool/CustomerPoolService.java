package com.yundao.tenant.web.service.pool;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.customer.CustomerDetailResDto;
import com.yundao.tenant.web.dto.customer.opensea.CustomerOpenSeaPageReqDto;
import com.yundao.tenant.web.dto.customer.opensea.CustomerOpenSeaPageResDto;
import com.yundao.tenant.web.dto.customer.pool.CustomerPoolPageReqDto;
import com.yundao.tenant.web.dto.customer.pool.CustomerPoolPageResDto;

/**
 * 客户池服务接口
 *
 * @author jan
 * @create 2017-08-14 PM2:01
 **/
public interface CustomerPoolService {

    /**
     * 获取客户池分页数据
     */
    Result<PaginationSupport<CustomerPoolPageResDto>> getPage(CustomerPoolPageReqDto dto) throws BaseException;


    /**
     * 获取公海分页数据
     */
    Result<PaginationSupport<CustomerOpenSeaPageResDto>> getOpenSeaPage(CustomerOpenSeaPageReqDto dto) throws BaseException;

    /**
     * 获取公海客户详情
     *
     * @param id 客户id
     */
    Result<CustomerDetailResDto> getDetail(Long id) throws BaseException;


}
