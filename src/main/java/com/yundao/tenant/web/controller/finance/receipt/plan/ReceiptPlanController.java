package com.yundao.tenant.web.controller.finance.receipt.plan;


import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.finance.receipt.plan.*;
import com.yundao.tenant.web.dto.product.supplier.ProductSupplierQuotationDetailDto;
import com.yundao.tenant.web.service.finance.receipt.plan.ReceiptPlanService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 回款计划
 *
 * @author jan
 * @create 2017-10-12 12:25
 **/
@Api("回款计划")
@Controller
@RequestMapping("/receipt/plan/")
@ResponseBody
public class ReceiptPlanController {

    @Autowired
    private ReceiptPlanService receiptPlanService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加回款计划")
    public Result<ReceiptPlanAddResult> add(@ModelAttribute ReceiptPlanAddReqDto dto) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.post(TenantUrl.ADD_RECEIPT_PLAN, params, new BaseTypeReference<Result<ReceiptPlanAddResult>>() {
        });
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "修改回款计划")
    public Result<Long> update(@ModelAttribute ReceiptPlanUpdateReqDto dto) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.post(TenantUrl.UPDATE_RECEIPT_PLAN, params, new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation(value = "获取回款计划详情")
    public Result<ReceiptPlanDetailDto> get(@ModelAttribute ReceiptPlanDetailReqDto dto) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.get(TenantUrl.GET_RECEIPT_PLAN, params, new BaseTypeReference<Result<ReceiptPlanDetailDto>>() {
        });
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除回款计划")
    public Result<PermissionResultDto> delete(@ModelAttribute ReceiptPlanDelReqDto dto) throws BaseException {
        return receiptPlanService.delete(dto);
    }

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation(value = "获取分页数据")
    public Result<PaginationSupport<ReceiptPlanPageResDto>> getPage(@ModelAttribute ReceiptPlanPageReqDto dto) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.get(TenantUrl.RECEIPT_PLAN_GET_PAGE, params, new BaseTypeReference<Result<PaginationSupport<ReceiptPlanPageResDto>>>() {
        });
    }

    @RequestMapping(value = "/check_name_exist", method = RequestMethod.GET)
    @ApiOperation(value = "检查回款计划名称是否存在,返回true：存在")
    public Result<Boolean> checkNameExist(@ModelAttribute ReceiptPlanCheckNameExist dto) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.get(TenantUrl.RECEIPT_PLAN_CHECK_NAME_EXIST, params, new BaseTypeReference<Result<Boolean>>() {
        });
    }

    @RequestMapping(value = "/check_name_exist_for_update", method = RequestMethod.GET)
    @ApiOperation(value = "检查回款计划名称是否存在（更新操作使用）返回true：存在")
    public Result<Boolean> checkNameExistForUpdate(@ModelAttribute ReceiptPlanCheckNameExistForUpdate dto) throws
            BaseException {
        Map<String, Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.get(TenantUrl.RECEIPT_PLAN_CHECK_NAME_EXIST_FOR_UPDATE, params, new BaseTypeReference<Result<Boolean>>() {
        });
    }

    @RequestMapping(value = "/detail/get_receipts", method = RequestMethod.GET)
    @ApiOperation(value = "获取回款记录列表,id:回款计划id")
    public Result<List<ReceiptPlanRecordListDto>> getReceiptRecord(@RequestParam Long id) throws BaseException {
        return HttpUtils.get(TenantUrl.GET_RECEIPT_PLAN_DETAIL_RECEIPTS, ArgsUtils.toIdMap(id), new
                BaseTypeReference<Result<List<ReceiptPlanRecordListDto>>>() {
                });
    }

    @RequestMapping(value = "/detail/get_declarations", method = RequestMethod.GET)
    @ApiOperation(value = "获取回款计划关联的报单列表,id:回款计划id")
    public Result<List<ReceiptPlanDeclarationDto>> getDeclarations(@RequestParam Long id) throws BaseException {
        return receiptPlanService.getDeclarations(id);
    }

    @RequestMapping(value = "/add_declaration_rel", method = RequestMethod.POST)
    @ApiOperation(value = "添加关联报单")
    public Result<PermissionResultDto> addDeclarationRel(@ModelAttribute DeclarationRelAddReqDto dto) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.post(TenantUrl.ADD_RECEIPT_PLAN_DECLARATION_REL, params, new
                BaseTypeReference<Result<PermissionResultDto>>() {
                });
    }

    @RequestMapping(value = "/delete_declaration_rel", method = RequestMethod.POST)
    @ApiOperation(value = "移除关联报单")
    public Result<PermissionResultDto> deleteDeclarationRel(@ModelAttribute DeclarationRelDelReqDto dto) throws
            BaseException {
        Map<String, Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.post(TenantUrl.DELETE_RECEIPT_PLAN_DECLARATION_REL, params, new
                BaseTypeReference<Result<PermissionResultDto>>() {
                });
    }

    @RequestMapping(value = "/detail/get_supplier", method = RequestMethod.GET)
    @ApiOperation(value = "获取产品供应商")
    public Result<ProductSupplierQuotationDetailDto> getSupplier(@ModelAttribute ReceiptPlanIdDto dto) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.get(TenantUrl.GET_RECEIPT_PLAN_SUPPLIER, params, new
                BaseTypeReference<Result<ProductSupplierQuotationDetailDto>>() {
                });
    }
}