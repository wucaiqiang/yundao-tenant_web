package com.yundao.tenant.web.controller.productnotice;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.productnotice.BaseProductNoticeType;
import com.yundao.tenant.web.dto.productnotice.ProductNoticeTypeReqDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 业务对象字段分组
 *
 * @author gjl
 * @create 2017-07-06 PM6:07
 **/
@RestController
@RequestMapping("/product/noticetype/")
@ResponseBody
@Api("产品公告类型")
public class ProductNoticeTypeController {


    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增产品公告类型")
    public Result<Long> add(@ModelAttribute ProductNoticeTypeReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.PRODUCT_NOTICE_TYPE_ADD, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "delete", method=RequestMethod.POST)
    @ApiOperation(value="删除产品公告类型")
    public Result<Integer> delete(@RequestParam String id) throws BaseException {
        return HttpUtils.post(TenantUrl.PRODUCT_NOTICE_TYPE_DELETE, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<Integer>>() {
        });
    }

    @RequestMapping(value = "get_all", method=RequestMethod.GET)
    @ApiOperation(value="获取所有的产品公告类型")
    public Result<List<BaseProductNoticeType>> getAll() throws BaseException {
        return HttpUtils.get(TenantUrl.PRODUCT_NOTICE_TYPE_GET_ALL, null, new BaseTypeReference<Result<List<BaseProductNoticeType>>>() {
        });
    }
}