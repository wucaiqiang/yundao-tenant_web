package com.yundao.tenant.web.dto.project.decision;


import io.swagger.annotations.ApiModelProperty;

/**
 * 提交审批dto
 *
 * @author jan
 * @create 2017-11-23 10:29
 **/
public class DecisionAuditSubmitReqDto {

    @ApiModelProperty(value = "立项流程id")
    private Long flowId;

    @ApiModelProperty(value = "动作；提交：7，重新提交：4")
    private Integer action;

    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }
}