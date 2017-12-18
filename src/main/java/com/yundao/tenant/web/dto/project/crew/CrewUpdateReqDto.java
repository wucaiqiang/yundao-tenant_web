package com.yundao.tenant.web.dto.project.crew;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by gjl on 2017/11/20.
 */
public class CrewUpdateReqDto {
    @ApiModelProperty(value = "立项投决id")
    private Long projectId;
    @ApiModelProperty(value = "组员id")
    private String userIds;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }
}
