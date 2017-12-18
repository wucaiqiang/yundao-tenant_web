package com.yundao.tenant.web.service.am.project;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.UpdateOnlyReqDto;
import com.yundao.tenant.web.dto.common.DataAndPermissionDto;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.project.*;

import java.util.List;

/**
 * 项目服务接口
 *
 * @author jan
 * @create 2017-11-17 17:06
 **/
public interface ProjectService {

    Result<DataAndPermissionDto<ProjectDetailResDto>> get(ProjectIdReqDto dto) throws BaseException;

    Result<PaginationSupport<ProjectPageResDto>> getPage(ProjectPageReqDto dto) throws BaseException;

    Result<Long> updateOnly(UpdateOnlyReqDto dto) throws BaseException;

    Result<PermissionResultDto> delete(ProjectIdsReqDto dto) throws BaseException;

    Result<Integer> updateMultiple(List<UpdateOnlyReqDto> dtos) throws BaseException;

    Result<PaginationSupport<ProjectSelectResDto>> getSelect();
}
