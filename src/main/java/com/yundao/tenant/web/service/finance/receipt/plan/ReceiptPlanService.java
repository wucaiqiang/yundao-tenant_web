package com.yundao.tenant.web.service.finance.receipt.plan;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.finance.receipt.plan.ReceiptPlanDeclarationDto;
import com.yundao.tenant.web.dto.finance.receipt.plan.ReceiptPlanDelReqDto;

import java.util.List;

/**
 * 回款计划服务接口
 *
 * @author jan
 * @create 2017-10-13 14:26
 **/
public interface ReceiptPlanService {

    /**
     * 删除回款计划
     */
    Result<PermissionResultDto> delete(ReceiptPlanDelReqDto dto) throws BaseException;

    /**
     * 获取回款计划关联的报单
     *
     * @param id 回款计划id
     */
    Result<List<ReceiptPlanDeclarationDto>> getDeclarations(Long id) throws BaseException;
}
