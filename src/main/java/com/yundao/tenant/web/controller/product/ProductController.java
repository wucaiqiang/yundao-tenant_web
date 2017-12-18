package com.yundao.tenant.web.controller.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.RequestUtils;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.field.FiledSelectDto;
import com.yundao.tenant.web.dto.product.ProductBaseUpdateReqDto;
import com.yundao.tenant.web.dto.product.ProductManagerListReqDto;
import com.yundao.tenant.web.dto.product.ProductManagerListResDto;
import com.yundao.tenant.web.dto.product.ProductSaleUpdateReqDto;
import com.yundao.tenant.web.dto.product.ProductSelectOptionDto;
import com.yundao.tenant.web.dto.product.ProductSelectionForDeclaration;
import com.yundao.tenant.web.dto.product.ProductSelectionForReceiptPlanDto;
import com.yundao.tenant.web.dto.product.UpdateProductStatusDto;
import com.yundao.tenant.web.dto.product.add.ProductAddReqDto;
import com.yundao.tenant.web.dto.product.add.ProductFieldDto;
import com.yundao.tenant.web.dto.product.detail.ProductDataDetailDto;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.service.product.ProductService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * 产品基本信息管理
 *
 * @author 欧阳利
 *         2017年7月5日
 */
@RestController
@RequestMapping("/product")
@ResponseBody
@Api("产品-->产品管理")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 通产品类型查询字段
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "通产品类型查询字段")
    @RequestMapping(value = "/get_fields", method = RequestMethod.GET)
    public Result<ProductFieldDto> getFields(@RequestParam Long typeId) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("typeId", typeId);
        return HttpUtils.get(TenantUrl.PRODUCT_GET_FIELD, map, new BaseTypeReference<Result<ProductFieldDto>>() {
        });
    }


    /**
     * 获取产品管理拉下选择的查询条件
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "修改产品销售信息")
    @RequestMapping(value = "/get_manager_List_select_value", method = RequestMethod.GET)
    public Result<List<FiledSelectDto>> getProductManagetrListSelectValue() throws Exception {
        return HttpUtils.get(TenantUrl.PRODUCT_GET_MANAGER_LIST_SELECT_VALUE, null, new BaseTypeReference<Result<List<FiledSelectDto>>>() {
        });
    }

    /**
     * 分页产品产品管理列表
     *
     * @param reqDto
     * @return
     * @throws BaseException
     */
    @RequestMapping(value = "/get_manager_List", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询在职用户列表", notes = "分页查询产品管理列表")
    public Result<PaginationSupport<ProductManagerListResDto>> getManagerList(@ModelAttribute ProductManagerListReqDto reqDto) throws BaseException {
        return productService.getManagerList(reqDto);
    }


    /**
     * 添加产品
     *
     * @param productAddReqDto
     * @param request
     * @return
     * @throws BaseException
     * @throws Exception
     */
    @ApiOperation(value = "添加产品信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Long> add(@ModelAttribute ProductAddReqDto productAddReqDto, HttpServletRequest request) throws BaseException, Exception {
        // 检查
        Map<String, String> params = RequestUtils.getParameterMap(request);
        Map<String, Object> mapParmas = ArgsUtils.toMap(productAddReqDto);
        for (String key : params.keySet()) {
            if (!mapParmas.containsKey(key)) {
                mapParmas.put(key, params.get(key));
            }
        }
        // 添加产品
        return HttpUtils.post(TenantUrl.PRODUCT_ADD, mapParmas, new BaseTypeReference<Result<Long>>() {
        });
    }


    /**
     * 修改产品基本信息
     *
     * @return
     */
    @ApiOperation(value = "修改产品基本信息")
    @RequestMapping(value = "/base/update", method = RequestMethod.POST)
    public Result<Integer> updateBaseInfo(@ModelAttribute ProductBaseUpdateReqDto updateReqDto, HttpServletRequest request) throws Exception {
        Map<String, String> params = RequestUtils.getParameterMap(request);
        Map<String, Object> mapParmas = new HashMap<String, Object>();
        for (String key : params.keySet()) {
            if (!mapParmas.containsKey(key)) {
                mapParmas.put(key, params.get(key));
            }
        }
        Boolean isPass = productService.updatePermission(updateReqDto.getId(), DataObjectEnum.PRODUCT.getCode());
        if (!isPass) {
            throw new BaseException(CodeConstant.CODE_1220016);
        }
        return productService.update(updateReqDto, mapParmas);
    }

    /**
     * 修改产品销售信息
     *
     * @return
     */
    @ApiOperation(value = "修改产品销售信息")
    @RequestMapping(value = "/sale/update", method = RequestMethod.POST)
    public Result<Integer> updateSale(@ModelAttribute ProductSaleUpdateReqDto updateReqDto, HttpServletRequest request) throws Exception {
        Boolean isPass = productService.updatePermission(updateReqDto.getId(), DataObjectEnum.PRODUCT.getCode());
        if (!isPass) {
            throw new BaseException(CodeConstant.CODE_1220016);
        }
        Map<String, String> params = RequestUtils.getParameterMap(request);
        Map<String, Object> mapParmas = new HashMap<String, Object>();
        for (String key : params.keySet()) {
            if (!mapParmas.containsKey(key)) {
                mapParmas.put(key, params.get(key));
            }
        }
        // 修改产品基本信息
        return HttpUtils.post(TenantUrl.UPDATE_PRODUCT_SALE, mapParmas, new BaseTypeReference<Result<Integer>>() {
        });
    }


    /**
     * 通过产品名称查询产品下拉选择列表(默认显示10条)
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/get_select_option_list", method = RequestMethod.GET)
    @ApiOperation(value = "获取产品下拉选择列表(默认显示10条)", notes = "分页查询产品管理列表")
    public Result<List<ProductSelectOptionDto>> getProductSelectOPtionDtos(@RequestParam String name) throws BaseException {
        Map<String, Object> mapParmas = new HashMap<String, Object>();
        mapParmas.put("name", name);
        return HttpUtils.get(TenantUrl.PRODUCT_GET_SELECT_OPTION_LIST, mapParmas, new BaseTypeReference<Result<List<ProductSelectOptionDto>>>() {
        });
    }

    /**
     * 添加回款计划，产品下拉选项(默认显示20条)
     */
    @RequestMapping(value = "/get_select_option_for_receipt", method = RequestMethod.GET)
    @ApiOperation(value = "添加回款计划，产品下拉选项(默认显示20条)", notes = "分页查询产品管理列表")
    public Result<List<ProductSelectionForReceiptPlanDto>> getSelectOptionForReceipt(String name) throws BaseException {
        Map<String, Object> mapParmas = new HashMap<String, Object>();
        mapParmas.put("name", name);
        return HttpUtils.get(TenantUrl.PRODUCT_GET_SELECT_OPTION_FOR_RECEIPT_PLAN, mapParmas, new BaseTypeReference<Result<List<ProductSelectionForReceiptPlanDto>>>() {
        });
    }


    /**
     * 获取正在销售的产品(默认显示10条)
     */
    @RequestMapping(value = "/get_select_option_selling", method = RequestMethod.GET)
    @ApiOperation(value = "获取正在销售的产品(默认显示10条)")
    public Result<List<ProductSelectOptionDto>> getProductSelectSelling(@RequestParam(required = false) String name) throws
            BaseException {
        Map<String, Object> mapParmas = new HashMap<String, Object>(1);
        mapParmas.put("name", name);
        return HttpUtils.get(TenantUrl.PRODUCT_GET_SELECT_OPTION_SELLING_LIST, mapParmas, new BaseTypeReference<Result<List<ProductSelectOptionDto>>>() {
        });
    }


    /**
     * 通过产品类型获取产品下拉选择列表(默认显示10条)
     *
     * @return
     */
    @RequestMapping(value = "/get_select_option_list_by_typeId", method = RequestMethod.GET)
    @ApiOperation(value = "获取产品下拉选择列表(默认显示10条)", notes = "分页查询产品管理列表")
    public Result<List<ProductSelectOptionDto>> getProductSelectOPtionDtos(@RequestParam Long typeId, @RequestParam Integer count) throws BaseException {
        Map<String, Object> mapParmas = new HashMap<String, Object>();
        mapParmas.put("typeId", typeId);
        mapParmas.put("count", count);
        return HttpUtils.get(TenantUrl.PRODUCT_GET_SELECT_OPTION_LIST_BY_TYPEID, mapParmas, new BaseTypeReference<Result<List<ProductSelectOptionDto>>>() {
        });
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "根据多个id获取")
    public Result<PermissionResultDto> delete(@RequestParam String ids) throws BaseException {
        if (BooleanUtils.isEmpty(ids))
            throw new BaseException(CodeConstant.CODE_1200000);
        return productService.delete(ids);
    }


    @ApiOperation(value = "通过产品id查询产品详情", notes = "通过产品id查询产品详情")
    @RequestMapping(value = "/get_detail_by_id", method = RequestMethod.GET)
    public Result<ProductDataDetailDto> getProductDetailDto(@RequestParam Long id) throws Exception {
        return productService.getProductDetailDto(id);
    }


    /**
     * 修改产品状态
     *
     * @param productId
     * @param productManagerAction
     * @return
     */
    @ApiOperation(value = "修改产品状态", notes = "修改产品状态")
    @RequestMapping(value = "/update_status", method = RequestMethod.POST)
    public Result<Integer> updateProductStatus(@ModelAttribute UpdateProductStatusDto dto) throws Exception {
        // 重新提交或者取消申请不需要校验数据权限
        //CANCEL_APPLY_ON_LINE(2,"取消申请上线"),
        //AGAIN_APPLY_ON_LINE(4,"重置申请上线"),
        if (dto.getProductManagerAction() != 2 && dto.getProductManagerAction() != 4) {
            Boolean isPass = productService.updatePermission(dto.getId(), DataObjectEnum.PRODUCT.getCode());
            if (!isPass) {
                throw new BaseException(CodeConstant.CODE_1220016);
            }
        }

        Map<String, Object> mapParmas = new HashMap<String, Object>();
        mapParmas.put("productId", dto.getId());
        mapParmas.put("productManagerAction", dto.getProductManagerAction());
        mapParmas.put("declaractionModel", dto.getDeclaractionModel());
        mapParmas.put("reason", dto.getReason());
        return HttpUtils.post(TenantUrl.UPDATE_PRODUCT_STATUS, mapParmas, new BaseTypeReference<Result<Integer>>() {
        });
    }


    @ApiOperation(value = "用户取消关注产品")
    @RequestMapping(value = "/cancel_focus", method = RequestMethod.POST)
    public Result<PermissionResultDto> cancelFocusProduct(@RequestParam String ids) throws Exception {
        Map<String, Object> mapParmas = new HashMap<String, Object>();
        mapParmas.put("ids", ids);
        return HttpUtils.post(TenantUrl.PRODUCT_CANCEL_FOCUS, mapParmas, new BaseTypeReference<Result<PermissionResultDto>>() {
        });
    }

    @ApiOperation(value = "用户关注产品")
    @RequestMapping(value = "/focus", method = RequestMethod.POST)
    public Result<PermissionResultDto> focusProduct(@RequestParam String ids) throws Exception {
        Map<String, Object> mapParmas = new HashMap<String, Object>();
        mapParmas.put("ids", ids);
        return HttpUtils.post(TenantUrl.PRODUCT_FOCUS, mapParmas, new BaseTypeReference<Result<PermissionResultDto>>() {
        });
    }
    
    @RequestMapping(value = "/get_select_option_for_declaration", method = RequestMethod.GET)
    @ApiOperation(value = "获取产品下拉选择列表forDeclaration(默认显示20条)", notes = "分页查询产品管理列表")
    public Result<List<ProductSelectionForDeclaration>> getProductSelectForDeclaration(@RequestParam(required = false) String name, Integer count) throws
            BaseException {
    	if(count == null){
    		count = 20;
    	}
    	Map<String, Object> mapParmas = new HashMap<String, Object>();
        mapParmas.put("name", name);
        mapParmas.put("count", count);
        return HttpUtils.get(TenantUrl.PRODUCT_GET_SELECT_OPTION_FOR_DECLARATION, mapParmas, new BaseTypeReference<Result<List<ProductSelectionForDeclaration>>>() {
        });
    }
}
