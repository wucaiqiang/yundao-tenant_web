package com.yundao.tenant.web.controller.sale.reservation;


import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.sale.reservation.ReservationAuditRecordResDto;
import com.yundao.tenant.web.dto.sale.reservation.ReservationDiscardReqDto;
import com.yundao.tenant.web.dto.sale.reservation.audit.ReservationAuditPageReqDto;
import com.yundao.tenant.web.dto.sale.reservation.audit.ReservationAuditPageResDto;
import com.yundao.tenant.web.dto.sale.reservation.audit.ReservationAuditReqDto;
import com.yundao.tenant.web.service.sale.reservation.ReservationAuditService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 预约审核
 *
 * @author jan
 * @create 2017-08-23 PM6:18
 **/
@Controller
@RequestMapping("/reservation/audit")
@ResponseBody
@Api("销售管理-->预约审核")
public class ReservationAuditController {

    @Autowired
    private ReservationAuditService reservationAuditService;

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation(value = "获取预约审核分页数据")
    public Result<PaginationSupport<ReservationAuditPageResDto>> getPage(@ModelAttribute ReservationAuditPageReqDto dto)
            throws BaseException {
        return reservationAuditService.getPage(dto);
    }

    @RequestMapping(value = "/do", method = RequestMethod.POST)
    @ApiOperation(value = "审核")
    public Result<Boolean> doAudit(@ModelAttribute ReservationAuditReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.RESERVATION_AUDIT_DO, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Boolean>>() {
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
    	return HttpUtils.post(TenantUrl.RESERVATION_DISCARD, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
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
    public Result<ReservationAuditRecordResDto> getWorkflowList(@RequestParam Long id) throws BaseException{
    	return HttpUtils.get(TenantUrl.GETS_RESERVATION_AUDIT_RECORD,ArgsUtils.toIdMap(id), new BaseTypeReference<Result<ReservationAuditRecordResDto>>() {
        });
    }

}
