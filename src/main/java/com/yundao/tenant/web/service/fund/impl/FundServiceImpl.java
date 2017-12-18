package com.yundao.tenant.web.service.fund.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.web.constant.url.AmUrl;
import com.yundao.tenant.web.dto.common.DataPermissionDto;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.common.PermissionUrlDto;
import com.yundao.tenant.web.dto.field.FieldDetailDto;
import com.yundao.tenant.web.dto.fund.*;
import com.yundao.tenant.web.dto.permission.PermissionDetailResDto;
import com.yundao.tenant.web.dto.permission.PermissionListResDto;
import com.yundao.tenant.web.dto.permission.PermissionMultiCodeDto;
import com.yundao.tenant.web.dto.product.field.FieldConfigDto;
import com.yundao.tenant.web.dto.project.ProjectDeleteReqDto;
import com.yundao.tenant.web.dto.project.fund.BaseFund;
import com.yundao.tenant.web.dto.project.fund.FundDetailDto;
import com.yundao.tenant.web.dto.project.fund.FundFieldDto;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.service.fund.FundService;
import com.yundao.tenant.web.util.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基金服务实现
 *
 * @author jan
 * @create 2017-11-23 21:40
 **/
@Service
public class FundServiceImpl implements FundService {

    @Autowired
    private PermissionService permissionService;

    @Override
    public Result<PaginationSupport<FundPageResDto>> getPage(FundPageReqDto dto) throws BaseException {
        Integer permission = permissionService.getRead(DataObjectEnum.FUND.getCode()).getResult();
        PermissionUrlDto urlDto = new PermissionUrlDto();
        urlDto.setPersonalUrl(AmUrl.GET_FUND_PAGE_PERSONAL);
        urlDto.setDepartmentUrl(AmUrl.GET_FUND_PAGE_DEPARTMENT);
        urlDto.setPublicUrl(AmUrl.GET_FUND_PAGE_PUBLIC);
        String url = urlDto.getPermissionUrl(permission);
        // 没有对应的url，表示没有权限，直接返回
        if (BooleanUtils.isEmpty(url))
            return Result.newSuccessResult(new PaginationSupport<FundPageResDto>());

        return HttpUtils.get(url, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<PaginationSupport<FundPageResDto>>>() {
                });
    }

    @Override
    public Result<PermissionResultDto> delete(FundIdsReqDto dto) throws BaseException {
        Result<List<FundOwnerIdResDto>> ownerIdsResult = HttpUtils.get(AmUrl.GET_FUND_OWNER_IDS, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<List<FundOwnerIdResDto>>>() {
                });

        if (!ownerIdsResult.getSuccess()) {
            throw new BaseException(ownerIdsResult.getCode(), ownerIdsResult.getMessage());
        }

        List<FundOwnerIdResDto> owners = ownerIdsResult.getResult();
        List<Long> ownerIds = LambdaMap.toSingleList(owners, FundOwnerIdResDto::getOwnerId);
        PermissionListResDto permissionListResDto = permissionService.checkDeleteListSingleObj(DataObjectEnum.FUND.getCode(), LambdaFilter.distinct(ownerIds));

        List<PermissionDetailResDto> permissions = permissionListResDto.getPermissions();

        List<Long> noPermissionProjectIds = new ArrayList<>();

        for (FundOwnerIdResDto owner : owners) {
            if (owner.getOwnerId() != null) {
                PermissionDetailResDto p = LambdaFilter.firstOrDefault(permissions, m -> owner.getOwnerId().equals(m.getOwnerId()));
                if (p != null && p.getIsPass())
                    continue;
            }
            noPermissionProjectIds.add(owner.getId());
        }

        ProjectDeleteReqDto reqDto = new ProjectDeleteReqDto();
        reqDto.setIds(dto.getIds());
        reqDto.setNoPermissionProjectIds(SymbolUtils.longToStr(noPermissionProjectIds));
        return HttpUtils.post(AmUrl.DELETE_FUND, ArgsUtils.toMap(reqDto), new
                BaseTypeReference<Result<PermissionResultDto>>() {
                });
    }


