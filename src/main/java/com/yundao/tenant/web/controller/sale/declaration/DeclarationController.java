package com.yundao.tenant.web.controller.sale.declaration;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.threadlocal.ThreadLocalUtils;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.common.DataPermissionDto;
import com.yundao.tenant.web.dto.permission.PermissionMultiCodeDto;
import com.yundao.tenant.web.dto.sale.declaration.*;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.service.sale.declaration.DeclarationService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by gjl on 2017/8/24.
 */
@Controller
@RequestMapping("/declaration")
@ResponseBody
@Api("销售管理-->报单")
public class DeclarationController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private DeclarationService declarationService;

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询我的报单")
    public Result<PaginationSupport<DeclarationModel>> getPage(@ModelAttribute DeclarationPageReqDto declarationPageReqDto) throws BaseException {

        Map<String, Object> params = ArgsUtils.toMap(declarationPageReqDto);
        Result<PaginationSupport<DeclarationModel>> result = HttpUtils.get(TenantUrl.DECLARATION_GET_PAGE, params, new BaseTypeReference<Result<PaginationSupport<DeclarationModel>>>() {
        });
        return result;
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ApiOperation(value = "获取报单详细信息")
    public Result<DeclarationDetailResDto> get(@RequestParam Long id) throws Exception {
        DeclarationDetailResDto resultData = new DeclarationDetailResDto();
        Result<DeclarationResDto> declarationResDtoResult = HttpUtils.get(TenantUrl.DECLARATION_GET, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<DeclarationResDto>>() {
        });
        resultData.setData(declarationResDtoResult.getResult());
        List<PermissionMultiCodeDto> reqDtos = new ArrayList<PermissionMultiCodeDto>(1);
        HeaderUser user = (HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
        reqDtos.add(new PermissionMultiCodeDto(DataObjectEnum.DECLARATION.getCode(), user.getUserId()));
        Result<List<DataPermissionDto>> peResult = permissionService.checkRead(reqDtos);
        if (peResult.getResult() != null && !peResult.getResult().isEmpty()) {
            resultData.setPermission(peResult.getResult().get(0));
        }
        return Result.newSuccessResult(resultData);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增报单")
    public Result<Integer> add(@ModelAttribute DeclarationReqDto declarationReqDto) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(declarationReqDto);
        return HttpUtils.post(TenantUrl.DECLARATION_ADD, params, new BaseTypeReference<Result<Integer>>() {
        });
    }

    @RequestMapping(value = "submit", method = RequestMethod.POST)
    @ApiOperation(value = "新增报单", notes = "根据Declaration对象创建报单")
    public Result<Long> submit(@RequestParam Long id)
            throws Exception {
        return HttpUtils.post(TenantUrl.DECLARATION_SUBMIT, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "validate", method = RequestMethod.POST)
    @ApiOperation(value = "验证报单")
    public Result<Long> validate(@RequestParam Long id)
            throws Exception {
        return HttpUtils.post(TenantUrl.DECLARATION_VALIDATE, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "/patch", method = RequestMethod.POST)
    @ApiOperation(value = "补入报单")
    public Result<Integer> patch(@ModelAttribute DeclarationPatchReqDto declarationReqDto) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(declarationReqDto);
        return HttpUtils.post(TenantUrl.DECLARATION_PATCH, params, new BaseTypeReference<Result<Integer>>() {
        });
    }
    @RequestMapping(value = "/pc_add", method = RequestMethod.POST)
    @ApiOperation(value = "新增保单")
    public Result<Integer> pcAdd(@ModelAttribute DeclarationReqDto declarationReqDto) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(declarationReqDto);
        return HttpUtils.post(TenantUrl.DECLARATION_ADD, params, new BaseTypeReference<Result<Integer>>() {
        });
    }

    @RequestMapping(value = "/resubmit", method = RequestMethod.POST)
    @ApiOperation(value = "重新提交")
    public Result<Long> resubmit(@ModelAttribute DeclarationApplyrReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.DECLARATION_RESUBMIT, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    @ApiOperation(value = "取消")
    public Result<Long> cancel(@ModelAttribute DeclarationApplyrReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.DECLARATION_CANCEL, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }
    
    @RequestMapping(value = "/apply_refund", method = RequestMethod.POST)
    @ApiOperation(value = "申请退款")
    public Result<Long> applyRefund(@ModelAttribute DeclarationApplyRefundReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.DECLARATION_APPLY_REFUND, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "/update_credentials", method = RequestMethod.POST)
    @ApiOperation(value = "修改身份资料")
    public Result<Long> updateCredentials(@ModelAttribute DeclarationUpdateCredentialsDto dto) throws BaseException {
        validateUpdatePermission(dto.getId());
        return HttpUtils.post(TenantUrl.DECLARATION_UPDATE_CREDENTIALS, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    private void validateUpdatePermission(Long id) throws BaseException {
        Result<DeclarationResDto> declarationResDtoResult = HttpUtils.get(TenantUrl.DECLARATION_GET, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<DeclarationResDto>>() {
        });
        if (declarationResDtoResult.getResult() == null) {
            throw new BaseException(CodeConstant.CODE_1220016);
        }
        Result<Boolean> permissionResult = permissionService.checkUpdate(DataObjectEnum.DECLARATION.getCode(), declarationResDtoResult.getResult().getCreateUserId());
        if (!permissionResult.getResult()) {
            throw new BaseException(CodeConstant.CODE_1220016);
        }
    }

    @RequestMapping(value = "/update_bank", method = RequestMethod.POST)
    @ApiOperation(value = "修改银行卡")
    public Result<Long> updateBank(@ModelAttribute DeclarationUpdateBankDto dto) throws BaseException {
        validateUpdatePermission(dto.getId());
        return HttpUtils.post(TenantUrl.DECLARATION_UPDATE_BANK, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }


    @RequestMapping(value = "/update_subscribe", method = RequestMethod.POST)
    @ApiOperation(value = "修改认购信息")
    public Result<Long> updateSubscribe(@ModelAttribute DeclarationUpdateSubscribeDto dto) throws BaseException {
        validateUpdatePermission(dto.getId());
        return HttpUtils.post(TenantUrl.DECLARATION_SUBSCRIBE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }


    @RequestMapping(value = "/update_compliance", method = RequestMethod.POST)
    @ApiOperation(value = "修改合规文件")
    public Result<Long> updateCompliance(@ModelAttribute DeclarationUpdateComplianceDto dto) throws BaseException {
        validateUpdatePermission(dto.getId());
        return HttpUtils.post(TenantUrl.DECLARATION_COMPLIANCE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "get_page_for_pro_detail", method = RequestMethod.GET)
    @ApiOperation(value = "获取产品详情页面分页数据")
    public Result<PaginationSupport<DeclarationForProDetailResDto>> getPageForProductDetail(Long productId) throws Exception {
        return declarationService.getPageForProductDetail(productId);
    }


}
