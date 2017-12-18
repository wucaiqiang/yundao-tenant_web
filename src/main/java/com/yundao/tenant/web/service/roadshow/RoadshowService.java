
package com.yundao.tenant.web.service.roadshow;

import org.springframework.web.bind.annotation.RequestParam;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.roadshow.RoadshowAddReqDto;
import com.yundao.tenant.web.dto.roadshow.RoadshowDetailResDto;
import com.yundao.tenant.web.dto.roadshow.RoadshowReqDto;
import com.yundao.tenant.web.dto.roadshow.RoadshowResDto;
import com.yundao.tenant.web.dto.roadshow.RoadshowUpdateReqDto;

/**
 * Function: Reason: Date: 2017年11月9日 下午3:04:19
 * 
 * @author wucq
 * @version
 */
public interface RoadshowService {

	public Result<PaginationSupport<RoadshowResDto>> getPage(RoadshowReqDto dto) throws BaseException;

	public Result<Long> add(RoadshowAddReqDto reqDto) throws BaseException;

	public Result<Long> update(RoadshowUpdateReqDto reqDto) throws BaseException;

	public Result<RoadshowDetailResDto> get(@RequestParam Long id) throws BaseException;

	public Result<Integer> delete(@RequestParam String ids) throws BaseException;
}
