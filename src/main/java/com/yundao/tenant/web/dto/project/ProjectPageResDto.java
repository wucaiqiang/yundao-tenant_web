package com.yundao.tenant.web.dto.project;


import com.yundao.tenant.web.util.DateUtils;
import io.swagger.annotations.ApiModelProperty;

/**
 * 项目分页列表数据返回dto
 *
 * @author jan
 * @create 2017-11-17 14:02
 **/
public class ProjectPageResDto {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "项目名称")
    private String name;

    @ApiModelProperty(value = "出资金额")
    private String investmentAmount;

    @ApiModelProperty(value = "出资占股")
    private String shareRatio;

    @ApiModelProperty(value = "公司")
    private String companyName;

    @ApiModelProperty(value = "优先级")
    private Integer priority;

    @ApiModelProperty(value = "优先级文本")
    private String priorityText;

    @ApiModelProperty(value = "最新轮次")
    private Integer round;

    @ApiModelProperty(value = "最新轮次文本")
    private String roundText;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "状态文本")
    private String statusText;

    @ApiModelProperty(value = "当前估值")
    private String valuation;

    @ApiModelProperty(value = "省份")
    private String provinceCode;

    @ApiModelProperty(value = "城市")
    private String cityCode;

    @ApiModelProperty(value = "省份文本")
    private String provinceText;

    @ApiModelProperty(value = "城市文本")
    private String cityText;

    @ApiModelProperty(value = "行业")
    private String industry;

    @ApiModelProperty(value = "来源")
    private Integer source;

    @ApiModelProperty(value = "来源文本")
    private String sourceText;

    @ApiModelProperty(value = "项目负责人id")
    private Long leaderId;

    @ApiModelProperty(value = "组员id")
    private String crewIds;

    @ApiModelProperty(value = "项目负责人姓名")
    private String leaderName;

    @ApiModelProperty(value = "创建时间")
    private String createDate;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getValuation() {
        return valuation;
    }

    public void setValuation(String valuation) {
        this.valuation = valuation;
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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
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

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = DateUtils.formatExactDay(createDate);
    }

    public String getCrewIds() {
        return crewIds;
    }

    public void setCrewIds(String crewIds) {
        this.crewIds = crewIds;
    }

    public String getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(String investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public String getShareRatio() {
        return shareRatio;
    }

    public void setShareRatio(String shareRatio) {
        this.shareRatio = shareRatio;
    }
}
