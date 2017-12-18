
package com.yundao.tenant.web.controller.video;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.video.VideoAddReqDto;
import com.yundao.tenant.web.dto.video.VideoDto;
import com.yundao.tenant.web.dto.video.VideoReqDto;
import com.yundao.tenant.web.dto.video.VideoUpdateReqDto;
import com.yundao.tenant.web.service.video.VideoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Function: Reason: Date: 2017年11月3日 下午4:31:31
 * 
 * @author wucq
 * @version
 */
@RestController
@RequestMapping("/video/")
@ResponseBody
@Api("视频管理")
public class VideoController {
	@Autowired
	private VideoService videoService;

	@RequestMapping(value = "get_upload_signature", method = RequestMethod.GET)
	@ApiOperation(value = "请求上传文件签名")
	public Result<String> getUploadSignature() throws Exception {
		return videoService.getUploadSignature();
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ApiOperation(value = "请求上传文件")
	public Result<Long> add(@ModelAttribute VideoAddReqDto req) throws Exception {
		return videoService.add(req);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ApiOperation(value = "修改视频名")
	public Result<Long> update(@ModelAttribute VideoUpdateReqDto req) throws Exception {
		return videoService.updateName(req);
	}

	@RequestMapping(value = "get_page", method = RequestMethod.GET)
	@ApiOperation(value = "分页查询")
	public Result<PaginationSupport<VideoDto>> getPage(@ModelAttribute VideoReqDto dto) throws Exception {
		return videoService.getPage(dto);
	}

	@RequestMapping(value = "get", method = RequestMethod.GET)
	@ApiOperation(value = "分页查询")
	public Result<VideoDto> get(@RequestParam Long id) throws Exception {
		return videoService.get(id);
	}

	@RequestMapping(value = "gets_by_name", method = RequestMethod.GET)
	@ApiOperation(value = "根据视频名查询")
	public Result<List<VideoDto>> getsByName(@RequestParam(defaultValue = "") String name) throws Exception {
		return videoService.getsByName(name);
	}

	@RequestMapping(value = "convert", method = RequestMethod.POST)
	@ApiOperation(value = "根据视频IDs进行转码处理")
	public Result<PermissionResultDto> convert(@RequestParam(defaultValue = "") String ids) throws Exception {
		return videoService.convert(ids);
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ApiOperation(value = "批量删除信息")
	public Result<PermissionResultDto> delete(@RequestParam String ids) throws Exception {
		return videoService.delete(ids);
	}
}
