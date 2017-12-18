package com.yundao.tenant.web.service.am.project;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.web.dto.project.ProjectOwnerIdResDto;
import com.yundao.tenant.web.enums.access.OperationPermissionEnum;

/**
 * 项目权限控制服务接口
 *
 * @author jan
 * @create 2017-11-24 21:23
 **/
public interface ProjectPermissionService {

    /**
     * 检查是否有修改的权限
     *
     * @param projectId 项目id
     */
    boolean checkEdit(Long projectId) throws BaseException;

    /**
     * 检查是否有读取的权限
     *
     * @param projectId 项目id
     */
    boolean checkRead(Long projectId) throws BaseException;

    /**
     * 检查是否有删除的权限
     *
     * @param projectId 项目id
     */
    boolean checkDelete(Long projectId) throws BaseException;

    /**
     * 检查是否有修改的权限，如果没有直接抛出异常
     *
     * @param projectId 项目id
     */
    void checkEditAndThrow(Long projectId) throws BaseException;

    /**
     * 检查是否有读取的权限，如果没有直接抛出异常
     *
     * @param projectId 项目id
     */
    void checkReadAndThrow(Long projectId) throws BaseException;

    /**
     * 检查是否有删除的权限，如果没有直接抛出异常
     *
     * @param projectId 项目id
     */
    void checkDeleteAndThrow(Long projectId) throws BaseException;

    /**
     * 检查对项目的数据操作权限
     *
     * @param dto       项目的负责人和组员
     * @param operation 操作
     */
    boolean checkPermission(ProjectOwnerIdResDto dto, OperationPermissionEnum operation) throws BaseException;


}
