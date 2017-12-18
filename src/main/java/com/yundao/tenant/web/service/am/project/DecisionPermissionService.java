package com.yundao.tenant.web.service.am.project;

import com.yundao.core.exception.BaseException;

/**
 * 立项权限控制服务接口
 *
 * @author jan
 * @create 2017-11-25 08:33
 **/
public interface DecisionPermissionService {

    /**
     * 检查是否有修改的权限
     *
     * @param decisionId 立项id
     */
    boolean checkEdit(Long decisionId) throws BaseException;

    /**
     * 检查是否有读取的权限
     *
     * @param decisionId 立项id
     */
    boolean checkRead(Long decisionId) throws BaseException;

    /**
     * 检查是否有修改的权限，如果没有直接抛出异常
     *
     * @param decisionId 立项id
     */
    void checkEditAndThrow(Long decisionId) throws BaseException;


}
