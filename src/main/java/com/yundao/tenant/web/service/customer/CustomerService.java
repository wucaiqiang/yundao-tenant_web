package com.yundao.tenant.web.service.customer;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.customer.CustomerDetailResDto;
import com.yundao.tenant.web.dto.customer.CustomerExclusiveContactReqDto;
import com.yundao.tenant.web.dto.customer.MyCustomerPageReqDto;
import com.yundao.tenant.web.dto.customer.MyCustomerPageResDto;
import com.yundao.tenant.web.dto.customer.customer.*;
import com.yundao.tenant.web.dto.customer.v2.CustomerV2PageReqDto;
import com.yundao.tenant.web.dto.customer.v2.CustomerV2PageResDto;
import com.yundao.tenant.web.dto.sale.leads.LeadsForCustomerDetailReqDto;
import com.yundao.tenant.web.dto.user.customer.UserCustomerDto;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/**
 * 客户服务接口
 *
 * @author jan
 * @create 2017-08-09 PM2:46
 **/
public interface CustomerService {

    /**
     * 获取我的客户
     */
    Result<PaginationSupport<CustomerV2PageResDto>> getPageV2(CustomerV2PageReqDto dto) throws BaseException;

    /**
     * 获取我的客户
     */
    Result<PaginationSupport<MyCustomerPageResDto>> getMyPage(MyCustomerPageReqDto dto) throws BaseException;

    /**
     * 获取客户详情
     * getDetail:
     *
     * @param id
     * @return
     * @throws BaseException
     * @author: wucq
     * @description:
     */
    Result<CustomerDetailResDto> getDetail(Long id) throws BaseException;

    Result<Integer> updateContact(CustomerContactReqDto reqDto) throws BaseException;

    Result<Integer> updateInfo(CustomerExclusiveContactReqDto reqDto) throws BaseException;

    /**
     * 获取我的客户下拉选项
     */
    Result<List<CustomerSelectionResDto>> getMyCustomerSelections(CustomerSelectionReqDto dto) throws BaseException;

    /**
     * 获取客户所属信息
     *
     * @param customerId 客户id
     */
    UserCustomerDto getUserCustomer(Long customerId) throws BaseException;

    /**
     * 处理客户有效性
     */
    Result<Long> updateStatus(CustomerUpdateStatusReqDto dto) throws BaseException;

    /**
     * 是否有权限查询
     * hasReadCustomerPermission:
     *
     * @param customerId
     * @return
     * @throws BaseException
     * @author: 欧阳利
     * @description:
     */
    Boolean hasReadCustomerPermission(Long customerId) throws BaseException;

    Result<CustomerDetailLeadsChanceResCount> getPageForCustomerDetailCount(@ModelAttribute LeadsForCustomerDetailReqDto dto) throws BaseException;

}
