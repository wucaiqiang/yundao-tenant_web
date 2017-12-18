package com.yundao.tenant.web.controller.withdrawal;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.common.PermissionUrlDto;
import com.yundao.tenant.web.dto.withdrawal.*;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 退出管理
 *
 * @author gjl
 * @create 2017-11-27 08:52
 **/
@RestController
@RequestMapping("/assets/withdrawal")
@ResponseBody
@Api("退出管理")
public class WithdrawalController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation("分页查询退出管理")
    private Result<PaginationSupport<WithdrawalPageResDto>> getPage(@ModelAttribute WithdrawalPageReqDto dto) throws BaseException {

        Integer permission = permissionService.getRead(DataObjectEnum.FUND.getCode()).getResult();
        PermissionUrlDto urlDto = new PermissionUrlDto();
        urlDto.setPersonalUrl(AmUrl.WITHDRAWAL_GET_PAGE_PERSONAL);
        urlDto.setDepartmentUrl(AmUrl.WITHDRAWAL_GET_PAGE_DEPARTMENT);
        urlDto.setPublicUrl(AmUrl.WITHDRAWAL_GET_PAGE_PUBLIC);
        String url = urlDto.getPermissionUrl(permission);

        // 没有对应的url，表示没有权限，直接返回
        if (BooleanUtils.isEmpty(url))
            return Result.newSuccessResult(new PaginationSupport<WithdrawalPageResDto>());

        return HttpUtils.get(url, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<PaginationSupport<WithdrawalPageResDto>>>() {
                });
    }

    @RequestMapping(value = "/get_fund_page", method = RequestMethod.GET)
    @ApiOperation("分页查询退出管理")
    private Result<PaginationSupport<WithdrawalFundPageResDto>> getFundPage(@ModelAttribute WithdrawalFundPageReqDto dto) throws BaseException {
        return HttpUtils.get(AmUrl.WITHDRAWAL_GET_FUND_PAGE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<WithdrawalFundPageResDto>>>() {
        });
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("退出管理 -- 添加")
    private Result<Long> add(@ModelAttribute WithdrawalAddReqDto dto) throws BaseException {
        return HttpUtils.post(AmUrl.WITHDRAWAL_ADD, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "/add_fund", method = RequestMethod.POST)
    @ApiOperation("基金中退出管理 -- 添加")
    private Result<Long> addFund(@ModelAttribute WithdrawalAddReqDto dto) throws BaseException {
        return HttpUtils.post(AmUrl.WITHDRAWAL_ADD, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation("更新退出管理")
    private Result<Integer> update(@ModelAttribute WithdrawalUpdateReqDto dto) throws
            BaseException {
        return HttpUtils.post(AmUrl.WITHDRAWAL_UPDATE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Integer>>() {
        });
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation("删除退出管理")
    private Result<Integer> delete(@RequestParam Long id) throws BaseException {
        return HttpUtils.post(AmUrl.WITHDRAWAL_DELETE, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<Integer>>() {
        });
    }

}
