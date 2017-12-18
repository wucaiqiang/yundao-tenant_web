
package com.yundao.tenant.web.controller.platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yundao.tenant.web.enums.PlatformEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.plafrom.PlatformDto;
import com.yundao.tenant.web.dto.plafrom.PositionDto;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Function: Reason: Date: 2017年10月20日 下午2:01:25
 * 
 * @author 欧阳利
 * @version
 */
@RestController
@RequestMapping("/platform")
@ResponseBody
@Api("平台")
public class PlatformController {

	@ApiOperation(value = "获取所有平台")
	@RequestMapping(value = "/get_all", method = RequestMethod.GET)
	public Result<List<PlatformDto>> getAllPlatformDto() throws Exception {
		return HttpUtils.get(TenantUrl.PLATFORM_GET_ALL, null, new BaseTypeReference<Result<List<PlatformDto>>>() {
		});
	}

	@ApiOperation(value = "获取文章平台")
	@RequestMapping(value = "/get_web", method = RequestMethod.GET)
	public Result<List<PlatformDto>> getWebPlatformDto() throws Exception {
		Result<List<PlatformDto>> result = HttpUtils.get(TenantUrl.PLATFORM_GET_ALL, null,
				new BaseTypeReference<Result<List<PlatformDto>>>() {
				});
		List<PlatformDto> platformDtos = result.getResult();
		List<PlatformDto> handleDtos = new ArrayList<>();
		for (PlatformDto platformDto : platformDtos) {
			if (platformDto.getCode().equals(PlatformEnum.WEB_SITE.getCode())) {
				handleDtos.add(platformDto);
			}
		}
		result.setResult(handleDtos);
		return result;
	}

	@ApiOperation(value = "获取路演平台")
	@RequestMapping(value = "/get_roadshow_platform", method = RequestMethod.GET)
	public Result<List<PlatformDto>> getRoadshowPlatform() throws Exception {
		Result<List<PlatformDto>> result = HttpUtils.get(TenantUrl.PLATFORM_GET_ALL, null,
				new BaseTypeReference<Result<List<PlatformDto>>>() {
				});
		List<PlatformDto> platformDtos = result.getResult();
		List<PlatformDto> handleDtos = new ArrayList<>();
		for (PlatformDto platformDto : platformDtos) {
			if (platformDto.getCode().equals(PlatformEnum.APP_TO_B.getCode())) {
				handleDtos.add(platformDto);
			}
		}
		result.setResult(handleDtos);
		return result;
	}

	@ApiOperation(value = "获取平台的位置")
	@RequestMapping(value = "/get_position_by_platform", method = RequestMethod.GET)
	public Result<List<PositionDto>> getPositionDtoByPlatform(@RequestParam Long platformId) throws Exception {
		Map<String, Object> methodParams = new HashMap<String, Object>();
		methodParams.put("platformId", platformId);
		return HttpUtils.get(TenantUrl.PLATFORM_GET_POSTION_BY_PLATFORM, methodParams,
				new BaseTypeReference<Result<List<PositionDto>>>() {
				});
	}
}
