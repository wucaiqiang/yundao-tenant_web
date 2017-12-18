package com.yundao.tenant.web.controller.product.examine;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.product.examine.ProductAuditRecordResDto;
import com.yundao.tenant.web.dto.product.examine.ProductAuditReqDto;
import com.yundao.tenant.web.dto.product.examine.ProductExaminePageReqDto;
import com.yundao.tenant.web.dto.product.examine.ProductExaminePageResDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 产品审核控制器
 *
 * @author jan
 * @create 2017-07-22 PM1:29
 **/
@Controller
@RequestMapping("/product/control/audit")
@ResponseBody
@Api(value = "产品-->产品审核")
public class ProductExamineController {

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation(value = "获取分页")
    public Result<PaginationSupport<ProductExaminePageResDto>> getPage(@ModelAttribute
                                                                               ProductExaminePageReqDto dto) throws BaseException {
        return HttpUtils.get(TenantUrl.GET_PRODUCT_EXAMINES, ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<ProductExaminePageResDto>>>() {
        });
    }


    @RequestMapping(value = "/do", method = RequestMethod.POST)
    @ApiOperation(value = "审核")
    public Result<Long> audit(@ModelAttribute ProductAuditReqDto dto) throws
            BaseException {
        return HttpUtils.post(TenantUrl.AUDIT_PRODUCT_EXAMINE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>
                () {
        });
    }
    
    
    @ApiOperation(value = "查询审核历史记录")
    @RequestMapping(value = "get_history_audit_detail", method = RequestMethod.GET)
    public Result<List<ProductAuditRecordResDto>> getAuditDetail(@RequestParam Long productId)throws BaseException {
    	Map<String, Object> map = new HashMap<String,Object>();
    	map.put("productId", productId);
    	return HttpUtils.get(TenantUrl.GET_PRODUCT_AUDIT_HISTORY, map, new BaseTypeReference<Result<List<ProductAuditRecordResDto>>> () {});
    }

}
