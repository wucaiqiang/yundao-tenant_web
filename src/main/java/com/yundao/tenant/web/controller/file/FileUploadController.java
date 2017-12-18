package com.yundao.tenant.web.controller.file;

import com.yundao.core.code.Result;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.jsonp.Jsonp;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.web.dto.file.BaseCloudFile;
import com.yundao.tenant.web.service.file.FileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

@RestController
@RequestMapping(value = "/file")
@ResponseBody
@Api("文件上传")
@Jsonp
public class FileUploadController {

	private static Log log = LogFactory.getLog(FileUploadController.class);

	@Autowired
	private FileUploadService fileUploadService;

	private String UPLOAD_RESULJT = "<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction('%s','%s')</script>";

	/**
	 * 文件上传
	 * 
	 * @param file
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value="上传文件", notes="上传文件")
	@RequestMapping(value = "/upload",method= RequestMethod.POST)
	public Result<Integer> upload(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request) throws Exception {
		Result result = Result.newSuccessResult();
		if (!file.isEmpty()) {
			int pre = (int) System.currentTimeMillis();
			try {
				InputStream in = file.getInputStream();
				result = fileUploadService.fileUpload(in, file.getOriginalFilename());
				int finaltime = (int) System.currentTimeMillis();
				log.info("上传耗时间：" + (finaltime - pre) + "毫秒.");
			}
			catch (Exception e) {
				log.error("文件上传出错", e);
				e.printStackTrace();
				return Result.newFailureResult(CommonCode.COMMON_0);
			}
		}
		else {
			log.info("文件是空的");
			return Result.newFailureResult(CommonCode.COMMON_0);
		}
		return result;
	}

	/**
	 * 文件上传
	 *
	 * @param file
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value="富文本上传文件", notes="富文本上传文件")
	@RequestMapping(value = "/upload_callback",method= RequestMethod.POST)
	public String uploadCallback(@RequestParam(value = "upload") MultipartFile file,HttpServletRequest request) throws Exception {
		String callback = request.getParameter("CKEditorFuncNum");
		Result result = Result.newSuccessResult();
		if (!file.isEmpty()) {
			int pre = (int) System.currentTimeMillis();
			try {
				InputStream in = file.getInputStream();
				result = fileUploadService.fileUpload(in, file.getOriginalFilename());
				int finaltime = (int) System.currentTimeMillis();
				log.info("上传耗时间：" + (finaltime - pre) + "毫秒.");
			}
			catch (Exception e) {
				log.error("文件上传出错", e);
				e.printStackTrace();
				return JsonUtils.objectToJson(Result.newFailureResult(CommonCode.COMMON_0));
			}
		}
		else {
			log.info("文件是空的");
			return JsonUtils.objectToJson(Result.newFailureResult(CommonCode.COMMON_0));
		}
		BaseCloudFile cloudFile = JsonUtils.jsonToObject(JsonUtils.objectToJson(result.getResult()), BaseCloudFile.class);
		return String.format(UPLOAD_RESULJT,callback,cloudFile.getUrl());
	}
}