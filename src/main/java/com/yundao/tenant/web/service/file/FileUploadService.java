package com.yundao.tenant.web.service.file;

import com.yundao.core.code.Result;

import java.io.InputStream;
import java.util.Map;

/**
 * @author gjl
 * @description 文件服务
 * @date 2016年2月18日
 */
public interface FileUploadService {
	/**
	 * 文件上传
	 * @return Result
	 * @throws Exception
	 */
	public Result fileUpload(InputStream is, String fileName)throws Exception;
}
