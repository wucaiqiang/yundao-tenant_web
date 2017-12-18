

package com.yundao.tenant.web.dto.project.index.audithistory;
/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月21日 上午9:43:20 
 * @author   欧阳利
 * @version   
 */
public class ProjectBusinessKeyDto {
    private Long id;
    
    private String name;
    
    private String businessKey;
    
    private Integer round;

	public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}

	public String getName() {
	
		return name;
	}

	public void setName(String name) {
	
		this.name = name;
	}

	public String getBusinessKey() {
	
		return businessKey;
	}

	public void setBusinessKey(String businessKey) {
	
		this.businessKey = businessKey;
	}

	public Integer getRound() {
	
		return round;
	}

	public void setRound(Integer round) {
	
		this.round = round;
	}
    
}

