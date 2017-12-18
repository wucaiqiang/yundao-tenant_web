package com.yundao.tenant.web.controller.sys;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.sys.sale.SaleConfOpenseaReqDto;
import com.yundao.tenant.web.dto.sys.sale.SaleConfResDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统配置
 *
 * @author jan
 * @create 2017-11-04 10:24
 **/
@Controller
@ResponseBody
@RequestMapping("/sys/conf/")
@Api("系统配置")
public class SysConfController {

    @RequestMapping(value = "/sale/get", method = RequestMethod.GET)
    @ApiOperation("获取销售管理配置")
    public Result<SaleConfResDto> getSaleConf() throws BaseException {
        return HttpUtils.get(TenantUrl.GET_SYS_CONF_SALE, null, new BaseTypeReference<Result<SaleConfResDto>>() {
        });
    }

    @RequestMapping(value = "/sale/update", method = RequestMethod.POST)
    @ApiOperation("修改销售管理配置")
    public Result<Boolean> updateSaleConf(@ModelAttribute SaleConfOpenseaReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.UPDATE_SYS_CONF_SALE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Boolean>>
                () {
        });
    }

}
