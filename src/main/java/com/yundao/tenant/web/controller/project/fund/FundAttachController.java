package com.yundao.tenant.web.controller.project.fund;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.project.fund.attach.FundAttachAddReqDto;
import com.yundao.tenant.web.dto.project.fund.attach.FundAttachListReqDto;
import com.yundao.tenant.web.dto.project.fund.attach.FundAttachListResDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * 基金附件管理
 * 
 * @author 欧阳利
 * 2017年7月11日
 */
@RestController
@RequestMapping("/assets//fund/attach")
@ResponseBody
@Api("项目管理---基金-->附件管理")
public class FundAttachController {
	private static Log log = LogFactory.getLog(FundAttachController.class);

	
    @ApiOperation(value = "添加基金附件")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Long> add(@ModelAttribute FundAttachAddReqDto reqDto)throws Exception{
   	    Map<String,Object> params = ArgsUtils.toMap(reqDto);
		Result<Long> result =  HttpUtils.post(AmUrl.ADD_FUND_ATTACH, params, new BaseTypeReference<Result<Long>>() {
        });
        return result;
    }
    
    @ApiOperation(value = "删除基金附件")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Integer> delete(@RequestParam  Long id)throws Exception{
    	log.info("删除基金附件Id:",id);
    	 Map<String,Object> params = ArgsUtils.toIdMap(id);
 		 Result<Integer> result =  HttpUtils.post(AmUrl.DELETE_FUND_ATTACH, params, new BaseTypeReference<Result<Integer>>() {
         });
         return result;
    }
    
    @ApiOperation(value = "分页基金附件")
    @RequestMapping(value = "/gets", method = RequestMethod.GET)
    public Result<PaginationSupport<FundAttachListResDto>> gets(@ModelAttribute FundAttachListReqDto reqDto)throws Exception{
    	log.info("附件基金附件:",reqDto);
    	 Map<String,Object> params = ArgsUtils.toMap(reqDto);
 		 Result<PaginationSupport<FundAttachListResDto>> result =  HttpUtils.get(AmUrl.GETS_FUND_ATTACH, params, new BaseTypeReference<Result<PaginationSupport<FundAttachListResDto>>>() {
         });
         return result;
    }
    
    
    @ApiOperation(value = "分页基金附件")
    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public Result<List<FundAttachListResDto>> getAll(@RequestParam Long fundId)throws Exception{
    	log.info("附件基金附件:",fundId);
   	    Map<String,Object> params = ArgsUtils.toIdMap(fundId);
		 Result<List<FundAttachListResDto>> result =  HttpUtils.get(AmUrl.GET_ALL_FUND_ATTACH, params, new BaseTypeReference<Result<List<FundAttachListResDto>>>() {
        });
        return result;
    }
    
}
