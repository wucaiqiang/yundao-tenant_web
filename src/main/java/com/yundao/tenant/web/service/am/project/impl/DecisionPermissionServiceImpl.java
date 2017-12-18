package com.yundao.tenant.web.service.am.project.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.project.ProjectOwnerIdResDto;
import com.yundao.tenant.web.enums.access.OperationPermissionEnum;
import com.yundao.tenant.web.service.am.project.DecisionPermissionService;
import com.yundao.tenant.web.service.am.project.ProjectPermissionService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 立项权限控制服务实现
 *
 * @author jan
 * @create 2017-11-25 08:34
 **/
@Service
public class DecisionPermissionServiceImpl implements DecisionPermissionService {

    @Autowired
    private ProjectPermissionService projectPermissionService;

    @Override
    public boolean checkEdit(Long decisionId) throws BaseException {
        return projectPermissionService.checkPermission(this.getOwnerData(decisionId), OperationPermissionEnum.EDIT);
    }

    @Override
    public boolean checkRead(Long decisionId) throws BaseException {
        return projectPermissionService.checkPermission(this.getOwnerData(decisionId), OperationPermissionEnum.READ);
    }

    @Override
    public void checkEditAndThrow(Long decisionId) throws BaseException {
        if (!this.checkEdit(decisionId))
            throw new BaseException(CodeConstant.CODE_1220016);
    }

    private ProjectOwnerIdResDto getOwnerData(Long decisionId) throws BaseException {
        Result<ProjectOwnerIdResDto> result = HttpUtils.get(AmUrl.GET_PROJECT_OWNER_BY_DECISION_ID, ArgsUtils.toIdMap
                (decisionId, "id"), new
                BaseTypeReference<Result<ProjectOwnerIdResDto>>() {
                });
        if (!result.getSuccess())
            throw new BaseException(result.getCode(), result.getMessage());
        return result.getResult();
    }
}
