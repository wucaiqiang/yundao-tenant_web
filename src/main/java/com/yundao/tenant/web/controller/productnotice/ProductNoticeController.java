package com.yundao.tenant.web.controller.productnotice;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.threadlocal.ThreadLocalUtils;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DateUtils;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.BasePageDto;
import com.yundao.tenant.web.dto.common.DataAndPermissionDto;
import com.yundao.tenant.web.dto.common.DataPermissionDto;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.productnotice.*;
import com.yundao.tenant.web.dto.workflow.WorkFlowAuditRecordResDto;
import com.yundao.tenant.web.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.enums.product.notice.NoticeStatusEnum;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.service.fieldgroup.FieldGroupService;
import com.yundao.tenant.web.service.product.ProductNoticeService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品公告
 *
 * @author gjl
 * @create 2017-07-06 PM6:07
 **/
@RestController
@RequestMapping("/product/notice/")
@ResponseBody
@Api("产品公告")
public class ProductNoticeController {

    @Autowired
    private FieldGroupService fieldGroupService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private ProductNoticeService productNoticeService;

    private Integer SUB_STATUS = 2;
    private Integer CLEAR_STATUS = 5;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation(value = "新增产品公告", notes = "创建产品公告")
    public Result<Integer> add(@ModelAttribute ProductNoticeReqDto dto) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.post(TenantUrl.PRODUCT_NOTICE_ADD, params, new BaseTypeReference<Result<Integer>>() {
        });
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ApiOperation(value = "编辑产品公告", notes = "创建产品公告")
    public Result<Integer> update(@ModelAttribute ProductNoticeReqDto dto) throws BaseException {
        Boolean isPass = productNoticeService.updatePermission(dto.getId(), DataObjectEnum.NOTICE.getCode());
        if (!isPass) {
            throw new BaseException(CodeConstant.CODE_1220016);
        }
        Map<String, Object> params = ArgsUtils.toMap(dto);
        return HttpUtils.post(TenantUrl.PRODUCT_NOTICE_UPDATE, params, new BaseTypeReference<Result<Integer>>() {
        });
    }

