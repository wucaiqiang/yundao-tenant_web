package com.yundao.tenant.web.dto.project.decision;


import io.swagger.annotations.ApiModelProperty;

/**
 * 添加立项
 *
 * @author jan
 * @create 2017-11-18 11:21
 **/
public class DecisionAddReqDto {

    @ApiModelProperty(value = "项目id")
    private Long projectId;

    @ApiModelProperty(value = "轮次")
    private Integer round;

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
