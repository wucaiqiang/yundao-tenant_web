package com.yundao.tenant.web.service.am.project;

import com.yundao.core.exception.BaseException;

/**
 * 立项流程权限控制服务接口
 *
 * @author jan
 * @create 2017-11-25 08:39
 **/
public interface DecisionFlowPermissionService {

    /**
     * 检查是否有修改的权限
     *
     * @param flowId 立项流程id
     */
    boolean checkEdit(Long flowId) throws BaseException;

    /**
     * 检查是否有修改的权限，如果没有直接抛出异常
     *
     * @param flowId 立项流程id
     */
    void checkEditAndThrow(Long flowId) throws BaseException;

}
