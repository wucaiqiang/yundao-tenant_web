
package com.yundao.tenant.web.service.roadshow.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.roadshow.BaseRoadshowColumn;
import com.yundao.tenant.web.dto.roadshow.RoadshowColumnAddReqDto;
import com.yundao.tenant.web.dto.roadshow.RoadshowColumnReqDto;
import com.yundao.tenant.web.dto.roadshow.RoadshowColumnResDto;
import com.yundao.tenant.web.dto.roadshow.RoadshowColumnUpdateReqDto;
import com.yundao.tenant.web.service.roadshow.RoadshowColumnService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.DateUtils;
import com.yundao.tenant.web.util.HttpUtils;

/**
 * Function: Reason: Date: 2017年11月8日 下午3:00:11
 * 
 * @author wucq
 * @version
 */
@Service
public class RoadshowColumnServiceImpl implements RoadshowColumnService {

	@Override
	public Result<PaginationSupport<RoadshowColumnResDto>> getPage(RoadshowColumnReqDto dto) throws BaseException {

		if (dto.getUpdateDateEnd() != null) {
			dto.setUpdateDateEnd(DateUtils.toEndDate(dto.getUpdateDateEnd()));// 设置当前时间为最大时间
		}
		Result<PaginationSupport<RoadshowColumnResDto>> result = HttpUtils.get(TenantUrl.ROADSHOW_COLUMN_GET_PAGE,
				ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<RoadshowColumnResDto>>>() {
				});
		return result;

	}

	@Override
	public Result<Long> add(RoadshowColumnAddReqDto reqDto) throws BaseException {

		Map<String, Object> params = ArgsUtils.toMap(reqDto);
		Result<Long> result = HttpUtils.post(TenantUrl.ROADSHOW_COLUMN_ADD, params,
				new BaseTypeReference<Result<Long>>() {
				});
		return result;

	}

	@Override
	public Result<Long> update(RoadshowColumnUpdateReqDto reqDto) throws BaseException {
		Map<String, Object> params = ArgsUtils.toMap(reqDto);
		Result<Long> result = HttpUtils.post(TenantUrl.ROADSHOW_COLUMN_UPDATE, params,
				new BaseTypeReference<Result<Long>>() {
				});
		return result;

	}

	@Override
	public Result<RoadshowColumnResDto> get(Long id) throws BaseException {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		Result<RoadshowColumnResDto> result = HttpUtils.get(TenantUrl.ROADSHOW_COLUMN_GET, params,
				new BaseTypeReference<Result<RoadshowColumnResDto>>() {
				});
		return result;
	}

	@Override
	public Result<List<BaseRoadshowColumn>> getsByPlatformId(Long platformId) throws BaseException {

		Map<String, Object> params = new HashMap<>();
		params.put("platformId", platformId);
		Result<List<BaseRoadshowColumn>> result = HttpUtils.get(TenantUrl.ROADSHOW_COLUMN_GET_BY_PLATFORM_ID, params,
				new BaseTypeReference<Result<List<BaseRoadshowColumn>>>() {
				});
		return result;

	}

	@Override
	public Result<Integer> delete(String ids) throws BaseException {

		Map<String, Object> params = new HashMap<>();
		params.put("ids", ids);
		Result<Integer> result = HttpUtils.post(TenantUrl.ROADSHOW_COLUMN_DELETE, params,
				new BaseTypeReference<Result<Integer>>() {
				});
		return result;

	}

}
