package com.yundao.tenant.web.service.am.project.decision.flow;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.web.dto.project.decision.flow.DecisionFlowFileIdReqDto;
import com.yundao.tenant.web.dto.project.decision.flow.DecisionFlowFileReqDto;
import com.yundao.tenant.web.dto.project.decision.flow.DecisionFlowRemarkReqDto;
import com.yundao.tenant.web.dto.project.file.DecisionFlowFileResDto;

/**
 * 立项流程服务接口
 *
 * @author jan
 * @create 2017-11-22 15:48
 **/
public interface DecisionFlowService {

    Result<DecisionFlowFileResDto> addFile(DecisionFlowFileReqDto dto) throws BaseException;

    Result<Boolean> deleteFile(DecisionFlowFileIdReqDto dto) throws BaseException;

    Result<Long> updateRemark(DecisionFlowRemarkReqDto dto) throws BaseException;
}
