package com.yundao.tenant.web.service.am.project.decision.suggestion.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.project.decision.suggestion.*;
import com.yundao.tenant.web.service.am.project.DecisionPermissionService;
import com.yundao.tenant.web.service.am.project.decision.suggestion.DecisionSuggestionService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author jan
 * @create 2017-11-20 21:31
 **/
@Service
public class DecisionSuggestionServiceImpl implements DecisionSuggestionService {

    @Autowired
    private DecisionPermissionService decisionPermissionService;

    @Override
    public Result<DecisionSuggestionListResDto> gets(DecisionSuggestionListReqDto dto) throws BaseException {
        boolean isPermission = decisionPermissionService.checkRead(dto.getDecisionId());
        if (!isPermission) {
            DecisionSuggestionListResDto noPermDto = new DecisionSuggestionListResDto();
            noPermDto.setCanDelete(false);
            noPermDto.setCanEdit(false);
            noPermDto.setSuggestions(new ArrayList<>());
            return Result.newSuccessResult(noPermDto);
        }
        return HttpUtils.get(AmUrl.GETS_DECISION_SUGGESTION, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<DecisionSuggestionListResDto>>() {
                });
    }

    @Override
    public Result<Long> insert(DecisionSuggestionAddReqDto dto) throws BaseException {
        decisionPermissionService.checkEditAndThrow(dto.getDecisionId());
        return HttpUtils.post(AmUrl.ADD_DECISION_SUGGESTION, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @Override
    public Result<Long> update(DecisionSuggestionUpdateReqDto dto) throws BaseException {
        return HttpUtils.post(AmUrl.UPDATE_DECISION_SUGGESTION, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<Long>>() {
                });
    }

    @Override
    public Result<PermissionResultDto> delete(DecisionSuggestionDelReqDto dto) throws BaseException {
        return HttpUtils.post(AmUrl.DELETE_DECISION_SUGGESTION, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<PermissionResultDto>>() {
                });
    }
}
