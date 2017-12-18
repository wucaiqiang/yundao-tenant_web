

package com.yundao.tenant.web.dto.project.index;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月22日 下午6:36:12 
 * @author   欧阳利
 * @version   
 */
public class ProjectCountResDto {
    private String name;
    
    private Integer count;
    
    
    
    public static List<ProjectCountResDto> getProjectCountResDto(ProjectCountDto dto){
    	List<ProjectCountResDto> resDtoList = new ArrayList<ProjectCountResDto>();
    	ProjectCountResDto resDto1 = new ProjectCountResDto();
    	resDto1.setCount(dto.getProjectCount());
    	resDto1.setName("入库");
    	resDtoList.add(resDto1);
    	
    	ProjectCountResDto resDto2 = new ProjectCountResDto();
    	resDto2.setCount(dto.getProjectDecisionCount());
    	resDto2.setName("立项");
    	resDtoList.add(resDto2);
    	
    	ProjectCountResDto resDto3 = new ProjectCountResDto();
    	resDto3.setCount(dto.getProjectInvestCount());
    	resDto3.setName("出资");
    	resDtoList.add(resDto3);
    	
    	ProjectCountResDto resDto4 = new ProjectCountResDto();
    	resDto4.setCount(dto.getProjectWithdrawal());
    	resDto4.setName("退出");
    	resDtoList.add(resDto4);
    	return resDtoList;
    }

	public String getName() {
	
		return name;
	}

	public void setName(String name) {
	
		this.name = name;
	}

	public Integer getCount() {
	
		return count;
	}

	public void setCount(Integer count) {
	
		this.count = count;
	}
    
}

