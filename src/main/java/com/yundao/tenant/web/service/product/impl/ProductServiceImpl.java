package com.yundao.tenant.web.service.product.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.common.BaseObjectDto;
import com.yundao.tenant.web.dto.common.DataPermissionDto;
import com.yundao.tenant.web.dto.common.FailListDto;
import com.yundao.tenant.web.dto.common.PassListDto;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.field.FieldDetailDto;
import com.yundao.tenant.web.dto.permission.PermissionMultiCodeDto;
import com.yundao.tenant.web.dto.product.BaseProduct;
import com.yundao.tenant.web.dto.product.ProductActionSelectDto;
import com.yundao.tenant.web.dto.product.ProductBaseUpdateReqDto;
import com.yundao.tenant.web.dto.product.ProductManagerListReqDto;
import com.yundao.tenant.web.dto.product.ProductManagerListResDto;
import com.yundao.tenant.web.dto.product.detail.ProductBaseDto;
import com.yundao.tenant.web.dto.product.detail.ProductCommissionDto;
import com.yundao.tenant.web.dto.product.detail.ProductDataDetailDto;
import com.yundao.tenant.web.dto.product.detail.ProductDetailDto;
import com.yundao.tenant.web.dto.product.detail.ProductFieldDto;
import com.yundao.tenant.web.dto.product.detail.ProductSupplierDto;
import com.yundao.tenant.web.dto.product.field.FieldConfigDto;
import com.yundao.tenant.web.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.service.product.ProductService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import com.yundao.tenant.web.util.SymbolUtils;

/**
 * 产品服务实现类
 *
 * @author jan
 * @create 2017-07-31 PM9:02
 **/
@Service
public class ProductServiceImpl extends AbstractService implements ProductService {

