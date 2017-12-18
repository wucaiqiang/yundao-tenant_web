package com.yundao.tenant.web.controller.product;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.bo.*;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.enums.bo.BusinessObjectEnum;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品要素控制器
 *
 * @author jan
 * @create 2017-07-04 PM4:12
 **/
@Controller
@RequestMapping("/product/element")
@Api("产品-->产品要素")
@ResponseBody
public class ProductElementController {


    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation(value = "获取产品要素分页数据")
    public Result<PaginationSupport<ObjectFieldPageResDto>> getPage(@ModelAttribute ObjectFieldPageReqDto
                                                                            dto) throws BaseException {
        dto.setBoCode(BusinessObjectEnum.PRODUCT.getCode());
        return HttpUtils.get(TenantUrl.GET_ELEMENT_PAGE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<ObjectFieldPageResDto>>>() {
        });
    }

    @RequestMapping(value = "/get_list", method = RequestMethod.GET)
    @ApiOperation(value = "获取产品要素列表")
    public Result<List<ObjectFieldPageResDto>> getList() throws BaseException {
        Map<String, Object> params = new HashMap<>();
        params.put("boCode", BusinessObjectEnum.PRODUCT.getCode());
        return HttpUtils.get(TenantUrl.GET_ELEMENT_LIST, params, new BaseTypeReference<Result<List<ObjectFieldPageResDto>>>() {
        });
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation(value = "获取产品要素")
    public Result<ObjectFieldDetailResDto> getPage(@RequestParam Long id) throws BaseException {
        return HttpUtils.get(TenantUrl.GET_ELEMENT, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<ObjectFieldDetailResDto>>() {
        });
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加产品元素")
    public Result<Long> add(@ModelAttribute ObjectFieldAddReqDto dto) throws BaseException {
        dto.setBoCode(BusinessObjectEnum.PRODUCT.getCode());
        return HttpUtils.post(TenantUrl.ADD_ELEMENT, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "修改产品元素")
    public Result<Long> update(@ModelAttribute ObjectFieldUpdateReqDto dto) throws BaseException {
        dto.setBoCode(BusinessObjectEnum.PRODUCT.getCode());
        return HttpUtils.post(TenantUrl.UPDATE_ELEMENT, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除产品元素，多个以逗号分隔")
    public Result<PermissionResultDto> delete(@RequestParam String ids) throws BaseException {
        Map<String, Object> params = new HashMap<>(2);
        params.put("ids", ids);
        params.put("boCode", BusinessObjectEnum.PRODUCT.getCode());
        return HttpUtils.post(TenantUrl.DELETE_ELEMENT, params, new BaseTypeReference<Result<PermissionResultDto>>() {
        });
    }

}
