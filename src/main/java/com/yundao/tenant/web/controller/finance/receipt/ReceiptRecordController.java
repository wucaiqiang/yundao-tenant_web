package com.yundao.tenant.web.controller.finance.receipt;

import com.yundao.core.code.Result;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.finance.receipt.DeclarationForReceiptResDto;
import com.yundao.tenant.web.dto.finance.receipt.ReceiptRecordAddReqDto;
import com.yundao.tenant.web.dto.finance.receipt.ReceiptRecordDelReqDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author jan
 * @create 2017-10-14 18:01
 **/
@Api("回款记录")
@Controller
@ResponseBody
@RequestMapping("/receipt/record/")
public class ReceiptRecordController {

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation(value = "新增回款记录")
    public Result<Long> add(@ModelAttribute ReceiptRecordAddReqDto dto) throws Exception {
        Map<String, Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.post(TenantUrl.ADD_RECEIPT_RECORD, params, new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除回款记录")
    public Result<PermissionResultDto> add(@ModelAttribute ReceiptRecordDelReqDto dto) throws Exception {
        Map<String, Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.post(TenantUrl.DELETE_RECEIPT_RECORD, params, new BaseTypeReference<Result<PermissionResultDto>>() {
        });
    }

    @RequestMapping(value = "get_can_receipt_declarations", method = RequestMethod.GET)
    @ApiOperation(value = "获取可以回款的报单数据")
    public Result<List<DeclarationForReceiptResDto>> getCanReceiptDeclarations(@RequestParam Long productId) throws Exception {
        return HttpUtils.get(TenantUrl.GET_RECEIPT_RECORD_CAN_RECEIPT_DECLARATIONS, ArgsUtils.toIdMap(productId, "productId"), new
                BaseTypeReference<Result<List<DeclarationForReceiptResDto>>>() {
                });
    }
}
