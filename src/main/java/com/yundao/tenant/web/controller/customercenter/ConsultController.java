package com.yundao.tenant.web.controller.customercenter;


import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.customercenter.ConsultProductReqDto;
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
 * C端客户预约
 *
 * @author jan
 * @create 2017-09-07 AM11:28
 **/
@Controller
@ResponseBody
@RequestMapping("/consult")
@Api("C端客户预约")
public class ConsultController {

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    @ApiOperation("预约产品")
    public Result<Long> addForProduct(@ModelAttribute ConsultProductReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.CONSULT_PRODUCT, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

}
