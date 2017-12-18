package com.yundao.tenant.web.service.fund;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.fund.*;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/**
 * 基金服务接口
 *
 * @author jan
 * @create 2017-11-23 21:38
 **/
public interface FundService {

    Result<PaginationSupport<FundPageResDto>> getPage(FundPageReqDto dto) throws BaseException;

    Result<PermissionResultDto> delete(FundIdsReqDto dto) throws BaseException;

    /**
     * 查询客户详情
     * getFundDetailDto:
     * @author: 欧阳利
     * @param id
     * @return
     * @throws BaseException
     * @description:
     */
    public Result<FundDataDetailDto> getFundDetailDto(Long id) throws BaseException;
    
    
    public Boolean updatePermission(Long id ,String dataObjectCode)throws BaseException;
    
    public Boolean readPermission(Long id ,String dataObjectCode)throws BaseException;

    Result<List<FundSelectionDto>> getSelection(@ModelAttribute FundSelectReqDto dto) throws Exception;
}