    /**
     * 查询产品详情
     */
    @Override
    public Result<FundDataDetailDto> getFundDetailDto(Long id) throws BaseException {
        Map<String, Object> mapParmas = new HashMap<String, Object>();
        mapParmas.put("id", id);

        Result<FundDetailDto> result = HttpUtils.get(AmUrl.GET_DETAIL, mapParmas, new BaseTypeReference<Result<FundDetailDto>>() {
        });

        if (!result.getSuccess()) {
            return Result.newFailureResult(result.getCode(), result.getMessage(), null);
        }

        List<PermissionMultiCodeDto> permissionMultiCodeDtos = getPermissionMultiCodeDtos(getReceiver(result.getResult()));
        Result<List<DataPermissionDto>> permissionResult = permissionService.checkRead(permissionMultiCodeDtos);
        if (!permissionResult.getSuccess()) {
            return Result.newFailureResult(permissionResult.getCode(), permissionResult.getMessage(), null);
        }

        FundDataDetailDto dataDetailDto = getFundDataDetailDto(permissionResult.getResult(), result.getResult());

        return Result.newSuccessResult(dataDetailDto);
    }


    /**
     * 检查修改权限
     *
     * @param id
     * @return
     * @throws BaseException
     */
    public Boolean updatePermission(Long id, String dataObjectCode) throws BaseException {
        List<Long> ownerIds = getReceiver(id);
        if (BooleanUtils.isEmpty(ownerIds)) {
            Boolean isPass = permissionService.checkUpdate(dataObjectCode, null).getResult();
            return isPass;
        }
        for (Long ownerId : ownerIds) {
            Boolean isPass = permissionService.checkUpdate(dataObjectCode, ownerId).getResult();
            if (isPass) {
                return isPass;
            }
        }
        return false;
    }


    public Boolean readPermission(Long id, String dataObjectCode) throws BaseException {
        List<Long> ownerIds = getReceiver(id);
        if (BooleanUtils.isEmpty(ownerIds)) {
            Boolean isPass = permissionService.checkRead(dataObjectCode, null).getResult();
            return isPass;
        }
        for (Long ownerId : ownerIds) {
            Boolean isPass = permissionService.checkRead(dataObjectCode, ownerId).getResult();
            if (isPass) {
                return isPass;
            }
        }
        return false;
    }

    @Override
    public Result<List<FundSelectionDto>> getSelection(FundSelectReqDto dto) throws Exception {

        Integer permission = permissionService.getRead(DataObjectEnum.FUND.getCode()).getResult();
        PermissionUrlDto urlDto = new PermissionUrlDto();
        urlDto.setPersonalUrl(AmUrl.GET_FUND_SELECTION_PERSONAL);
        urlDto.setDepartmentUrl(AmUrl.GET_FUND_SELECTION_DEPARTMENT);
        urlDto.setPublicUrl(AmUrl.GET_FUND_SELECTION_PUBLIC);
        String url = urlDto.getPermissionUrl(permission);

        // 没有对应的url，表示没有权限，直接返回
        if (BooleanUtils.isEmpty(url))
            return Result.newSuccessResult(new ArrayList<>());

        Result<List<FundSelectionDto>> result = HttpUtils.get(url, ArgsUtils.toMap(dto), new
                BaseTypeReference<Result<List<FundSelectionDto>>>() {
                });

        if (!result.getSuccess())
            return result;
        List<FundSelectionDto> dtos = result.getResult();
        if (BooleanUtils.isEmpty(dtos))
            return result;

        PermissionListResDto permissionListResDto = permissionService.checkUpdateListSingleObj(DataObjectEnum.FUND.getCode(), LambdaMap.toSingleList(dtos, FundSelectionDto::getReceiverId));

        List<PermissionDetailResDto> permissions = permissionListResDto.getPermissions();

        for (FundSelectionDto fundSelectionDto : dtos) {
            PermissionDetailResDto pdr;
            if (fundSelectionDto.getReceiverId() != null)
                pdr = LambdaFilter.firstOrDefault(permissions, m -> fundSelectionDto.getReceiverId().equals(m.getOwnerId()));
            else
                pdr = LambdaFilter.firstOrDefault(permissions, m -> m.getOwnerId() == null);
            fundSelectionDto.setEditPermission(pdr.getIsPass());
        }

        return result;
    }


