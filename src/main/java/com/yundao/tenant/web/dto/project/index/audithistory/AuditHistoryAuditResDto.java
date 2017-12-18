

package com.yundao.tenant.web.dto.project.index.audithistory;

import java.util.List;

import com.yundao.tenant.web.dto.workflow.AuditDetailResDTO;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月21日 上午9:15:45 
 * @author   欧阳利
 * @version   
 */
public class AuditHistoryAuditResDto {
 
   @ApiModelProperty("轮次名称")
   private String name;
   @ApiModelProperty("审批详情")
   private List<AuditDetailResDTO> list;
   
	public String getName() {
	
		return name;
	}
	public void setName(String name) {
	
		this.name = name;
	}
	public List<AuditDetailResDTO> getList() {
	
		return list;
	}
	public void setList(List<AuditDetailResDTO> list) {
	
		this.list = list;
	}
   
}

