

package com.yundao.tenant.web.controller.project.index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.project.index.audithistory.AuditHistoryAuditResDto;
import com.yundao.tenant.web.dto.project.index.audithistory.AuditHistoryReqDto;
import com.yundao.tenant.web.dto.project.index.audithistory.AuditHistoryResDto;
import com.yundao.tenant.web.dto.workflow.AuditDetailResDTO;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月20日 下午4:27:50 
 * @author   欧阳利
 * @version   
 */
@RequestMapping("/assets/index/audit_history/")
@Controller
@ResponseBody
@Api("项目管理-->首页-->审批历史")
public class AuditHistoryController {
	
	@RequestMapping(value = "get_page", method = RequestMethod.GET)
	@ApiOperation(value = "审批历史列表")
	public Result<PaginationSupport<AuditHistoryResDto>> getAuditHistoryPage(@ModelAttribute AuditHistoryReqDto reqDto)throws BaseException{
		  Map<String,Object> params = ArgsUtils.toMap(reqDto);
		  Result<PaginationSupport<AuditHistoryResDto>> result =  HttpUtils.get(AmUrl.GET_INDEX_AUDIT_HISTORY_GET_PAGE, params, new BaseTypeReference<Result<PaginationSupport<AuditHistoryResDto>>>() {
          });
          return result;
	}
	
	@RequestMapping(value = "get_project_detail", method = RequestMethod.GET)
	@ApiOperation(value = "项目审批历史记录详情")
	public Result<List<AuditHistoryAuditResDto>> getAuditHistoryDeatil(@RequestParam  Long projectId)throws BaseException{
		 Map<String,Object> params = new HashMap<String,Object>();
		 params.put("projectId", projectId);
		 Result<List<AuditHistoryAuditResDto>> result =  HttpUtils.get(AmUrl.GET_INDEX_AUDIT_HISTORY_GET_PROJECT_DETAIL, params, new BaseTypeReference<Result<List<AuditHistoryAuditResDto>>>() {
         });
         return result;
	}
	
	@RequestMapping(value = "get_decision_detail", method = RequestMethod.GET)
	@ApiOperation(value = "轮次审批历史记录详情")
	public Result<List<AuditDetailResDTO>> getAuditHistoryDecisionDeatil(@RequestParam Long decisionId)throws BaseException{
		 Map<String,Object> params = new HashMap<String,Object>();
		 params.put("decisionId", decisionId);
		 Result<List<AuditDetailResDTO>> result =  HttpUtils.get(AmUrl.GET_INDEX_AUDIT_HISTORY_GET_DECISION_DETAIL, params, new BaseTypeReference<Result<List<AuditDetailResDTO>>>() {
         });
         return result;
	}
}

