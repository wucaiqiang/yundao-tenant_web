package com.yundao.tenant.web.controller.project.investment;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.common.PermissionUrlDto;
import com.yundao.tenant.web.dto.project.ProjectPageResDto;
import com.yundao.tenant.web.dto.project.investment.*;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 投资管理
 *
 * @author gjl
 * @create 2017-11-27 08:52
 **/
@Controller
@ResponseBody
@RequestMapping("/assets/investment")
@Api("投资管理")
public class InvestmentController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation("分页查询投资管理")
    private Result<PaginationSupport<InvestmentPageResDto>> getPage(@ModelAttribute InvestmentPageReqDto dto) throws BaseException {
        Integer permission = permissionService.getRead(DataObjectEnum.FUND.getCode()).getResult();
        PermissionUrlDto urlDto = new PermissionUrlDto();
        urlDto.setPersonalUrl(AmUrl.INVESTMENT_GET_PAGE_PERSONAL);
        urlDto.setDepartmentUrl(AmUrl.INVESTMENT_GET_PAGE_DEPARTMENT);
        urlDto.setPublicUrl(AmUrl.INVESTMENT_GET_PAGE_PUBLIC);
        String url = urlDto.getPermissionUrl(permission);
        // 没有对应的url，表示没有权限，直接返回
        if (BooleanUtils.isEmpty(url))
            return Result.newSuccessResult(new PaginationSupport<InvestmentPageResDto>());
        return HttpUtils.get(url, ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<InvestmentPageResDto>>>() {});
    }

    @RequestMapping(value = "/get_fund_page", method = RequestMethod.GET)
    @ApiOperation("分页查询投资管理")
    private Result<PaginationSupport<InvestmentFundPageResDto>> getFundPage(@ModelAttribute InvestmentFundPageReqDto dto) throws BaseException {
        return HttpUtils.get(AmUrl.INVESTMENT_GET_FUND_PAGE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<InvestmentFundPageResDto>>>() {});
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("投资管理 -- 添加")
    private Result<Long> add(@ModelAttribute InvestmentAddReqDto dto) throws BaseException {
        return HttpUtils.post(AmUrl.INVESTMENT_ADD, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {});
    }

    @RequestMapping(value = "/add_fund", method = RequestMethod.POST)
    @ApiOperation("产品中心 -- 添加")
    private Result<Long> addFund(@ModelAttribute InvestmentAddReqDto dto) throws BaseException {
        return HttpUtils.post(AmUrl.INVESTMENT_ADD, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {});
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation("更新投资管理")
    private Result<Integer> update(@ModelAttribute InvestmentUpdateReqDto dto) throws
            BaseException {
        return HttpUtils.post(AmUrl.INVESTMENT_UPDATE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Integer>>() {});
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation("删除投资管理")
    private Result<Integer> delete(@RequestParam Long id) throws BaseException {
        return HttpUtils.post(AmUrl.INVESTMENT_DELETE, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<Integer>>() {});
    }

}