    @Autowired
    private PermissionService permissionService;

    
	/**
	 * 产品管理查询
	 * getManagerList:
	 * @author: 欧阳利
	 * @param reqDto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<PaginationSupport<ProductManagerListResDto>> getManagerList(ProductManagerListReqDto reqDto) throws BaseException{
		Result<PaginationSupport<ProductManagerListResDto>> result =  HttpUtils.get(TenantUrl.PRODUCT_GET_MANAGER_LIST, ArgsUtils.toMap(reqDto), 
				new BaseTypeReference<Result<PaginationSupport<ProductManagerListResDto>>>() {});
		
		if(result.getSuccess() && result.getResult() != null && !BooleanUtils.isEmpty(result.getResult().getDatas())){
			List<ProductManagerListResDto> datas = result.getResult().getDatas();
			List<BaseObjectDto> baseObjets = getUpdateBaseObjectDtos(datas);
			
			// 
			Integer permission = permissionService.getUpdate(DataObjectEnum.PRODUCT.getCode()).getResult();
			List<FailListDto> failListDtos = null;
			if(!(DataObjectPermissionEnum.NONE.getValue() == permission || DataObjectPermissionEnum.PUBLIC.getValue() == permission)){
				Result<PermissionResultDto> permissionResult = permissionService.checkUpdateListForOwnerIds(baseObjets, DataObjectEnum.PRODUCT.getCode());
				PermissionResultDto permissionResultDto = permissionResult.getResult();
				failListDtos =  permissionResultDto.getFailList();
			}

			for(ProductManagerListResDto productDto : datas){
				// 审核状态， 0：未提交  1：审核中  2：已通过  3：已驳回  4： 已撤销
				// 审核中和已驳回才对发起人
				if(productDto.getExamineStatus() != null && (productDto.getExamineStatus() == 3  || productDto.getExamineStatus() == 1)){
					if(!(productDto.getApplyUserId() != null && productDto.getApplyUserId().equals(this.getHeaderUserId())) ){
						if(productDto.getActionDto().getSelectDtos() != null){
							setNotCanAction(productDto.getActionDto().getSelectDtos(),"审批进行中，仅限申请发起人可执行此操作");
						}
						
					}
					continue;
				}
				
				if(DataObjectPermissionEnum.NONE.getValue() == permission){
					if(productDto.getActionDto().getSelectDtos() != null){
						setNotCanAction(productDto.getActionDto().getSelectDtos(),"您无操作产品的权限");
					}
					continue;
				}
				
				if(DataObjectPermissionEnum.PUBLIC.getValue() == permission){
					continue;
				}
				
				
				// 数据权限控制
				if(BooleanUtils.isEmpty(failListDtos)){
					continue;
				}
				for(FailListDto failListDto : failListDtos){
					if(productDto.getId().equals(failListDto.getId())){
						if(productDto.getActionDto().getSelectDtos() != null){
							if(DataObjectPermissionEnum.PERSONAL.getValue() == permission){
								setNotCanAction(productDto.getActionDto().getSelectDtos(),"您的权限仅限于操作您对接或助理的产品");
							}else if(DataObjectPermissionEnum.DEPARTMENT.getValue() == permission){
								setNotCanAction(productDto.getActionDto().getSelectDtos(),"您的权限仅限于操作您部门员工对接或助理的产品");
							}else{
								setNotCanAction(productDto.getActionDto().getSelectDtos(),"无权限操作");
							}
						}
					}
				}
				
			}
		
		}
		
		return result;
	}
    
	
	private void setNotCanAction(List<ProductActionSelectDto> actionDto,String title ){
		if(!BooleanUtils.isEmpty(actionDto)){
			for(ProductActionSelectDto dto : actionDto){
				dto.setCanAction(false);
				dto.setTitle(title);
			}
		}
	}
    
    
    @Override
    public Result<PermissionResultDto> delete(String ids) throws BaseException {
        // 获取产品基本信息集合
		List<BaseProduct> baseProducts = this.getByIds(ids);
		List<BaseObjectDto> baseObjets = getBaseObjectDtos(baseProducts);

		Result<PermissionResultDto> permissionResult = permissionService.checkDeleteListForOwnerIds(baseObjets,
				DataObjectEnum.PRODUCT.getCode());
		if (!permissionResult.getSuccess() || permissionResult.getResult() == null
				|| BooleanUtils.isEmpty(permissionResult.getResult().getPassList())) {
			return permissionResult;
		}

		List<Long> successIds = new ArrayList<Long>();
		for (PassListDto pass : permissionResult.getResult().getPassList()) {
			successIds.add(pass.getId());
		}

		Result<PermissionResultDto> deleteResult = HttpUtils.post(TenantUrl.DELETE_PRODUCT,
				ArgsUtils.toIdMap(SymbolUtils.longToStr(successIds), "ids"),
				new BaseTypeReference<Result<PermissionResultDto>>() {
				});

		if (!deleteResult.getSuccess()) {
			return deleteResult;
		}

		List<FailListDto> failList = permissionResult.getResult().getFailList();
		List<FailListDto> deleteFailList = deleteResult.getResult().getFailList();
		if (!BooleanUtils.isEmpty(failList)) {
			if (deleteFailList == null) {
				deleteResult.getResult().setFailList(failList);
			}
			else {
				deleteResult.getResult().getFailList().addAll(failList);
			}

		}

		return deleteResult;
    }

    private List<BaseObjectDto> getUpdateBaseObjectDtos(List<ProductManagerListResDto> baseProducts){
    	if(BooleanUtils.isEmpty(baseProducts)){
    		return null;
    	}
    	 List<BaseObjectDto> baseObjets = new ArrayList<BaseObjectDto>();
    	for(ProductManagerListResDto base:baseProducts){
    		BaseObjectDto baseObjet = new BaseObjectDto();
    		BeanUtils.copyProperties(base, baseObjet);
    		List<Long> ownerIds = new ArrayList<Long>();
    		if(base.getAssistantId() != null || base.getReceiverId() != null){
    			if(base.getAssistantId() != null){
    				ownerIds.add(base.getAssistantId());
    			}
    			if(base.getReceiverId() != null){
    				ownerIds.add(base.getReceiverId());
    			}
    		}
    		
			if(BooleanUtils.isEmpty(ownerIds)){
				ownerIds.add(-1l);
			}
			baseObjet.setOwnerIds(ownerIds);
    		baseObjets.add(baseObjet);
    	}
    	return baseObjets;
    }
    
    private List<BaseObjectDto> getBaseObjectDtos(List<BaseProduct> baseProducts){
    	if(BooleanUtils.isEmpty(baseProducts)){
    		return null;
    	}
    	 List<BaseObjectDto> baseObjets = new ArrayList<BaseObjectDto>();
    	for(BaseProduct base:baseProducts){
    		BaseObjectDto baseObjet = new BaseObjectDto();
    		BeanUtils.copyProperties(base, baseObjet);
			List<Long> ownerIds = new ArrayList<Long>();
    		if(base.getAssistantId() != null || base.getReceiverId() != null){
    			if(base.getAssistantId() != null){
    				ownerIds.add(base.getAssistantId());
    			}
    			if(base.getReceiverId() != null ){
    				ownerIds.add(base.getReceiverId());
    			}
    		}
    		
			if(BooleanUtils.isEmpty(ownerIds)){
				ownerIds.add(-1l);
			}
			baseObjet.setOwnerIds(ownerIds);
    		baseObjets.add(baseObjet);
    	}
    	return baseObjets;
    }
    
    
    
	@Override
	public Result<Integer> update(ProductBaseUpdateReqDto dto, Map<String, Object> paramMap) throws BaseException {
		// 修改产品基本信息
		return HttpUtils.post(TenantUrl.UPDATE_PRODUCT_BASE, paramMap, new BaseTypeReference<Result<Integer>>() {
		});
	}

	/**
	 * 查询产品详情
	 */
    @Override
    public Result<ProductDataDetailDto> getProductDetailDto(Long id) throws BaseException {
        Map<String, Object> mapParmas = new HashMap<String, Object>();
        mapParmas.put("id", id);
        
        Result<ProductDetailDto> result = HttpUtils.get(TenantUrl.GET_PRODUCT_DETAIL_BY_ID, mapParmas, new BaseTypeReference<Result<ProductDetailDto>>() {
        });
        
        if(!result.getSuccess()){
        	return Result.newFailureResult(result.getCode(), result.getMessage(),null);
        }
        
        List<PermissionMultiCodeDto> permissionMultiCodeDtos = getPermissionMultiCodeDtos(getReceiverAndAssistantId(result.getResult()));
        Result<List<DataPermissionDto>> permissionResult =  permissionService.checkRead(permissionMultiCodeDtos);
        if(!permissionResult.getSuccess()){
        	return Result.newFailureResult(permissionResult.getCode(), permissionResult.getMessage(),null);
        }
        
        ProductDataDetailDto dataDetailDto =  getProductDataDetailDto(permissionResult.getResult(), result.getResult());
        
        return Result.newSuccessResult(dataDetailDto);
    }

