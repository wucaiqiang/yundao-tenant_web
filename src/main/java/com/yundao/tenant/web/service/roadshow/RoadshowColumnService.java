
package com.yundao.tenant.web.service.roadshow;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.roadshow.BaseRoadshowColumn;
import com.yundao.tenant.web.dto.roadshow.RoadshowColumnAddReqDto;
import com.yundao.tenant.web.dto.roadshow.RoadshowColumnReqDto;
import com.yundao.tenant.web.dto.roadshow.RoadshowColumnResDto;
import com.yundao.tenant.web.dto.roadshow.RoadshowColumnUpdateReqDto;

/**
 * Function: Reason: Date: 2017年11月8日 下午2:59:37
 * 
 * @author wucq
 * @version
 */
public interface RoadshowColumnService {
	public Result<PaginationSupport<RoadshowColumnResDto>> getPage(RoadshowColumnReqDto dto) throws BaseException;

	public Result<Long> add(RoadshowColumnAddReqDto reqDto) throws BaseException;

	public Result<Long> update(RoadshowColumnUpdateReqDto reqDto) throws BaseException;

	public Result<RoadshowColumnResDto> get(Long id) throws BaseException;

	public Result<List<BaseRoadshowColumn>> getsByPlatformId(Long platformId) throws BaseException;

	public Result<Integer> delete(String ids) throws BaseException;

}
