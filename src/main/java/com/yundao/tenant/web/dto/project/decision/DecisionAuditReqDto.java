package com.yundao.tenant.web.dto.project.decision;


import io.swagger.annotations.ApiModelProperty;

/**
 * 立项审批请求dto
 *
 * @author jan
 * @create 2017-11-23 11:43
 **/
public class DecisionAuditReqDto {

    @ApiModelProperty(value = "立项id")
    private Long decisionId;

    @ApiModelProperty(value = "动作；通过:1,驳回:2,")
    private Integer action;

    @ApiModelProperty(value = "审批意见/驳回原因")
    private String commit;

    public Long getDecisionId() {
        return decisionId;
    }

    public void setDecisionId(Long decisionId) {
        this.decisionId = decisionId;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public String getCommit() {
        return commit;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }
}
