package com.yundao.tenant.web.dto.project.decision.suggestion;

import io.swagger.annotations.ApiModelProperty;

/**
 * 立项意见添加dto
 *
 * @author jan
 * @create 2017-11-20 19:38
 **/
public class DecisionSuggestionAddReqDto {

    @ApiModelProperty(value = "立项id")
    private Long decisionId;

    @ApiModelProperty(value = "意见人id")
    private Long proposerId;

    @ApiModelProperty(value = "意见")
    private Integer suggest;

    @ApiModelProperty(value = "详情")
    private String remark;

    public Long getProposerId() {
        return proposerId;
    }

    public void setProposerId(Long proposerId) {
        this.proposerId = proposerId;
    }

    public Integer getSuggest() {
        return suggest;
    }

    public void setSuggest(Integer suggest) {
        this.suggest = suggest;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getDecisionId() {
        return decisionId;
    }

    public void setDecisionId(Long decisionId) {
        this.decisionId = decisionId;
    }
}
