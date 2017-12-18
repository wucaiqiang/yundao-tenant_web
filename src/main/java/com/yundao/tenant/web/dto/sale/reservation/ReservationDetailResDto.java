

package com.yundao.tenant.web.dto.sale.reservation;

import com.yundao.tenant.web.dto.common.DataPermissionDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月13日 下午5:48:37 
 * @author   欧阳利
 * @version   
 */
public class ReservationDetailResDto {
	private BaseReservationDto data;

	private DataPermissionDto permission;

	public BaseReservationDto getData() {
	
		return data;
	}

	public void setData(BaseReservationDto data) {
	
		this.data = data;
	}

	public DataPermissionDto getPermission() {
	
		return permission;
	}

	public void setPermission(DataPermissionDto permission) {
	
		this.permission = permission;
	}
	  
}

