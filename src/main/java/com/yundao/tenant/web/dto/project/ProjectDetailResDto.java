package com.yundao.tenant.web.dto.project;


import io.swagger.annotations.ApiModelProperty;

/**
 * 项目详情dto
 *
 * @author jan
 * @create 2017-11-18 16:16
 **/
public class ProjectDetailResDto {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "立项投决id")
    private Long decisionId;

    @ApiModelProperty(value = "项目名称")
    private String name;

    @ApiModelProperty(value = "行业")
    private Long industryId;

    @ApiModelProperty(value = "行业文本")
    private String industryText;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "状态文本")
    private String statusText;

    @ApiModelProperty(value = "优先级")
    private Integer priority;

    @ApiModelProperty(value = "优先级文本")
    private String priorityText;

    @ApiModelProperty(value = "当前估值")
    private String valuation;

    @ApiModelProperty(value = "最新轮次")
    private Integer round;

    @ApiModelProperty(value = "最新轮次文本")
    private String roundText;

    @ApiModelProperty(value = "币种")
    private Integer currency;

    @ApiModelProperty(value = "币种文本")
    private String currencyText;

    @ApiModelProperty(value = "来源")
    private Integer source;

    @ApiModelProperty(value = "来源文本")
    private String sourceText;

    @ApiModelProperty(value = "省份")
    private String provinceCode;

    @ApiModelProperty(value = "城市")
    private String cityCode;

    @ApiModelProperty(value = "省份文本")
    private String provinceText;

    @ApiModelProperty(value = "城市文本")
    private String cityText;

    @ApiModelProperty(value = "主页链接")
    private String url;

    @ApiModelProperty(value = "项目介绍")
    private String description;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "是否已关注")
    private Boolean isFocused;

    @ApiModelProperty(value = "项目负责人id")
    private Long leaderId;

    @ApiModelProperty(value = "项目负责人姓名")
    private String leaderName;

    @ApiModelProperty(value = "成员名称")
    private String crew;

    @ApiModelProperty(value = "成员id")
    private String crewIds;

    @ApiModelProperty(value = "应审批立项流程状态，空表示没有应审批数据")
    private Integer shouldAuditStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Long industryId) {
        this.industryId = industryId;
    }

    public String getIndustryText() {
        return industryText;
    }

    public void setIndustryText(String industryText) {
        this.industryText = industryText;
    }

    public Boolean getFocused() {
        return isFocused;
    }

    public void setFocused(Boolean focused) {
        isFocused = focused;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getPriorityText() {
        return priorityText;
    }

    public void setPriorityText(String priorityText) {
        this.priorityText = priorityText;
    }

    public String getValuation() {
        return valuation;
    }

    public void setValuation(String valuation) {
        this.valuation = valuation;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public String getRoundText() {
        return roundText;
    }

    public void setRoundText(String roundText) {
        this.roundText = roundText;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public String getCurrencyText() {
        return currencyText;
    }

    public void setCurrencyText(String currencyText) {
        this.currencyText = currencyText;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getSourceText() {
        return sourceText;
    }

    public void setSourceText(String sourceText) {
        this.sourceText = sourceText;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getProvinceText() {
        return provinceText;
    }

    public void setProvinceText(String provinceText) {
        this.provinceText = provinceText;
    }

    public String getCityText() {
        return cityText;
    }

    public void setCityText(String cityText) {
        this.cityText = cityText;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getIsFocused() {
        return isFocused;
    }

    public void setIsFocused(Boolean isFocused) {
        this.isFocused = isFocused;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public Long getDecisionId() {
        return decisionId;
    }

    public void setDecisionId(Long decisionId) {
        this.decisionId = decisionId;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    public String getCrewIds() {
        return crewIds;
    }

    public void setCrewIds(String crewIds) {
        this.crewIds = crewIds;
    }

    public Integer getShouldAuditStatus() {
        return shouldAuditStatus;
    }

    public void setShouldAuditStatus(Integer shouldAuditStatus) {
        this.shouldAuditStatus = shouldAuditStatus;
    }
}
