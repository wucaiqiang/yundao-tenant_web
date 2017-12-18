package com.yundao.tenant.web.controller.finance.knotcommission;

import com.yundao.core.code.Result;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.WorkflowAuditReqDto;
import com.yundao.tenant.web.dto.finance.knotcommission.*;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 结佣记录表
 *
 * @author jan
 * @create 2017-10-12 16:51
 **/
@RestController
@RequestMapping(value = "/knot/commission/")
@ResponseBody
@Api("结佣记录表")
public class KnotCommissionController {
    @RequestMapping(value = "get_list",method= RequestMethod.GET)
    @ApiOperation(value="查询结佣记录表")
    public Result<List<BaseKnotCommission>> getList(@ModelAttribute KnotCommissionListReqDto dto) throws Exception{
        Map<String, Object> params = ArgsUtils.toMap(dto);
        params.put("pageSize", Integer.MAX_VALUE);
        Result<PaginationSupport<BaseKnotCommission>> result = HttpUtils.get(TenantUrl.KNOTCOMMISSION_GET_PAGE, params, new BaseTypeReference<Result<PaginationSupport<BaseKnotCommission>>>() {
        });
        return Result.newSuccessResult(result.getResult().getDatas());
    }

    @RequestMapping(value = "get_page",method= RequestMethod.GET)
    @ApiOperation(value="分页查询报单记录表")
    public Result<PaginationSupport<DeclarationKnot>> getPage(@ModelAttribute KnotCommissionPageReqDto dto) throws Exception{
        Map<String, Object> params = ArgsUtils.toMap(dto);
        Result<PaginationSupport<DeclarationKnot>> result = HttpUtils.get(TenantUrl.KNOTCOMMISSION_GET_DECLARATION_PAGE, params, new BaseTypeReference<Result<PaginationSupport<DeclarationKnot>>>() {
        });
        return result;
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增结佣记录表", notes="根据KnotCommission对象创建结佣记录表")
    public Result<Integer> add(@ModelAttribute KnotCommissionReqDto reqDto) throws Exception{
        return HttpUtils.post(TenantUrl.KNOTCOMMISSION_ADD, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<Integer>>() {
        });
    }

    @RequestMapping(value = "get", method=RequestMethod.GET)
    @ApiOperation(value="通过报单ID获取结佣记录表详细信息")
    public Result<KnotCommissionResDto> get(@RequestParam Long declarationId) throws Exception{
        Map<String,Object> params = new HashMap<>();
        params.put("declarationId",declarationId);
        Result<KnotCommissionResDto> result = HttpUtils.get(TenantUrl.KNOTCOMMISSION_GET, params, new BaseTypeReference<Result<KnotCommissionResDto>>() {
        });
        return result;
    }

    @RequestMapping(value = "gets_audit", method=RequestMethod.GET)
    @ApiOperation(value="通过报单ID获取结佣记录表详细信息")
    public Result<PaginationSupport<DeclarationAuditKnot>> getsAudit(@ModelAttribute KnotCommissionAuditPageReqDto dto) throws Exception{
        return HttpUtils.get(TenantUrl.KNOTCOMMISSION_GETS_AUDIT, ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<DeclarationAuditKnot>>>() {
        });
    }

    @RequestMapping(value = "audit", method=RequestMethod.POST)
    @ApiOperation(value="审批")
    public Result<Integer> audit(@ModelAttribute WorkflowAuditReqDto dto) throws Exception{
        return HttpUtils.post(TenantUrl.KNOTCOMMISSION_AUDIT, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Integer>>() {
        });
    }
}
