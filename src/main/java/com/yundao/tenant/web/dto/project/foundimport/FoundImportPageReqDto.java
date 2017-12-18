package com.yundao.tenant.web.dto.project.foundimport;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by gjl on 2017/11/23.
 */
public class FoundImportPageReqDto {
    @ApiModelProperty("产品ID")
    private Long projectId;

    @ApiModelProperty("基金ID")
    private Long fundId;

    @ApiModelProperty("类型")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }
}
