package com.yundao.tenant.web.service.am.project.decision.flow.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.project.decision.flow.DecisionFileOwnerResDto;
import com.yundao.tenant.web.dto.project.decision.flow.DecisionFlowFileIdReqDto;
import com.yundao.tenant.web.dto.project.decision.flow.DecisionFlowFileReqDto;
import com.yundao.tenant.web.dto.project.decision.flow.DecisionFlowRemarkReqDto;
import com.yundao.tenant.web.dto.project.file.DecisionFlowFileResDto;
import com.yundao.tenant.web.service.am.project.DecisionFlowPermissionService;
import com.yundao.tenant.web.service.am.project.ProjectPermissionService;
import com.yundao.tenant.web.service.am.project.decision.flow.DecisionFlowService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 立项流程服务实现
 *
 * @author jan
 * @create 2017-11-22 15:57
 **/
@Service
public class DecisionFlowServiceImpl implements DecisionFlowService {

    @Autowired
    private DecisionFlowPermissionService decisionFlowPermissionService;

    @Autowired
    private ProjectPermissionService projectPermissionService;


    @Override
    public Result<DecisionFlowFileResDto> addFile(DecisionFlowFileReqDto dto) throws BaseException {
        decisionFlowPermissionService.checkEditAndThrow(dto.getFlowId());
        return HttpUtils.post(AmUrl.ADD_DECISION_FLOW_FILE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<DecisionFlowFileResDto>>() {
        });
    }

    @Override
    public Result<Boolean> deleteFile(DecisionFlowFileIdReqDto dto) throws BaseException {

        DecisionFileOwnerResDto fileOwnerResDto = HttpUtils.get(AmUrl.GET_FLOW_FILE_OWNER, ArgsUtils.toIdMap(dto.getId(), "fileId"), new BaseTypeReference<Result<DecisionFileOwnerResDto>>() {
        }).getResult();
        projectPermissionService.checkEditAndThrow(fileOwnerResDto.getProjectId());
        return HttpUtils.post(AmUrl.DELETE_DECISION_FLOW_FILE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Boolean>>() {
        });
    }

    @Override
    public Result<Long> updateRemark(DecisionFlowRemarkReqDto dto) throws BaseException {
        decisionFlowPermissionService.checkEditAndThrow(dto.getFlowId());
        return HttpUtils.post(AmUrl.UPDATE_DECISION_FLOW_REMARK, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }
}