    /**
     * 转换数据
     *
     * @param dtos
     * @param productDetailDto
     * @return
     */
    private FundDataDetailDto getFundDataDetailDto(List<DataPermissionDto> dtos, FundDetailDto fundDetailDto) {
        FundDataDetailDto dataDetailDto = new FundDataDetailDto();
        BeanUtils.copyProperties(fundDetailDto, dataDetailDto);
        dataDetailDto.setAttachDtos(fundDetailDto.getAttachDtos());
        dataDetailDto.setIncomeDtos(fundDetailDto.getIncomeDtos());

        //产品基本信息和销售信息
        FundBaseDto fundDto = new FundBaseDto();
        FundFieldDto data = new FundFieldDto();
        data.setFundFieldDtos(fundDetailDto.getFundFieldDtos());
        data.setFundRaiseFieldDtos(fundDetailDto.getFundRaiseFieldDtos());
        fundDto.setData(data);
        fundDto.setPermission(getPermissionMultiCodeDto(dtos, DataObjectEnum.FUND.getCode()));
        if (fundDto.getPermission() != null && fundDto.getPermission().getReadPermission()) {
            dataDetailDto.setFundDto(fundDto);
        }

        return dataDetailDto;
    }


    /**
     * 获取数据权限
     *
     * @param dataObjectCode
     * @return
     */
    private DataPermissionDto getPermissionMultiCodeDto(List<DataPermissionDto> dtos, String dataObjectCode) {
        if (BooleanUtils.isEmpty(dtos)) {
            return null;
        }
        for (DataPermissionDto dto : dtos) {
            if (dataObjectCode.equals(dto.getDataObjectCode())) {
                return dto;
            }
        }
        return null;
    }


    /**
     * 获取权限集合
     *
     * @param userId
     * @return
     */
    private List<PermissionMultiCodeDto> getPermissionMultiCodeDtos(List<Long> ownerIds) {
        List<PermissionMultiCodeDto> dtos = new ArrayList<PermissionMultiCodeDto>();
        PermissionMultiCodeDto baseInfo = new PermissionMultiCodeDto();
        baseInfo.setDataObjectCode(DataObjectEnum.FUND.getCode());
        baseInfo.setOwnerIds(ownerIds);

        dtos.add(baseInfo);
        return dtos;
    }

    /**
     * 查询对接人和助理
     *
     * @param dto
     * @return
     */
    private List<Long> getReceiver(FundDetailDto dto) {
        if (dto == null || BooleanUtils.isEmpty(dto.getFundFieldDtos())) {
            return null;
        }
        List<Long> ids = new ArrayList<Long>();
        for (FieldDetailDto fieldDetailDto : dto.getFundFieldDtos()) {
            if ("receiverId".equals(fieldDetailDto.getName())) {
                FieldConfigDto fieldConfig = fieldDetailDto.getFieldConfigDto();
                if (fieldConfig != null && !BooleanUtils.isBlank(fieldConfig.getInitValue())) {
                    String initValue = fieldConfig.getInitValue();
                    Long id = Long.parseLong(initValue);
                    ids.add(id);
                }

            }
        }
        return ids;
    }


    private List<Long> getReceiver(Long id) throws BaseException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        Result<BaseFund> result = HttpUtils.get(AmUrl.GET_FUND_BASE, map, new BaseTypeReference<Result<BaseFund>>() {
        });
        if (!result.getSuccess()) {
            throw new BaseException(result.getCode(), result.getMessage());
        }
        BaseFund base = result.getResult();
        List<Long> ownerIds = new ArrayList<Long>();
        if (base.getReceiverId() != null) {
            if (base.getReceiverId() != null && !ownerIds.contains(base.getReceiverId())) {
                ownerIds.add(base.getReceiverId());
            }
        }
        return ownerIds;
    }

}
