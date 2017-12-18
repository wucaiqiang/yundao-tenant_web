
package com.yundao.tenant.web.service.video.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.video.VideoAddReqDto;
import com.yundao.tenant.web.dto.video.VideoDto;
import com.yundao.tenant.web.dto.video.VideoReqDto;
import com.yundao.tenant.web.dto.video.VideoUpdateReqDto;
import com.yundao.tenant.web.enums.video.VideoCategoryEnum;
import com.yundao.tenant.web.service.video.VideoService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.DateUtils;
import com.yundao.tenant.web.util.HttpUtils;

/**
 * Function: Reason: Date: 2017年11月3日 下午4:34:31
 * 
 * @author wucq
 * @version
 */
@Service
public class VideoServiceImpl implements VideoService {

	@Override
	public Result<Long> updateName(VideoUpdateReqDto req) throws Exception {
		Map<String, Object> params = ArgsUtils.toMap(req);
		Result<Long> result = HttpUtils.post(TenantUrl.VIDEO_UPDATE, params, new BaseTypeReference<Result<Long>>() {
		});
		return result;
	}

	@Override
	public Result<Long> add(VideoAddReqDto req) throws Exception {
		Map<String, Object> params = ArgsUtils.toMap(req);
		params.put("category", VideoCategoryEnum.ROADSHOW.getValue());
		Result<Long> result = HttpUtils.post(TenantUrl.VIDEO_ADD, params, new BaseTypeReference<Result<Long>>() {
		});
		return result;

	}

	@Override
	public Result<String> getUploadSignature() throws Exception {
		Result<String> result = HttpUtils.get(TenantUrl.VIDEO_GET_UPLOAD_SIGNATURE, null,
				new BaseTypeReference<Result<String>>() {
				});
		return result;

	}

	@Override
	public Result<PaginationSupport<VideoDto>> getPage(VideoReqDto dto) throws Exception {
		if (dto.getCreateDateEnd() != null) {
			dto.setCreateDateEnd(DateUtils.toEndDate(dto.getCreateDateEnd()));// 设置当前时间为最大时间
		}
		Map<String, Object> params = ArgsUtils.toMap(dto);
		params.put("category", VideoCategoryEnum.ROADSHOW.getValue());
		Result<PaginationSupport<VideoDto>> result = HttpUtils.get(TenantUrl.VIDEO_GET_PAGE, params,
				new BaseTypeReference<Result<PaginationSupport<VideoDto>>>() {
				});
		return result;

	}

	@Override
	public Result<VideoDto> get(Long id) throws Exception {
		Map<String, Object> methodParams = new HashMap<>();
		methodParams.put("id", id);
		Result<VideoDto> result = HttpUtils.get(TenantUrl.VIDEO_GET, methodParams,
				new BaseTypeReference<Result<VideoDto>>() {
				});
		return result;
	}

	@Override
	public Result<PermissionResultDto> convert(String ids) throws Exception {

		Map<String, Object> methodParams = new HashMap<>();
		methodParams.put("ids", ids);
		Result<PermissionResultDto> result = HttpUtils.post(TenantUrl.VIDEO_CONVERT, methodParams,
				new BaseTypeReference<Result<PermissionResultDto>>() {
				});
		return result;

	}

	@Override
	public Result<List<VideoDto>> getsByName(String name) throws Exception {
		Map<String, Object> methodParams = new HashMap<>();
		methodParams.put("name", name);
		methodParams.put("category", VideoCategoryEnum.ROADSHOW.getValue());
		Result<List<VideoDto>> result = HttpUtils.get(TenantUrl.VIDEO_GET_BY_NAME, methodParams,
				new BaseTypeReference<Result<List<VideoDto>>>() {
				});
		return result;

	}

	@Override
	public Result<PermissionResultDto> delete(String ids) throws Exception {
		Map<String, Object> methodParams = new HashMap<>();
		methodParams.put("ids", ids);
		Result<PermissionResultDto> result = HttpUtils.post(TenantUrl.VIDEO_DELETE, methodParams,
				new BaseTypeReference<Result<PermissionResultDto>>() {
				});
		return result;

	}

}
