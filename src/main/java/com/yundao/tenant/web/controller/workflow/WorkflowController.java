
package com.yundao.tenant.web.controller.workflow;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.workflow.AuditDetailResDTO;
import com.yundao.tenant.web.dto.workflow.WorkFlowRecordReqDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Function: Reason: Date: 2017年9月9日 下午3:35:34
 * 
 * @author wucq
 * @version
 */
@RestController
@RequestMapping(value = "/workflow/")
@ResponseBody
@Api("流程相关接口")
public class WorkflowController {
	
	
	@RequestMapping(value = "get_audit_record", method = RequestMethod.GET)
	@ApiOperation(value = "获取流程相关历史记录")
	public Result<List<AuditDetailResDTO>> getAuditRecord(@ModelAttribute WorkFlowRecordReqDto reqDto) throws BaseException {

        return HttpUtils.get(TenantUrl.WORKFLOW_GET_AUDIT_RECORD,  ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<List<AuditDetailResDTO>>>() {});

	}
}