    /**
     * 查询对接人和助理
     * @param dto
     * @return
     */
    private List<Long> getReceiverAndAssistantId(ProductDetailDto dto){
    	if(dto == null ||  BooleanUtils.isEmpty(dto.getProductFieldDtos())){
    		return null;
    	}
    	List<Long> ids = new ArrayList<Long>();
    	for(FieldDetailDto fieldDetailDto:dto.getProductFieldDtos()){
    		if("assistantId".equals(fieldDetailDto.getName()) || "receiverId".equals(fieldDetailDto.getName())){
    			FieldConfigDto fieldConfig = fieldDetailDto.getFieldConfigDto();
    			if(fieldConfig != null && !BooleanUtils.isBlank(fieldConfig.getInitValue())){
    				String initValue = fieldConfig.getInitValue();
    				Long id = Long.parseLong(initValue);
    				ids.add(id);
    			}
    			
    		}
    	}
    	return  ids;
    }
    
    
    /**
     * 转换数据
     * @param dtos
     * @param productDetailDto
     * @return
     */
    private ProductDataDetailDto getProductDataDetailDto(List<DataPermissionDto> dtos,ProductDetailDto productDetailDto){
    	ProductDataDetailDto dataDetailDto = new ProductDataDetailDto();
    	BeanUtils.copyProperties(productDetailDto, dataDetailDto);
    	dataDetailDto.setAttachDtos(productDetailDto.getAttachDtos());
    	dataDetailDto.setIncomeDtos(productDetailDto.getIncomeDtos());
    	
    	//产品基本信息和销售信息
    	 ProductBaseDto productDto = new ProductBaseDto();
    	 ProductFieldDto data = new ProductFieldDto();
    	 data.setProductFieldDtos(productDetailDto.getProductFieldDtos());
    	 data.setProductSaleFieldDtos(productDetailDto.getProductSaleFieldDtos());
    	 productDto.setData(data);
    	 productDto.setPermission(getPermissionMultiCodeDto(dtos,DataObjectEnum.PRODUCT.getCode()));
    	 if(productDto.getPermission() != null && productDto.getPermission().getReadPermission()){
    		 dataDetailDto.setProductDto(productDto);
    	 }
    	
    	// 佣金
    	ProductCommissionDto commissionDto = new ProductCommissionDto();
    	dataDetailDto.setCommissionDto(commissionDto);
    	commissionDto.setPermission(getPermissionMultiCodeDto(dtos,DataObjectEnum.COMMISSION.getCode()));
    	if(commissionDto.getPermission() != null && commissionDto.getPermission().getReadPermission()){
    		commissionDto.setData(productDetailDto.getCommissionDtos());
    	}
    	
    	// 供应商报价
    	ProductSupplierDto supplierDto = new ProductSupplierDto();
    	dataDetailDto.setSupplierDto(supplierDto);
    	supplierDto.setPermission(getPermissionMultiCodeDto(dtos,DataObjectEnum.SUPPLIER.getCode()));
    	if(supplierDto.getPermission() != null && supplierDto.getPermission().getReadPermission()){
    		supplierDto.setData(productDetailDto.getSupplierDtos());
    	}
    	
    	return dataDetailDto;
    }
    
