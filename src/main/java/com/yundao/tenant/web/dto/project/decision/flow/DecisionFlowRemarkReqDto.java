package com.yundao.tenant.web.dto.project.decision.flow;


import io.swagger.annotations.ApiModelProperty;

/**
 * 立项流程备注dto
 *
 * @author jan
 * @create 2017-11-22 15:11
 **/
public class DecisionFlowRemarkReqDto {

    @ApiModelProperty(value = "立项流程id")
    private Long flowId;

    @ApiModelProperty(value = "备注")
    private String remark;

    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
