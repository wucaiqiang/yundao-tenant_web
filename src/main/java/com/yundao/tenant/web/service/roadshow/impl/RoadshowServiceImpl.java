
package com.yundao.tenant.web.service.roadshow.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.roadshow.RoadshowAddReqDto;
import com.yundao.tenant.web.dto.roadshow.RoadshowDetailResDto;
import com.yundao.tenant.web.dto.roadshow.RoadshowReqDto;
import com.yundao.tenant.web.dto.roadshow.RoadshowResDto;
import com.yundao.tenant.web.dto.roadshow.RoadshowUpdateReqDto;
import com.yundao.tenant.web.service.roadshow.RoadshowService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.DateUtils;
import com.yundao.tenant.web.util.HttpUtils;

/**
 * Function: Reason: Date: 2017年11月9日 下午3:04:32
 * 
 * @author wucq
 * @version
 */
@Service
public class RoadshowServiceImpl implements RoadshowService {

	@Override
	public Result<PaginationSupport<RoadshowResDto>> getPage(RoadshowReqDto dto) throws BaseException {

		if (dto.getUpdateDateEnd() != null) {
			dto.setUpdateDateEnd(DateUtils.toEndDate(dto.getUpdateDateEnd()));// 设置当前时间为最大时间
		}
		if (dto.getCreateDateEnd() != null) {
			dto.setCreateDateEnd(DateUtils.toEndDate(dto.getCreateDateEnd()));
		}
		Result<PaginationSupport<RoadshowResDto>> result = HttpUtils.get(TenantUrl.ROADSHOW_GET_PAGE,
				ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<RoadshowResDto>>>() {
				});
		return result;

	}

	@Override
	public Result<Long> add(RoadshowAddReqDto reqDto) throws BaseException {

		Map<String, Object> params = ArgsUtils.toMap(reqDto);
		Result<Long> result = HttpUtils.post(TenantUrl.ROADSHOW_ADD, params, new BaseTypeReference<Result<Long>>() {
		});
		return result;

	}

	@Override
	public Result<Long> update(RoadshowUpdateReqDto reqDto) throws BaseException {

		Map<String, Object> params = ArgsUtils.toMap(reqDto);
		Result<Long> result = HttpUtils.post(TenantUrl.ROADSHOW_UPDATE, params, new BaseTypeReference<Result<Long>>() {
		});
		return result;

	}

	@Override
	public Result<RoadshowDetailResDto> get(Long id) throws BaseException {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		Result<RoadshowDetailResDto> result = HttpUtils.get(TenantUrl.ROADSHOW_GET, params,
				new BaseTypeReference<Result<RoadshowDetailResDto>>() {
				});
		return result;

	}

	@Override
	public Result<Integer> delete(String ids) throws BaseException {

		Map<String, Object> params = new HashMap<>();
		params.put("ids", ids);
		Result<Integer> result = HttpUtils.post(TenantUrl.ROADSHOW_DELETE, params,
				new BaseTypeReference<Result<Integer>>() {
				});
		return result;

	}

}
