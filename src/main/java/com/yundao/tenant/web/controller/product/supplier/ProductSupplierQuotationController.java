package com.yundao.tenant.web.controller.product.supplier;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.product.supplier.ProductSupplierQuotationDetailDto;
import com.yundao.tenant.web.dto.product.supplier.SupplierQuotationUpdateReqDto;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.service.product.ProductService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/supplier_quotation")
@ResponseBody
@Api("产品-->产品供应商管理")
public class ProductSupplierQuotationController {
    @Autowired
    private ProductService productService;

    /**
     * 修改产品供应商报价
     *
     * @return
     */
    @ApiOperation(value = "修改产品供应商")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Integer> updateSupplierQuotation(@ModelAttribute SupplierQuotationUpdateReqDto reqDto) throws Exception {

        Boolean isPass = productService.updatePermission(reqDto.getProductId(), DataObjectEnum.SUPPLIER.getCode());
        if (!isPass) {
            throw new BaseException(CodeConstant.CODE_1220016);
        }

        return HttpUtils.post(TenantUrl.UPDATE_PRODUCT_SUPPLIER_QUOTATION, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<Integer>>() {
        });
    }


    @ApiOperation(value = "根据产品id，获取供应商报价信息")
    @RequestMapping(value = "/get_by_product_id", method = RequestMethod.GET)
    public Result<List<ProductSupplierQuotationDetailDto>> getByProductId(@RequestParam Long productId) throws BaseException {
        return HttpUtils.get(TenantUrl.GET_PRODUCT_SUPPLIER_QUOTATION_BY_PRODUCT_ID, ArgsUtils.toIdMap(productId, "productId"), new BaseTypeReference<Result<List<ProductSupplierQuotationDetailDto>>>() {
        });
    }
}