    /**
     * 获取数据权限
     * @param dataObjectCode
     * @return
     */
    private DataPermissionDto getPermissionMultiCodeDto(List<DataPermissionDto> dtos, String dataObjectCode){
    	if(BooleanUtils.isEmpty(dtos)){
    		return null;
    	}
    	for(DataPermissionDto dto : dtos){
    		if(dataObjectCode.equals(dto.getDataObjectCode())){
    			return dto;
    		}
    	}
    	return null;
    }
    
    
    /**
     * 获取权限集合
     * @param userId
     * @return
     */
    private List<PermissionMultiCodeDto> getPermissionMultiCodeDtos(List<Long> ownerIds){
        List<PermissionMultiCodeDto> dtos = new ArrayList<PermissionMultiCodeDto>();
        PermissionMultiCodeDto baseInfo = new PermissionMultiCodeDto();
        baseInfo.setDataObjectCode(DataObjectEnum.PRODUCT.getCode());
        baseInfo.setOwnerIds(ownerIds);
        
        
        PermissionMultiCodeDto supplierInfo = new PermissionMultiCodeDto();
        supplierInfo.setDataObjectCode(DataObjectEnum.SUPPLIER.getCode());
        supplierInfo.setOwnerIds(ownerIds);
        
        PermissionMultiCodeDto comission = new PermissionMultiCodeDto();
        comission.setDataObjectCode(DataObjectEnum.COMMISSION.getCode());
        comission.setOwnerIds(ownerIds);
        
        dtos.add(baseInfo);
        dtos.add(supplierInfo);
        dtos.add(comission);
        
    	return dtos;
    }
    
    
    
    
    
    private List<BaseProduct> getByIds(String ids) throws BaseException {
        Result<List<BaseProduct>> result = HttpUtils.get(TenantUrl.PRODUCT_GET_BY_IDS, ArgsUtils.toIdMap(ids, "ids"), new BaseTypeReference<Result<List<BaseProduct>>>() {
        });
        return result.getResult();
    }
    
	/**
	 * 获取产品的创建用户id
	 * 
	 * @param id
	 * @return
	 * @throws BaseException
	 */
	public Long getProductCreateUserId(Long id) throws BaseException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		Result<BaseProduct> result = HttpUtils.get(TenantUrl.GET_PRODUCT_BASE_INFO, map,
				new BaseTypeReference<Result<BaseProduct>>() {
				});
		if (!result.getSuccess()) {
			throw new BaseException(result.getCode(),result.getMessage());
		}
		Long createUserId = result.getResult().getCreateUserId();
		return createUserId;
	}
	
	
	  private List<Long> getReceiverAndAssistantId(Long id) throws BaseException {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			Result<BaseProduct> result = HttpUtils.get(TenantUrl.GET_PRODUCT_BASE_INFO, map,
					new BaseTypeReference<Result<BaseProduct>>() {
					});
			if (!result.getSuccess()) {
				throw new BaseException(result.getCode(),result.getMessage());
			}
			BaseProduct base = result.getResult();
			List<Long> ownerIds = new ArrayList<Long>();
			if(base.getAssistantId() != null || base.getReceiverId() != null){
    			if(base.getAssistantId() != null){
    				ownerIds.add(base.getAssistantId());
    			}
    			if(base.getReceiverId() != null && !ownerIds.contains(base.getReceiverId())){
    				ownerIds.add(base.getReceiverId());
    			}
    		}
			return ownerIds;
		}
	
	
    /**
     * 检查修改权限
     * @param id
     * @return
     * @throws BaseException
     */
    public Boolean updatePermission(Long id ,String dataObjectCode)throws BaseException{
    	List<Long> ownerIds =  getReceiverAndAssistantId(id);
    	if(BooleanUtils.isEmpty(ownerIds)){
    		Boolean isPass = permissionService.checkUpdate(dataObjectCode, null).getResult();
    		return isPass;
    	}
    	for(Long ownerId : ownerIds){
    		Boolean isPass = permissionService.checkUpdate(dataObjectCode, ownerId).getResult();
				if(isPass){
    			return isPass;
    		}
    	}
		return false;
    }
    
}
