
package com.yundao.tenant.web.dto.project.financing;

import com.yundao.tenant.web.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

public class FinancingRoundPageReqDto extends AbstractBasePageDto {

    @ApiModelProperty("项目ID")
    private Long projectId;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
