package com.yundao.tenant.web.service.am.project.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.project.ProjectOwnerIdResDto;
import com.yundao.tenant.web.enums.access.OperationPermissionEnum;
import com.yundao.tenant.web.service.am.project.DecisionFlowPermissionService;
import com.yundao.tenant.web.service.am.project.ProjectPermissionService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 立项流程权限控制服务实现
 *
 * @author jan
 * @create 2017-11-25 08:40
 **/
@Service
public class DecisionFlowPermissionServiceImpl implements DecisionFlowPermissionService {
    @Autowired
    private ProjectPermissionService projectPermissionService;

    @Override
    public boolean checkEdit(Long flowId) throws BaseException {
        return projectPermissionService.checkPermission(this.getOwnerData(flowId), OperationPermissionEnum.EDIT);
    }

    @Override
    public void checkEditAndThrow(Long flowId) throws BaseException {
        if (!this.checkEdit(flowId))
            throw new BaseException(CodeConstant.CODE_1220016);
    }

    private ProjectOwnerIdResDto getOwnerData(Long flowId) throws BaseException {
        Result<ProjectOwnerIdResDto> result = HttpUtils.get(AmUrl.GET_PROJECT_OWNER_BY_FLOW_ID, ArgsUtils.toIdMap
                (flowId, "flowId"), new
                BaseTypeReference<Result<ProjectOwnerIdResDto>>() {
                });
        if (!result.getSuccess())
            throw new BaseException(result.getCode(), result.getMessage());
        return result.getResult();
    }
}
