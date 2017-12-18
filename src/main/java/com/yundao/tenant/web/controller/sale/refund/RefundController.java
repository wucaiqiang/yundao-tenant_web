

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
import com.yundao.tenant.web.dto.sale.refund.MyRefundListReqDto;
import com.yundao.tenant.web.dto.sale.refund.MyRefundListResDto;
import com.yundao.tenant.web.dto.sale.refund.RefundCancelReqDto;
import com.yundao.tenant.web.dto.sale.refund.RefundResubmitReqDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Function: 我的退款
 * Reason:	  
 * Date:     2017年10月16日 下午2:00:41 
 * @author   欧阳利
 * @version   
 */

@RestController
@RequestMapping(value = "/refund")
@ResponseBody
@Api("销售管理-->我的退款")
public class RefundController {
	
	
	
    @RequestMapping(value = "get_my_refund_page", method = RequestMethod.GET)
    @ApiOperation(value = "我的退款列表")
    public Result<PaginationSupport<MyRefundListResDto>> getMyRefundPage(@ModelAttribute MyRefundListReqDto dto) throws Exception {
    	 Map<String, Object> params = ArgsUtils.toMap(dto);
         Result<PaginationSupport<MyRefundListResDto>> result = HttpUtils.get(TenantUrl.REFUND_GET_MY_PAGE, params, new BaseTypeReference<Result<PaginationSupport<MyRefundListResDto>>>() {
         });
         return result;
    }

    
    
    @RequestMapping(value = "resubmit", method = RequestMethod.POST)
    @ApiOperation(value = "重新提交")
    public Result<Long> resubmit( @ModelAttribute RefundResubmitReqDto dto)
            throws Exception {
    	return HttpUtils.post(TenantUrl.REFUND_RESUBMIT, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    
    @RequestMapping(value = "cancel", method = RequestMethod.POST)
    @ApiOperation(value = "取消申请")
    public Result<Long> cancel(@ModelAttribute RefundCancelReqDto dto)
            throws Exception {
    	 return HttpUtils.post(TenantUrl.REFUND_CANCEL, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
         });
    }
}

