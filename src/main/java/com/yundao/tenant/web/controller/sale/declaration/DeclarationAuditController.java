package com.yundao.tenant.web.controller.sale.declaration;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.sale.declaration.DeclarationAuditRecordResDto;
import com.yundao.tenant.web.dto.sale.declaration.audit.DeclarationAuditPageReqDto;
import com.yundao.tenant.web.dto.sale.declaration.audit.DeclarationAuditPageResDto;
import com.yundao.tenant.web.dto.sale.declaration.audit.DeclarationAuditReqDto;
import com.yundao.tenant.web.dto.sale.reservation.ReservationDiscardReqDto;
import com.yundao.tenant.web.service.sale.declaration.DeclarationAuditService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.DateUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 报单审核
 *
 * @author jan
 * @create 2017-08-27 PM3:44
 **/
@RestController
@RequestMapping(value = "/declaration/audit")
@ResponseBody
@Api("销售管理-->报单审核")
public class DeclarationAuditController {

    @Autowired
    private DeclarationAuditService declarationAuditService;

    @RequestMapping(value = "get_page", method = RequestMethod.GET)
    @ApiOperation(value = "查询分页数据")
    public Result<PaginationSupport<DeclarationAuditPageResDto>> getPage(@ModelAttribute DeclarationAuditPageReqDto dto) throws Exception {
        dto.setCommitDateEnd(DateUtils.toEndDate(dto.getCommitDateEnd()));
        dto.setOperationDateEnd(DateUtils.toEndDate(dto.getOperationDateEnd()));
        dto.setPayDateEnd(DateUtils.toEndDate(dto.getPayDateEnd()));
        return declarationAuditService.getPage(dto);
    }

    @RequestMapping(value = "/do", method = RequestMethod.POST)
    @ApiOperation(value = "审核")
    public Result<Boolean> getPage(@ModelAttribute DeclarationAuditReqDto dto) throws Exception {
        return HttpUtils.post(TenantUrl.DECLARATION_AUDIT_DO, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Boolean>>() {
        });
    }
    
    /**
     * 作废
     * @param dto
     * @param bindingResult
     * @return
     * @throws BaseException
     */
    @RequestMapping(value = "/discard", method = RequestMethod.POST)
    @ApiOperation("作废")
    public Result<Long> discard(@ModelAttribute ReservationDiscardReqDto dto) throws BaseException {
    	return HttpUtils.post(TenantUrl.DECLARATION_DISCARD, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }
    
    /**
     * 查询审核列表
     * @param id
     * @return
     * @throws BaseException
     */
    @RequestMapping(value = "/gets_audit_record", method = RequestMethod.GET)
    @ApiOperation("查询审核记录")
    public Result<DeclarationAuditRecordResDto> getWorkflowList(@RequestParam Long id) throws BaseException{
    	return HttpUtils.get(TenantUrl.GETS_DECLARATION_AUDIT_RECORD,ArgsUtils.toIdMap(id), new BaseTypeReference<Result<DeclarationAuditRecordResDto>>() {
        });
    }
}
