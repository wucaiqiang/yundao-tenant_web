

package com.yundao.tenant.web.controller.cms.product.recommend;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.cms.product.recommend.RecommendAddReqDto;
import com.yundao.tenant.web.dto.cms.product.recommend.RecommendDetailDto;
import com.yundao.tenant.web.dto.cms.product.recommend.RecommendListReqDto;
import com.yundao.tenant.web.dto.cms.product.recommend.RecommendListResDto;
import com.yundao.tenant.web.dto.cms.product.recommend.RecommendUpdateReqDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月18日 下午3:59:08 
 * @author   欧阳利
 * @version   
 */
@RestController
@RequestMapping("/cms/product/recommend")
@ResponseBody
@Api("内容配置-->产品推荐配置")
public class RecommendController {
	
	
	@ApiOperation(value = "添加产品附件")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Long> add(@ModelAttribute RecommendAddReqDto reqDto)throws BaseException{
		return HttpUtils.post(TenantUrl.SCM_PRODUCT_RECOMMEND_ADD, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<Long>>
        () {});
    }
	
	
	@ApiOperation(value = "列表查询")
	@RequestMapping(value = "/get_page", method = RequestMethod.GET)
    public Result<PaginationSupport<RecommendListResDto>> getPage(@ModelAttribute RecommendListReqDto reqDto)throws BaseException{
		return HttpUtils.get(TenantUrl.SCM_PRODUCT_RECOMMEND_GET_PAGE,  ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<PaginationSupport<RecommendListResDto>>>
        () {});
    }
	
	@ApiOperation(value = "删除配置")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Integer> delete(@RequestParam String ids)throws BaseException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", ids);
		return HttpUtils.post(TenantUrl.SCM_PRODUCT_RECOMMEND_DELETE, map, new BaseTypeReference<Result<Integer>>
        () {});
    }
	
	@ApiOperation(value = "编辑推荐配置")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Integer> update(@ModelAttribute RecommendUpdateReqDto reqDto)throws BaseException{
		return HttpUtils.post(TenantUrl.SCM_PRODUCT_RECOMMEND_UPDATE, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<Integer>>
        () {});
    }
	
	@ApiOperation(value = "详情")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result<RecommendDetailDto> get(@RequestParam Long id)throws BaseException{
		return HttpUtils.get(TenantUrl.SCM_PRODUCT_RECOMMEND_GET, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<RecommendDetailDto>>
        () {});
    }
}

