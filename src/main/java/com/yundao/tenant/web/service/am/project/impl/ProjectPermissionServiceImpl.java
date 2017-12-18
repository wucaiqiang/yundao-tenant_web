package com.yundao.tenant.web.service.am.project.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.common.DataPermissionDto;
import com.yundao.tenant.web.dto.permission.PermissionMultiCodeDto;
import com.yundao.tenant.web.dto.project.ProjectOwnerIdResDto;
import com.yundao.tenant.web.enums.access.OperationPermissionEnum;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.service.am.project.ProjectPermissionService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import com.yundao.tenant.web.util.SymbolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目权限控制服务实现
 *
 * @author jan
 * @create 2017-11-24 21:34
 **/
@Service
public class ProjectPermissionServiceImpl implements ProjectPermissionService {

    @Autowired
    private PermissionService permissionService;

    @Override
    public boolean checkEdit(Long projectId) throws BaseException {
        return this.checkPermission(this.getOwnerData(projectId), OperationPermissionEnum
                .EDIT);
    }

    @Override
    public boolean checkRead(Long projectId) throws BaseException {
        return this.checkPermission(this.getOwnerData(projectId), OperationPermissionEnum
                .READ);
    }

    @Override
    public boolean checkDelete(Long projectId) throws BaseException {
        return this.checkPermission(this.getOwnerData(projectId), OperationPermissionEnum
                .DELETE);
    }

    @Override
    public void checkEditAndThrow(Long projectId) throws BaseException {
        if (!this.checkEdit(projectId))
            throw new BaseException(CodeConstant.CODE_1220016);
    }

    @Override
    public void checkReadAndThrow(Long projectId) throws BaseException {
        if (!this.checkRead(projectId))
            throw new BaseException(CodeConstant.CODE_1220016);
    }

    @Override
    public void checkDeleteAndThrow(Long projectId) throws BaseException {
        if (!this.checkDelete(projectId))
            throw new BaseException(CodeConstant.CODE_1220016);
    }

    /**
     * 检查对项目的数据操作权限
     *
     * @param dto       项目的负责人和组员
     * @param operation 操作
     */
    @Override
    public boolean checkPermission(ProjectOwnerIdResDto dto, OperationPermissionEnum operation) throws BaseException {
        List<Long> userIds = new ArrayList<>();
        if (dto.getLeaderId() != null)
            userIds.add(dto.getLeaderId());
        if (BooleanUtils.isNotBlank(dto.getCrewIds()))
            userIds.addAll(SymbolUtils.toLong(dto.getCrewIds()));

        List<PermissionMultiCodeDto> reqDtos = new ArrayList<>();
        reqDtos.add(new PermissionMultiCodeDto(DataObjectEnum.PROJECT.getCode(), userIds));
        List<DataPermissionDto> dps = permissionService.checkRead(reqDtos).getResult();
        DataPermissionDto dp = dps.get(0);

        boolean isPermission = false;
        if (OperationPermissionEnum.EDIT.equals(operation)) {
            isPermission = dp.getEditPermission();

        } else if (OperationPermissionEnum.DELETE.equals(operation)) {
            isPermission = dp.getDeletePermission();

        } else if (OperationPermissionEnum.READ.equals(operation)) {
            isPermission = dp.getReadPermission();
        }
        return isPermission;
    }

    private ProjectOwnerIdResDto getOwnerData(Long projectId) throws BaseException {
        Result<ProjectOwnerIdResDto> result = HttpUtils.get(AmUrl.GET_PROJECT_OWNER_BY_ID, ArgsUtils.toIdMap
                (projectId, "projectId"), new
                BaseTypeReference<Result<ProjectOwnerIdResDto>>() {
                });
        if (!result.getSuccess())
            throw new BaseException(result.getCode(), result.getMessage());
        return result.getResult();
    }

}
