package com.yundao.tenant.web.dto.project.decision.suggestion;

import io.swagger.annotations.ApiModelProperty;

/**
 * 立项意见编辑dto
 *
 * @author jan
 * @create 2017-11-20 20:23
 **/
public class DecisionSuggestionUpdateReqDto {

    @ApiModelProperty(value = "立项意见id")
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
