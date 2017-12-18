
package com.yundao.tenant.web.dto.project.file;

import com.yundao.tenant.web.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

public class ProjectFilePageReqDto extends AbstractBasePageDto{
    @ApiModelProperty(value = "项目id")
    private Long projectId;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
