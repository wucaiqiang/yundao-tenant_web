

package com.yundao.tenant.web.controller.project.index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.project.index.AuditReqDto;
import com.yundao.tenant.web.dto.project.index.AuditResDto;
import com.yundao.tenant.web.dto.project.index.IndustryAmountLayoutDto;
import com.yundao.tenant.web.dto.project.index.ProjectCountDto;
import com.yundao.tenant.web.dto.project.index.ProjectCountResDto;
import com.yundao.tenant.web.dto.project.index.ReportDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Function:
 * Reason:
 * Date:     2017年11月20日 下午4:27:50
 *
 * @author 欧阳利
 */
@RequestMapping("/assets/index")
@Controller
@ResponseBody
@Api("项目管理-->首页")
public class IndexController {
	
	
    @RequestMapping(value = "/audit/todo", method = RequestMethod.GET)
    @ApiOperation("待我审批")
    public Result<PaginationSupport<AuditResDto>> getAuditPage(@ModelAttribute AuditReqDto reqDto) throws BaseException {
    	  Map<String,Object> params = ArgsUtils.toMap(reqDto);
          return HttpUtils.get(AmUrl.GET_INDEX_AUDIT_PAGE, params, new BaseTypeReference<Result<PaginationSupport<AuditResDto>>>() {
          });
    }

    /**
     * 包括项目漏斗、投资布局、投资关系，请在前置系统组成一个接口
     *
     * @throws BaseException
     */
    @RequestMapping(value = "/report", method = RequestMethod.GET)
    @ApiOperation("资产管理概况")
    public Result<ReportDto> reports() throws BaseException {
    	ReportDto dto = new ReportDto();
    	Map<String,Object> params = new HashMap<String,Object>();
    	Result<List<IndustryAmountLayoutDto>> resultIndustry = HttpUtils.get(AmUrl.GET_INDEX_REPORT_INVEST_LAYOUT, params, new BaseTypeReference<Result<List<IndustryAmountLayoutDto>>>() {
        });
    	dto.setIndustryLayout(resultIndustry.getResult());
    	
    	Result<ProjectCountDto> resultProject = HttpUtils.get(AmUrl.GET_INDEX_REPORT_PROJECT, params, new BaseTypeReference<Result<ProjectCountDto>>() {
        });
    	dto.setProjectFunnel(ProjectCountResDto.getProjectCountResDto(resultProject.getResult()));
        return Result.newSuccessResult(dto);
    }


}

