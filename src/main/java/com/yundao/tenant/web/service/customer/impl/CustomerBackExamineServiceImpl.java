package com.yundao.tenant.web.service.customer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.customer.back.CustomerBackExamineListReqDto;
import com.yundao.tenant.web.dto.customer.back.CustomerBackExamineListResDto;
import com.yundao.tenant.web.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.web.enums.dataobject.DataObjectEnum;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.web.service.PermissionService;
import com.yundao.tenant.web.service.customer.CustomerBackExamineService;
import com.yundao.tenant.web.service.user.UserService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.FormatContactUtils;
import com.yundao.tenant.web.util.HttpUtils;

@Service
public class CustomerBackExamineServiceImpl extends AbstractService implements CustomerBackExamineService {


	@Autowired
	PermissionService permissionService;
	@Autowired
	UserService userService;
	
	@Override
	public Result<PaginationSupport<CustomerBackExamineListResDto>> gets(CustomerBackExamineListReqDto reqDto)
			throws BaseException {
		Result<PaginationSupport<CustomerBackExamineListResDto>> result = HttpUtils.get(TenantUrl.BACK_CUSTOMER_GETS, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<PaginationSupport<CustomerBackExamineListResDto>>>() {});
		if(!result.getSuccess()){
    		Result.newSuccessResult(result.getCode());
    	}
    	List<CustomerBackExamineListResDto> datas = result.getResult().getDatas();
    	if(BooleanUtils.isEmpty(datas)){
    		return result;
    	}
		
		// 客户信息加密
    	Result<Integer> permissionResult = permissionService.getRead(DataObjectEnum.CONTACT.getCode());
    	if(!permissionResult.getSuccess()){
    		Result.newSuccessResult(permissionResult.getCode());
    	}
    	
    	Integer permission = permissionResult.getResult();
    	Long userId = this.getHeaderUserId();
    	List<Long> sameDepartmentUserIds = null;
    	for(CustomerBackExamineListResDto dto:datas){
        	Boolean isContactReadPermission = false;
        	if(DataObjectPermissionEnum.NONE.getValue().equals(permission)){
        		isContactReadPermission = false;
        	}else if(DataObjectPermissionEnum.PUBLIC.getValue().equals(permission)){
        		isContactReadPermission = true;
        	}else if(DataObjectPermissionEnum.PERSONAL.getValue().equals(permission)){
        		if(userId.equals(dto.getOwnerId())){
        			isContactReadPermission = true;
        		}else{
        			isContactReadPermission = false;
        		}
        	}else if(DataObjectPermissionEnum.DEPARTMENT.getValue().equals(permission)){
        		if(BooleanUtils.isEmpty(sameDepartmentUserIds)){
        			sameDepartmentUserIds = userService.getCurrentUserDepartmentUserIds();
        		}
        		if(sameDepartmentUserIds.contains(dto.getOwnerId())){
        			isContactReadPermission = true;
        		}else{
        			isContactReadPermission = false;
        		}
        		
        	}
    		dto.setCustomerMobile(FormatContactUtils.formatMobile(true, isContactReadPermission, dto.getCustomerMobile())); 
    	}
    	
		return result;
	}

}
