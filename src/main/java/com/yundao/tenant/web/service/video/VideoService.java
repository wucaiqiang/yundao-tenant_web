
package com.yundao.tenant.web.service.video;

import java.util.List;
import java.util.Map;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.video.VideoAddReqDto;
import com.yundao.tenant.web.dto.video.VideoDto;
import com.yundao.tenant.web.dto.video.VideoReqDto;
import com.yundao.tenant.web.dto.video.VideoUpdateReqDto;

/**
 * Function: Reason: Date: 2017年11月3日 下午4:34:11
 * 
 * @author wucq
 * @version
 */
public interface VideoService {
	public Result<String> getUploadSignature() throws Exception;
	public Result<Long> add(VideoAddReqDto req) throws Exception;
	public Result<Long> updateName(VideoUpdateReqDto req) throws Exception;
	public Result<PaginationSupport<VideoDto>> getPage( VideoReqDto dto) throws Exception;
	public Result<VideoDto> get(Long id) throws Exception;
	public Result<List<VideoDto>> getsByName(String name) throws Exception ;
	public Result<PermissionResultDto> convert(String name) throws Exception ;
	public Result<PermissionResultDto> delete(String ids) throws Exception;
}
