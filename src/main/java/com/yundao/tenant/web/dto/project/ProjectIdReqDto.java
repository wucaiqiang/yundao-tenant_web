package com.yundao.tenant.web.dto.project;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author jan
 * @create 2017-11-18 19:38
 **/
public class ProjectIdReqDto {

    @ApiModelProperty(value = "项目id")
    private Long projectId;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
