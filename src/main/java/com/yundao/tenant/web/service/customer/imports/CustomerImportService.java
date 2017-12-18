package com.yundao.tenant.web.service.customer.imports;

import com.yundao.core.code.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 客户导入服务接口
 *
 * @author jan
 * @create 2017-08-31 PM5:02
 **/
public interface CustomerImportService {

    /**
     * 从客户批量导入客户
     */
    Result<Object> importFromCustomer(HttpServletResponse response, MultipartFile file) throws Exception;

    /**
     * 从公海批量导入
     */
    Result<Object> importFromOpensea(HttpServletResponse response, MultipartFile file) throws Exception;


}
