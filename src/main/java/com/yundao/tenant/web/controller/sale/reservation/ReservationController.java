package com.yundao.tenant.web.controller.sale.reservation;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
import com.yundao.tenant.web.dto.sale.reservation.BaseReservationDto;
import com.yundao.tenant.web.dto.sale.reservation.MyReservationListReqDto;
import com.yundao.tenant.web.dto.sale.reservation.MyReservationListResDto;
import com.yundao.tenant.web.dto.sale.reservation.ReservationAddReqDto;
import com.yundao.tenant.web.dto.sale.reservation.ReservationCancelReqDto;
import com.yundao.tenant.web.dto.sale.reservation.ReservationDetailResDto;
import com.yundao.tenant.web.dto.sale.reservation.ReservationUpdateReqDto;
import com.yundao.tenant.web.dto.sale.reservation.SubmitDeclarationReqDto;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 预约
 *
 * @author jan
 * @create 2017-08-23 PM6:18
 **/
@Controller
@RequestMapping("/reservation")
@ResponseBody
@Api("销售管理-->预约")
public class ReservationController {
	  @Autowired
	  private PermissionService permissionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("添加预约")
    public Result<Long> add(@ModelAttribute ReservationAddReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.ADD_RESERVATION, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @RequestMapping(value = "/submit_declaration", method = RequestMethod.POST)
    @ApiOperation(value = "提交报单")
    public Result<Integer> submitDeclaration(@ModelAttribute SubmitDeclarationReqDto reqDto) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(reqDto);
        return HttpUtils.post(TenantUrl.SUBMIT_DECLARATION, params, new BaseTypeReference<Result<Integer>>() {
        });
    }

    @RequestMapping(value = "/gets/my", method = RequestMethod.GET)
    @ApiOperation(value = "获取我的预约列表")
    public Result<PaginationSupport<MyReservationListResDto>> getMyReservations(@ModelAttribute MyReservationListReqDto reqDto) throws BaseException {
        return HttpUtils.get(TenantUrl.GETS_MY_RESERVATION, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<PaginationSupport<MyReservationListResDto>>>() {
        });
    }

    @RequestMapping(value = "/gets/my_select", method = RequestMethod.GET)
    @ApiOperation(value = "获取我的预约选择列表")
    public Result<List<MyReservationListResDto>> getMyReservations(@RequestParam(required = false) Long productId) throws BaseException {
        Map<String,Object> params = new HashMap<>();
        params.put("productId",productId);
        params.put("statuss",2);
        params.put("isRemoveDiscard",1);
        params.put("isRemoveDeclaration",1);
        params.put("pageSize",Integer.MAX_VALUE);
        Result<PaginationSupport<MyReservationListResDto>> result = HttpUtils.get(TenantUrl.GETS_MY_RESERVATION, params, new BaseTypeReference<Result<PaginationSupport<MyReservationListResDto>>>() {});
        return Result.newSuccessResult(result.getResult().getDatas());
    }

    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation("编辑预约")
    public Result<Long> update(@ModelAttribute ReservationUpdateReqDto dto) throws BaseException {
    	// 检查是否有权限
    	validateUpdatePermission(dto.getId());
    	return HttpUtils.post(TenantUrl.UPDATE_RESERVATION, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
         });
    }
    
    private void validateUpdatePermission(Long id) throws BaseException {
        Result<BaseReservationDto> reservationResDtoResult = HttpUtils.get(TenantUrl.GET_RESERVATION, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<BaseReservationDto>>() {
        });
        if (reservationResDtoResult.getResult() == null) {
            throw new BaseException(CodeConstant.CODE_1220016);
        }
        Result<Boolean> permissionResult = permissionService.checkUpdate(DataObjectEnum.RESERVATION.getCode(), reservationResDtoResult.getResult().getUserId());
        if (!permissionResult.getResult()) {
            throw new BaseException(CodeConstant.CODE_1220016);
        }
    }
    
    
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation("查询单个预约详情")
    public Result<ReservationDetailResDto> get(@RequestParam Long id) throws BaseException {
         Result<BaseReservationDto> reservationResDtoResult =  HttpUtils.get(TenantUrl.GET_RESERVATION, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<BaseReservationDto>>() {
         });
         ReservationDetailResDto resultData = new ReservationDetailResDto();
         resultData.setData(reservationResDtoResult.getResult());
         
         List<PermissionMultiCodeDto> reqDtos = new ArrayList<PermissionMultiCodeDto>(1);
         HeaderUser user = (HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
         reqDtos.add(new PermissionMultiCodeDto(DataObjectEnum.RESERVATION.getCode(), user.getUserId()));
         Result<List<DataPermissionDto>> peResult = permissionService.checkRead(reqDtos);
         if (peResult.getResult() != null && !peResult.getResult().isEmpty()) {
             resultData.setPermission(peResult.getResult().get(0));
         }
         return Result.newSuccessResult(resultData);
    }
    
    
    @RequestMapping(value = "/again_commit", method = RequestMethod.POST)
    @ApiOperation("重新提交")
    public Result<Long> againCommit(@RequestParam Long id) throws BaseException {
    	 return HttpUtils.post(TenantUrl.AGAIN_COMMIT_RESERVATION, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<Long>>() {
         });
    }
    
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    @ApiOperation("取消预约")
    public Result<Long> cancel(@ModelAttribute ReservationCancelReqDto dto) throws BaseException {
    	 return HttpUtils.post(TenantUrl.CANCEL_RESERVATION, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
         });
    }
    
    

    
}
