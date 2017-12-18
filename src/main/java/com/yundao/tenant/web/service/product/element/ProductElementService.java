package com.yundao.tenant.web.service.product.element;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jan
 * @create 2017-09-21 AM10:10
 **/
public interface ProductElementService {

    Result<PermissionResultDto> delete(@RequestParam String ids) throws BaseException;

}
