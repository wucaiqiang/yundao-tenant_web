package com.yundao.tenant.web.service.am.project.decision.suggestion;


import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.project.decision.DecisionIdReqDto;
import com.yundao.tenant.web.dto.project.decision.suggestion.*;

/**
 * 立项意见服务接口
 *
 * @author jan
 * @create 2017-11-20 19:48
 **/
public interface DecisionSuggestionService {

    /**
     * 获取列表
     */
    Result<DecisionSuggestionListResDto> gets(DecisionSuggestionListReqDto dto) throws BaseException;

    /**
     * 添加
     */
    Result<Long> insert(DecisionSuggestionAddReqDto dto) throws BaseException;

    /**
     * 编辑
     */
    Result<Long> update(DecisionSuggestionUpdateReqDto dto) throws BaseException;

    /**
     * 删除
     */
    Result<PermissionResultDto> delete(DecisionSuggestionDelReqDto dto) throws BaseException;

}
