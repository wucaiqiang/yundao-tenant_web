package com.yundao.tenant.web.dto.project.decision.suggestion;


import io.swagger.annotations.ApiModelProperty;

/**
 * @author jan
 * @create 2017-11-21 08:55
 **/
public class DecisionSuggestionListReqDto {

    @ApiModelProperty(value = "立项投决id")
    private Long decisionId;

    public Long getDecisionId() {
        return decisionId;
    }

    public void setDecisionId(Long decisionId) {
        this.decisionId = decisionId;
    }
}