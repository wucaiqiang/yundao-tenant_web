package com.yundao.tenant.web.controller.project.fund;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.RequestUtils;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.fund.*;
import com.yundao.tenant.web.dto.project.fund.FundAddReqDto;
import com.yundao.tenant.web.dto.project.fund.FundFieldDto;
import com.yundao.tenant.web.dto.project.fund.FundProjectResDto;
import com.yundao.tenant.web.dto.project.fund.FundRaiseUpdateReqDto;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.service.fund.FundService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基金控制器
 *
 * @author jan
 * @create 2017-11-17 13:57
 **/
@Controller
@RequestMapping("/assets/fund/")
@ResponseBody
@Api("项目管理---基金")
public class FundController {

    @Autowired
    private FundService fundService;

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation("获取基金分页数据")
    public Result<PaginationSupport<FundPageResDto>> getPage(@ModelAttribute FundPageReqDto dto) throws BaseException {
        return fundService.getPage(dto);
    }


    @ApiOperation(value = "通产品类型查询字段")
    @RequestMapping(value = "get_fields", method = RequestMethod.GET)
    public Result<FundFieldDto> getFields(@RequestParam Long typeId) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("typeId", typeId);
        Result<FundFieldDto> result = HttpUtils.get(AmUrl.GET_FIELDS_FUND, params, new BaseTypeReference<Result<FundFieldDto>>() {
        });
        return result;
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation("新增基金")
    public Result<Long> add(@ModelAttribute FundAddReqDto fundAddReqDto, HttpServletRequest request) throws Exception {
        // 检查
        Map<String, String> params = RequestUtils.getParameterMap(request);
        Map<String, Object> mapParmas = ArgsUtils.toMap(fundAddReqDto);
        for (String key : params.keySet()) {
            if (!mapParmas.containsKey(key)) {
                mapParmas.put(key, params.get(key));
            }
        }
        Result<Long> result = HttpUtils.post(AmUrl.ADD_FUND, mapParmas, new BaseTypeReference<Result<Long>>() {
        });
        return result;
    }


    @ApiOperation(value = "修改基金信息")
    @RequestMapping(value = "base/update", method = RequestMethod.POST)
    public Result<Integer> updateBaseInfo(@ModelAttribute FundBaseUpdateReqDto updateReqDto,
                                          HttpServletRequest request) throws Exception {
        Map<String, String> params = RequestUtils.getParameterMap(request);
        Map<String, Object> mapParmas = new HashMap<String, Object>();
        for (String key : params.keySet()) {
            if (!mapParmas.containsKey(key)) {
                mapParmas.put(key, params.get(key));
            }
        }
        Boolean isPass = fundService.updatePermission(updateReqDto.getId(), DataObjectEnum.FUND.getCode());
        if (!isPass) {
            throw new BaseException(CodeConstant.CODE_1220016);
        }

        Result<Integer> result = HttpUtils.post(AmUrl.UPDATE_FUND_BASE_INFO, mapParmas, new BaseTypeReference<Result<Integer>>() {
        });
        return result;
    }


    @ApiOperation(value = "修改发行状态")
    @RequestMapping(value = "/update/issued_status", method = RequestMethod.POST)
    public Result<Integer> updateIssuedStatus(@RequestParam Long id, @RequestParam Integer issuedStatus)
            throws Exception {
        Boolean isPass = fundService.updatePermission(id, DataObjectEnum.FUND.getCode());
        if (!isPass) {
            throw new BaseException(CodeConstant.CODE_1220016);
        }

        Map<String, Object> methodParams = new HashMap<String, Object>();
        methodParams.put("id", id);
        methodParams.put("issuedStatus", issuedStatus);
        Result<Integer> result = HttpUtils.post(AmUrl.UPDATE_FUND_ISSUED_STATUS, methodParams, new BaseTypeReference<Result<Integer>>() {
        });
        return result;
    }


    @ApiOperation(value = "修改基金募集信息")
    @RequestMapping(value = "raise/update", method = RequestMethod.POST)
    public Result<Integer> updateRaise(@ModelAttribute FundRaiseUpdateReqDto updateReqDto, HttpServletRequest request)
            throws Exception {
        Boolean isPass = fundService.updatePermission(updateReqDto.getId(), DataObjectEnum.FUND.getCode());
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
        Result<Integer> result = HttpUtils.post(AmUrl.UPDATE_FUND_RAISE, mapParmas, new BaseTypeReference<Result<Integer>>() {
        });
        return result;
    }


    @ApiOperation(value = "通过基金id查询基金详情", notes = "通过基金id查询基金详情")
    @RequestMapping(value = "get_detail_by_id", method = RequestMethod.GET)
    public Result<FundDataDetailDto> getFundDetailDto(@RequestParam Long id) throws Exception {
        Boolean isPass = fundService.readPermission(id, DataObjectEnum.FUND.getCode());
        if (!isPass) {
            throw new BaseException(CodeConstant.CODE_1220016);
        }

        return fundService.getFundDetailDto(id);
    }

    @ApiOperation(value = "获取基金下拉选项")
    @RequestMapping(value = "get_selection", method = RequestMethod.GET)
    public Result<List<FundSelectionDto>> getSelection(@ModelAttribute FundSelectReqDto dto) throws Exception {
        return fundService.getSelection(dto);
    }

    @RequestMapping(value = "/import_product", method = RequestMethod.POST)
    @ApiOperation(value = "基金导入到产品")
    public Result<Boolean> importProduct(@ModelAttribute FundIdReqDto dto) throws
            BaseException {
        return HttpUtils.post(AmUrl.IMPORT_FUND_TO_PRODUCT, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<Boolean>>() {
                });
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除基金")
    public Result<PermissionResultDto> delete(@ModelAttribute FundIdsReqDto dto) throws
            BaseException {
        return fundService.delete(dto);
    }

//	
//    @ApiOperation(value = "取消关注基金")
//    @RequestMapping(value = "/cancel_focus", method = RequestMethod.POST)
//    public Result<PermissionResultDto> cancelFocusProduct(@RequestParam String ids) throws Exception {
//        Map<String, Object> mapParmas = new HashMap<String, Object>();
//        mapParmas.put("ids", ids);
//        return HttpUtils.post(AmUrl.FUND_CANCEL_FOCUS, mapParmas, new BaseTypeReference<Result<PermissionResultDto>>() {
//        });
//    }
//
//    @ApiOperation(value = "关注基金")
//    @RequestMapping(value = "/focus", method = RequestMethod.POST)
//    public Result<PermissionResultDto> focusProduct(@RequestParam String ids) throws Exception {
//        Map<String, Object> mapParmas = new HashMap<String, Object>();
//        mapParmas.put("ids", ids);
//        return HttpUtils.post(AmUrl.FUND_FOCUS, mapParmas, new BaseTypeReference<Result<PermissionResultDto>>() {
//        });
//    }

    @ApiOperation(value = "获取基金募集管理信息")
    @RequestMapping(value = "/get_raise_project", method = RequestMethod.GET)
    public Result<FundProjectResDto> getRaiseProject(@RequestParam Long fundId) throws Exception {
        return HttpUtils.get(AmUrl.GET_FUND_PROJECT, ArgsUtils.toIdMap(fundId), new BaseTypeReference<Result<FundProjectResDto>>() {
        });
    }
}
