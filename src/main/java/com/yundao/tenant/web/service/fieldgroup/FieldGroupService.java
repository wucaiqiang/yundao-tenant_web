package com.yundao.tenant.web.service.fieldgroup;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.fieldgroup.FieldGroupRelDto;

import java.util.Map;

/**
 * Created by gjl on 2017/7/6.
 */
public interface FieldGroupService {
    public FieldGroupRelDto get(Long id) throws BaseException;

    /**
     * 检查是否能删除
     * @param params
     * @return
     */
    Result<PermissionResultDto> checkDelete(Map<String, Object> params) throws BaseException;

    Boolean checkUpdate(Long id) throws BaseException;
}
