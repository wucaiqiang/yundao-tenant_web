package com.yundao.tenant.web.service.finance.receipt.plan.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.finance.receipt.plan.ReceiptPlanDeclarationDto;
import com.yundao.tenant.web.dto.finance.receipt.plan.ReceiptPlanDelReqDto;
import com.yundao.tenant.web.service.finance.receipt.plan.ReceiptPlanService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import com.yundao.tenant.web.util.access.ResultAccess;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 回款计划服务实现
 *
 * @author jan
 * @create 2017-10-13 14:26
 **/
@Service
public class ReceiptPlanServiceImpl implements ReceiptPlanService {

    @Override
    public Result<PermissionResultDto> delete(ReceiptPlanDelReqDto dto) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.post(TenantUrl.DELETE_RECEIPT_PLAN, params, new BaseTypeReference<Result<PermissionResultDto>>
                () {
        });
    }

    @Override
    public Result<List<ReceiptPlanDeclarationDto>> getDeclarations(Long id) throws BaseException {
        Result<List<ReceiptPlanDeclarationDto>> result = HttpUtils.get(TenantUrl.GET_RECEIPT_PLAN_DETAIL_DECLARATIONS, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<List<ReceiptPlanDeclarationDto>>>() {
        });
        if (!result.getSuccess() || BooleanUtils.isEmpty(result.getResult()))
            return result;

        return ResultAccess.newSuccessResultList(result);
    }
}
