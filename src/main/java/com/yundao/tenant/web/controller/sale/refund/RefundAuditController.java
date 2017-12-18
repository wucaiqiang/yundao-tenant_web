

package com.yundao.tenant.web.controller.sale.refund;

import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.sale.refund.RefundAuditListReqDto;
import com.yundao.tenant.web.dto.sale.refund.RefundAuditListResDto;
import com.yundao.tenant.web.dto.sale.refund.RefundAuditReqDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Function: 退款审批
 * Reason:	  
 * Date:     2017年10月16日 下午2:01:02 
 * @author   欧阳利
 * @version   
 */

@RestController
@RequestMapping(value = "/refund/audit")
@ResponseBody
@Api("销售管理-->退款审批")
public class RefundAuditController {
	
	
    @RequestMapping(value = "get_audit_page", method = RequestMethod.GET)
    @ApiOperation(value = "退款审批列表")
    public Result<PaginationSupport<RefundAuditListResDto>> getRefundAuditPage(@ModelAttribute RefundAuditListReqDto dto) throws Exception {
   	 Map<String, Object> params = ArgsUtils.toMap(dto);
     Result<PaginationSupport<RefundAuditListResDto>> result = HttpUtils.get(TenantUrl.REFUND_AUDIT_LIST_PAGE, params, new BaseTypeReference<Result<PaginationSupport<RefundAuditListResDto>>>() {
     });
     return result;
    }
    
    
    @RequestMapping(value = "do", method = RequestMethod.POST)
    @ApiOperation(value = "审批")
    public Result<Integer> doAudit(@ModelAttribute RefundAuditReqDto dto) throws Exception {
    	return HttpUtils.post(TenantUrl.REFUND_AUDIT_DO, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Integer>>() {
        });
    }
}

