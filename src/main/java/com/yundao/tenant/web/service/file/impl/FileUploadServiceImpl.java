package com.yundao.tenant.web.service.file.impl;

import com.yundao.core.code.Result;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.threadlocal.filter.RequestCommonParams;
import com.yundao.core.utils.ConfigUtils;
import com.yundao.core.utils.HttpUtils;
import com.yundao.core.utils.HttpUtils.UploadFileParams;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.web.constant.url.BaseUrl;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.exception.SpringExceptionResolver;
import com.yundao.tenant.web.service.file.FileUploadService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gjl
 * @description 文件上传实现类
 * @date 2016年3月1日
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

	private static Log log = LogFactory.getLog(FileUploadServiceImpl.class);
	/**
	 * 文件上传
	 *
	 * @param is
	 * @param fileName
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Result<Integer> fileUpload(InputStream is, String fileName) throws Exception {
		log.begin("CRM系统文件上传");
		Result<Integer> result = Result.newFailureResult();
		try {
			// 调用文件基础服务接口上传文件
			String url = BaseUrl.FILE_UPLOAD_POST;
			List<UploadFileParams> files = new ArrayList<UploadFileParams>();
			UploadFileParams uploadFileParams = new UploadFileParams();
			uploadFileParams.setFileName(fileName);
			uploadFileParams.setParameterName("file");
			uploadFileParams.setInputStream(is);
			files.add(uploadFileParams);

			Map<String, String> methodParams = new HashMap<String, String>();
			methodParams.put("cloudType", "0");
			methodParams.put("folder", "");
			RequestCommonParams requestParams = RequestCommonParams.newDefault(methodParams);
			requestParams.setHeaderParams(com.yundao.tenant.web.util.HttpUtils.getHeaderParams());
			log.info("文件开始上传 url：" + url + " files：" + files + " requestParams:" + requestParams);
			requestParams.setHeaderParams(com.yundao.tenant.web.util.HttpUtils.getHeaderParams());
			result = JsonUtils.jsonToObject(HttpUtils.postFiles(url, files, requestParams), Result.class);
			log.info("上传成功！返回结果：" + result.toString());
		} catch (Exception e) {
			log.error("文件上传异常", e);
			return Result.newFailureResult();
		}finally {
			// 关闭流
			is.close();
		}
		log.end();
		return result;
	}
}
