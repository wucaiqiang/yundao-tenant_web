package com.yundao.tenant.web.dto.project.decision;


import io.swagger.annotations.ApiModelProperty;

/**
 * @author jan
 * @create 2017-11-19 15:17
 **/
public class DecisionSuggestionDto {

    @ApiModelProperty(value = "意见id")
    private Long id;

    @ApiModelProperty(value = "意见人")
    private String proposer;

    @ApiModelProperty(value = "意见人id")
    private Long proposerId;

    @ApiModelProperty(value = "意见")
    private Integer suggest;

    @ApiModelProperty(value = "意见文本")
    private String suggestText;

    @ApiModelProperty(value = "详情")
    private String remark;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    private String createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getSuggestText() {
        return suggestText;
    }

    public void setSuggestText(String suggestText) {
        this.suggestText = suggestText;
    }

    public Long getProposerId() {
        return proposerId;
    }

    public void setProposerId(Long proposerId) {
        this.proposerId = proposerId;
    }
}
