

package com.yundao.tenant.web.controller.project.fund;

import java.util.HashMap;
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
import com.yundao.tenant.web.dto.project.fund.team.TeamAddReqDto;
import com.yundao.tenant.web.dto.project.fund.team.TeamPageReqDto;
import com.yundao.tenant.web.dto.project.fund.team.TeamPageResDto;
import com.yundao.tenant.web.dto.project.fund.team.TeamUpdateReqDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月27日 上午11:43:53 
 * @author   欧阳利
 * @version   
 */
@Controller
@RequestMapping("/assets/fund/team")
@ResponseBody
@Api("项目管理--基金 -->团队")
public class FundTeamController {
	
	    
	    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
	    @ApiOperation("获取分页 ")
	    public Result<PaginationSupport<TeamPageResDto>> getPage(@ModelAttribute TeamPageReqDto dto) throws
	            BaseException {
	    	 Map<String,Object> params = ArgsUtils.toMap(dto);
			 Result<PaginationSupport<TeamPageResDto>> result =  HttpUtils.get(AmUrl.GETS_FUND_TEAM, params, new BaseTypeReference<Result<PaginationSupport<TeamPageResDto>>>() {
	         });
	         return result;
	    }
	    
	    
	    @RequestMapping(value = "/add", method = RequestMethod.POST)
	    @ApiOperation("添加")
	    public Result<Long> add( @ModelAttribute TeamAddReqDto dto) throws BaseException {
	    	 Map<String,Object> params = ArgsUtils.toMap(dto);
			 Result<Long> result =  HttpUtils.post(AmUrl.ADD_FUND_TEAM, params, new BaseTypeReference<Result<Long>>() {
	         });
	         return result;
	    }
	    
	    @RequestMapping(value = "/update", method = RequestMethod.POST)
	    @ApiOperation("修改")
	    public Result<Long> add( @ModelAttribute TeamUpdateReqDto dto) throws BaseException {
	    	 Map<String,Object> params = ArgsUtils.toMap(dto);
			 Result<Long> result =  HttpUtils.post(AmUrl.UPDATE_FUND_TEAM, params, new BaseTypeReference<Result<Long>>() {
	         });
	         return result;
	    }
	    
	    
	    
	    @RequestMapping(value = "/delete", method = RequestMethod.POST)
	    @ApiOperation("删除")
	    public Result<Integer> delete(@RequestParam String ids) throws BaseException {
	    	Map<String,Object> params = new HashMap<String,Object>();
	    	params.put("ids", ids);
			 Result<Integer> result =  HttpUtils.post(AmUrl.DELETE_FUND_TEAM, params, new BaseTypeReference<Result<Integer>>() {
	         });
	         return result;
	    }
}

