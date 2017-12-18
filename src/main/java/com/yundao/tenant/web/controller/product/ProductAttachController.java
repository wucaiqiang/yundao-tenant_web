package com.yundao.tenant.web.controller.product;

import java.util.HashMap;
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
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.product.attach.ProductAttachAddReqDto;
import com.yundao.tenant.web.dto.product.attach.ProductAttachListReqDto;
import com.yundao.tenant.web.dto.product.attach.ProductAttachListResDto;
import com.yundao.tenant.web.dto.product.attach.ProductAttachUpdateReqDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 产品附件管理
 * 
 * @author 欧阳利 2017年7月11日
 */
@RestController
@RequestMapping("/product/attach")
@ResponseBody
@Api("产品-->产品附件管理")
public class ProductAttachController {
	private static Log log = LogFactory.getLog(ProductAttachController.class);

	/**
	 * 添加产品附件
	 * 
	 * @return
	 */

	@ApiOperation(value = "添加产品附件")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result<Long> add(@ModelAttribute ProductAttachAddReqDto reqDto) throws Exception {
		log.info("添加产品附件:", reqDto);
		return HttpUtils.post(TenantUrl.ADD_PRODUCT_ATTACH, ArgsUtils.toMap(reqDto),
				new BaseTypeReference<Result<Long>>() {
				});
	}

	@ApiOperation(value = "修改产品附件")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Result<Long> update(@ModelAttribute ProductAttachUpdateReqDto reqDto) throws Exception {
		log.info("添加产品附件:", reqDto);
		Map<String, Object> params = ArgsUtils.toMap(reqDto);
		params.put("id", reqDto.getFileId());
		return HttpUtils.post(TenantUrl.UPDATE_PRODUCT_ATTACH, params,
				new BaseTypeReference<Result<Long>>() {
				});
	}

	/**
	 * 删除产品附件
	 * 
	 * @return
	 */
	@ApiOperation(value = "删除产品附件")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Result<Long> delete(@RequestParam long id) throws Exception {
		log.info("删除产品附件Id:", id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return HttpUtils.post(TenantUrl.DELETE_PRODUCT_ATTACH, map, new BaseTypeReference<Result<Long>>() {
		});
	}

	/**
	 * 产品附件列表
	 * 
	 * @return
	 */
	@ApiOperation(value = "分页产品附件")
	@RequestMapping(value = "/gets", method = RequestMethod.GET)
	public Result<PaginationSupport<ProductAttachListResDto>> gets(@ModelAttribute ProductAttachListReqDto reqDto)
			throws Exception {
		log.info("分页查询产品附件:", reqDto);
		return HttpUtils.get(TenantUrl.GETS_PRODUCT_ATTACH, ArgsUtils.toMap(reqDto),
				new BaseTypeReference<Result<PaginationSupport<ProductAttachListResDto>>>() {
				});
	}

}