    @RequestMapping(value = "flow", method = RequestMethod.POST)
    @ApiOperation(value = "流程流转", notes = "流程流转")
    public Result<Integer> flow(@RequestParam Long id, @RequestParam String status, @RequestParam(required = false) String reason) throws BaseException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("status", status);
        params.put("reason", reason);
        return HttpUtils.post(TenantUrl.PRODUCT_NOTICE_FLOW, params, new BaseTypeReference<Result<Integer>>() {
        });
    }

    @RequestMapping(value = "sub_flow", method = RequestMethod.POST)
    @ApiOperation(value = "申请发布或再次申请", notes = "申请发布或再次申请")
    public Result<Integer> subFlow(@RequestParam Long id) throws BaseException {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("status", SUB_STATUS);
        Boolean isPass = productNoticeService.updatePermission(id, DataObjectEnum.NOTICE.getCode());
        if (!isPass) {
            DataObjectPermissionEnum dataObjectPermissionEnum = productNoticeService.getDataObjectPermissionEnum();
            throw new BaseException(CodeConstant.CODE_1220016, dataObjectPermissionEnum.getNotCanPermission());
        }
        return HttpUtils.post(TenantUrl.PRODUCT_NOTICE_FLOW, params, new BaseTypeReference<Result<Integer>>() {
        });
    }

    @RequestMapping(value = "clear_flow", method = RequestMethod.POST)
    @ApiOperation(value = "取消申请", notes = "取消申请")
    public Result<Integer> clearFlow(@RequestParam Long id, @RequestParam String reason) throws BaseException {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("status", CLEAR_STATUS);
        params.put("reason", reason);
        Boolean isPass = productNoticeService.updatePermission(id, DataObjectEnum.NOTICE.getCode());
        if (!isPass) {
            DataObjectPermissionEnum dataObjectPermissionEnum = productNoticeService.getDataObjectPermissionEnum();
            throw new BaseException(CodeConstant.CODE_1220016, dataObjectPermissionEnum.getNotCanPermission());
        }
        //是否自己本人取消
        Result<ProductNoticeModel> modelResult = HttpUtils.get(TenantUrl.PRODUCT_NOTICE_GET, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<ProductNoticeModel>>() {
        });
        if (modelResult.getSuccess()) {
            HeaderUser user = (HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
            if (!user.getUserId().equals(modelResult.getResult().getApplyUserId())) {
                throw new BaseException(CodeConstant.CODE_1200120, "本人才允许取消操作");
            }
        }
        return HttpUtils.post(TenantUrl.PRODUCT_NOTICE_FLOW, params, new BaseTypeReference<Result<Integer>>() {
        });
    }

    @ApiOperation(value = "获取产品公告详情和关联关系表")
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Result<DataAndPermissionDto> get(@RequestParam long id) throws BaseException {
        DataAndPermissionDto<ProductNoticeModel> modelDataAndPermissionDto = new DataAndPermissionDto<>();
        Result<ProductNoticeModel> modelResult = HttpUtils.get(TenantUrl.PRODUCT_NOTICE_GET, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<ProductNoticeModel>>() {
        });
        modelDataAndPermissionDto.setData(modelResult.getResult());
        //获取权限
        Result<Boolean> perResult = permissionService.checkUpdate(DataObjectEnum.NOTICE.getCode(), modelResult.getResult().getCreateUserId());
        DataPermissionDto permissionDto = new DataPermissionDto();
        permissionDto.setEditPermission(perResult.getResult());
        modelDataAndPermissionDto.setPermission(permissionDto);
        return Result.newSuccessResult(modelDataAndPermissionDto);
    }

    @RequestMapping(value = "get_page", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询产品公告管理列表")
    public Result<PaginationSupport<ProductNoticeModel>> gets(@ModelAttribute ProductNoticePageReqDto pageReqDto) throws BaseException {
        Result<PaginationSupport<ProductNoticeModel>> result = HttpUtils.get(TenantUrl.PRODUCT_NOTICE_GETS, ArgsUtils.toMap(pageReqDto), new BaseTypeReference<Result<PaginationSupport<ProductNoticeModel>>>() {
        });

        if (result.getSuccess() && result.getResult() != null) {
            List<ProductNoticeModel> list = result.getResult().getDatas();
            if (!BooleanUtils.isEmpty(list)) {
                HeaderUser headerUser = (HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
                Long userId = headerUser.getUserId();
                for (ProductNoticeModel model : list) {
                    model.setApplyUser(userId.equals(model.getApplyUserId()));
                }
            }

        }
        productNoticeService.checkUpdatePermission(result);
        return result;
    }

    @RequestMapping(value = "get_productId", method = RequestMethod.GET)
    @ApiOperation(value = "通过产品ID分页查询公告列表")
    public Result<PaginationSupport<ProductNoticeModel>> getProductId(@RequestParam Long productId, @ModelAttribute BasePageDto basePageDto) throws BaseException {
        Map<String, Object> params = ArgsUtils.toMap(basePageDto);
        params.put("productId", productId);
        params.put("status", NoticeStatusEnum.STATUS_3.getStatus());
        params.put("orderColumn", "sendTime");
        return HttpUtils.get(TenantUrl.PRODUCT_NOTICE_GETS, params, new BaseTypeReference<Result<PaginationSupport<ProductNoticeModel>>>() {
        });
    }


    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除产品公告信息")
    public Result<PermissionResultDto> delete(@RequestParam String ids) throws BaseException {
        return productNoticeService.delete(ids);
    }

    @RequestMapping(value = "get_page_flow", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询产品公告审核列表")
    public Result<PaginationSupport<BaseProductNoticeExamine>> getsFlow(@ModelAttribute ProductNoticeExaminePageReqDto reqDto) throws Exception {
        if (reqDto.getCreateDateStart() != null) {
            reqDto.setCreateDateStart(DateUtils.parse(DateUtils.getDateBegin(reqDto.getCreateDateStart()), DateUtils.YY_MM_DD_HH_MM_SS));
        }
        if (reqDto.getCreateDateEnd() != null) {
            reqDto.setCreateDateEnd(DateUtils.parse(DateUtils.getDateEnd(reqDto.getCreateDateEnd()), DateUtils.YY_MM_DD_HH_MM_SS));
        }
        if (reqDto.getUpdateDateStart() != null) {
            reqDto.setUpdateDateStart(DateUtils.parse(DateUtils.getDateBegin(reqDto.getUpdateDateStart()), DateUtils.YY_MM_DD_HH_MM_SS));
        }
        if (reqDto.getUpdateDateEnd() != null) {
            reqDto.setUpdateDateEnd(DateUtils.parse(DateUtils.getDateEnd(reqDto.getUpdateDateEnd()), DateUtils.YY_MM_DD_HH_MM_SS));
        }

        return HttpUtils.get(TenantUrl.PRODUCT_NOTICE_EXAMINE_GETS, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<PaginationSupport<BaseProductNoticeExamine>>>() {
        });
    }


    @ApiOperation(value = "查询审核历史记录")
    @RequestMapping(value = "get_history_audit_detail", method = RequestMethod.GET)
    public Result<List<WorkFlowAuditRecordResDto>> getAuditDetail(@RequestParam Long noticeId) throws BaseException {
        return HttpUtils.get(TenantUrl.PRODUCT_NOTICE_AUDIT_HISTORY, ArgsUtils.toIdMap(noticeId, "noticeId"), new BaseTypeReference<Result<List<WorkFlowAuditRecordResDto>>>() {
        });
    }
}
