package com.yundao.tenant.web.service.am.project.impl;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.UpdateOnlyReqDto;
import com.yundao.tenant.web.dto.common.DataAndPermissionDto;
import com.yundao.tenant.web.dto.common.DataPermissionDto;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.common.PermissionUrlDto;
import com.yundao.tenant.web.dto.permission.PermissionDetailResDto;
import com.yundao.tenant.web.dto.permission.PermissionListResDto;
import com.yundao.tenant.web.dto.permission.PermissionMultiCodeDto;
import com.yundao.tenant.web.dto.project.*;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.service.am.project.ProjectPermissionService;
import com.yundao.tenant.web.service.am.project.ProjectService;
import com.yundao.tenant.web.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目服务实现
 *
 * @author jan
 * @create 2017-11-17 17:09
 **/
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private ProjectPermissionService projectPermissionService;

    @Override
    public Result<DataAndPermissionDto<ProjectDetailResDto>> get(ProjectIdReqDto dto) throws BaseException {

        DataAndPermissionDto<ProjectDetailResDto> result = new DataAndPermissionDto<>();
        DataPermissionDto permissionDto = new DataPermissionDto();
        permissionDto.setDataObjectCode(DataObjectEnum.PROJECT.getCode());

        Result<ProjectDetailResDto> projectResult = HttpUtils.get(AmUrl.GET_PROJECT, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<ProjectDetailResDto>>() {
                });
        if (!projectResult.getSuccess())
            throw new BaseException(projectResult.getCode(), projectResult.getMessage());

        if (null == projectResult.getResult()) {
            permissionDto.setEditPermission(false);
            permissionDto.setReadPermission(false);
            permissionDto.setDeletePermission(false);
            result.setPermission(permissionDto);
            return Result.newSuccessResult(result);
        }

        ProjectDetailResDto project = projectResult.getResult();

        List<Long> userIds = new ArrayList<>();
        if (project.getLeaderId() != null)
            userIds.add(project.getLeaderId());
        if (BooleanUtils.isNotBlank(project.getCrewIds())) {
            List<Long> crewIds = SymbolUtils.toLongWithTypeCheck(project.getCrewIds());
            if (BooleanUtils.isNotEmpty(crewIds))
                userIds.addAll(crewIds);
        }

        List<PermissionMultiCodeDto> reqDtos = new ArrayList<>();
        reqDtos.add(new PermissionMultiCodeDto(DataObjectEnum.PROJECT.getCode(), userIds));
        List<DataPermissionDto> dps = permissionService.checkRead(reqDtos).getResult();
        DataPermissionDto dp = dps.get(0);
        if (!dp.getReadPermission())
            result.setData(null);
        else
            result.setData(project);
        result.setPermission(dp);
        return Result.newSuccessResult(result);
    }

    @Override
    public Result<PaginationSupport<ProjectPageResDto>> getPage(ProjectPageReqDto dto) throws BaseException {
        Integer permission = permissionService.getRead(DataObjectEnum.PROJECT.getCode()).getResult();
        PermissionUrlDto urlDto = new PermissionUrlDto();
        urlDto.setPersonalUrl(AmUrl.GET_PROJECT_PAGE_PERSONAL);
        urlDto.setDepartmentUrl(AmUrl.GET_PROJECT_PAGE_DEPARTMENT);
        urlDto.setPublicUrl(AmUrl.GET_PROJECT_PAGE_PUBLIC);
        String url = urlDto.getPermissionUrl(permission);
        // 没有对应的url，表示没有权限，直接返回
        if (BooleanUtils.isEmpty(url))
            return Result.newSuccessResult(new PaginationSupport<ProjectPageResDto>());

        return HttpUtils.get(url, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<PaginationSupport<ProjectPageResDto>>>() {
                });

    }

    @Override
    public Result<Long> updateOnly(UpdateOnlyReqDto dto) throws BaseException {
        boolean isAuth = projectPermissionService.checkEdit(dto.getId());
        if(!isAuth){
            throw new BaseException(CodeConstant.CODE_1220016);
        }
            return HttpUtils.post(AmUrl.PROJECT_UPDATE_ONLY, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Long>>() {
        });
    }

    @Override
    public Result<PermissionResultDto> delete(ProjectIdsReqDto dto) throws BaseException {
        Result<List<ProjectOwnerIdResDto>> ownerIdsResult = HttpUtils.get(AmUrl.GET_PROJECT_OWNER_IDS, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<List<ProjectOwnerIdResDto>>>() {
                });

        if (!ownerIdsResult.getSuccess()) {
            throw new BaseException(ownerIdsResult.getCode(), ownerIdsResult.getMessage());
        }

        List<ProjectOwnerIdResDto> owners = ownerIdsResult.getResult();
        List<Long> userIds = new ArrayList<>();
        for (ProjectOwnerIdResDto owner : owners) {
            if (owner.getLeaderId() != null)
                userIds.add(owner.getLeaderId());
            if (BooleanUtils.isNotBlank(owner.getCrewIds()))
                userIds.addAll(SymbolUtils.toLong(owner.getCrewIds()));
        }
        PermissionListResDto permissionListResDto = permissionService.checkDeleteListSingleObj(DataObjectEnum.PROJECT.getCode(), LambdaFilter.distinct(userIds));
        //过滤出有权限的
        List<PermissionDetailResDto> permissions = LambdaFilter.toList(permissionListResDto.getPermissions(), m -> m.getIsPass());
        List<Long> permissionUserIds = new ArrayList<>();
        if (BooleanUtils.isNotEmpty(permissions))
            permissionUserIds = LambdaMap.toSingleList(permissions, PermissionDetailResDto::getOwnerId);
        List<Long> noPermissionProjectIds = new ArrayList<>();

        for (ProjectOwnerIdResDto owner : owners) {
            if (owner.getLeaderId() != null) {
                if (permissionUserIds.contains(owner.getLeaderId()))
                    continue;
            }
            if (BooleanUtils.isNotBlank(owner.getCrewIds())) {
                List<Long> crewIds = SymbolUtils.toLong(owner.getCrewIds());
                if (this.existInclude(permissionUserIds, crewIds))
                    continue;
            }
            noPermissionProjectIds.add(owner.getId());
        }

        ProjectDeleteReqDto reqDto = new ProjectDeleteReqDto();
        reqDto.setIds(dto.getIds());
        reqDto.setNoPermissionProjectIds(SymbolUtils.longToStr(noPermissionProjectIds));
        return HttpUtils.post(AmUrl.DELETE_PROJECT, ArgsUtils.toMap(reqDto), new
                BaseTypeReference<Result<PermissionResultDto>>() {
                });

    }

    @Override
    public Result<Integer> updateMultiple(List<UpdateOnlyReqDto> dtos) throws BaseException {
        for (UpdateOnlyReqDto dto : dtos) {
            updateOnly(dto);
        }
        return Result.newSuccessResult(CommonConstant.ONE);
    }

    @Override
    public Result<PaginationSupport<ProjectSelectResDto>> getSelect() {
        return null;
    }

    private Boolean existInclude(List<Long> permissionUserIds, List<Long> crewIds) {
        for (Long crewId : crewIds) {
            if (permissionUserIds.contains(crewId))
                return true;
        }
        return false;
    }
}
