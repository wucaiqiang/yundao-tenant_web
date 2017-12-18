package com.yundao.tenant.web.dto.project;


import com.yundao.tenant.web.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * 项目分页列表数据返回dto
 *
 * @author jan
 * @create 2017-11-17 14:02
 **/
public class ProjectPageReqDto extends AbstractBasePageDto {

    @ApiModelProperty(value = "查询范围")
    private String scope;

    @ApiModelProperty(value = "项目名称")
    private String name;

    @ApiModelProperty(value = "公司")
    private String companyName;

    @ApiModelProperty(value = "优先级，多个逗号分隔")
    private String prioritys;

    @ApiModelProperty(value = "行业id，多个逗号分隔")
    private String industryIds;

    @ApiModelProperty(value = "最新轮次，多个逗号分隔")
    private String rounds;

    @ApiModelProperty(value = "状态，多个逗号分隔")
    private String statuss;

    @ApiModelProperty(value = "省份")
    private String provinceCodes;

    @ApiModelProperty(value = "城市")
    private String cityCodes;

    @ApiModelProperty(value = "行业")
    private String industry;

    @ApiModelProperty(value = "来源，多个逗号分隔")
    private String sources;

    @ApiModelProperty(value = "项目负责人姓名")
    private String leaderName;

    @ApiModelProperty(value = "创建日期，开始时间")
    private String createDateBegin;

    @ApiModelProperty(value = "创建日期，结束时间")
    private String createDateEnd;

    @ApiModelProperty(value = "出资金额 - 开始")
    private String investmentAmountBegin;

    @ApiModelProperty(value = "出资金额 - 结束")
    private String investmentAmountEnd;

    @ApiModelProperty(value = "出资占股 - 开始")
    private String shareRatioBegin;

    @ApiModelProperty(value = "出资占股 - 结束")
    private String shareRatioEnd;

    @ApiModelProperty(value = "当前估值 - 开始")
    private String valuationBegin;

    @ApiModelProperty(value = "当前估值 - 结束")
    private String valuationEnd;


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

    public String getPrioritys() {
        return prioritys;
    }

    public void setPrioritys(String prioritys) {
        this.prioritys = prioritys;
    }

    public String getRounds() {
        return rounds;
    }

    public void setRounds(String rounds) {
        this.rounds = rounds;
    }

    public String getStatuss() {
        return statuss;
    }

    public void setStatuss(String statuss) {
        this.statuss = statuss;
    }

    public String getProvinceCodes() {
        return provinceCodes;
    }

    public void setProvinceCodes(String provinceCodes) {
        this.provinceCodes = provinceCodes;
    }

    public String getCityCodes() {
        return cityCodes;
    }

    public void setCityCodes(String cityCodes) {
        this.cityCodes = cityCodes;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getCreateDateBegin() {
        return createDateBegin;
    }

    public void setCreateDateBegin(String createDateBegin) {
        this.createDateBegin = createDateBegin;
    }

    public String getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(String createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIndustryIds() {
        return industryIds;
    }

    public void setIndustryIds(String industryIds) {
        this.industryIds = industryIds;
    }

    public String getInvestmentAmountBegin() {
        return investmentAmountBegin;
    }

    public void setInvestmentAmountBegin(String investmentAmountBegin) {
        this.investmentAmountBegin = investmentAmountBegin;
    }

    public String getInvestmentAmountEnd() {
        return investmentAmountEnd;
    }

    public void setInvestmentAmountEnd(String investmentAmountEnd) {
        this.investmentAmountEnd = investmentAmountEnd;
    }

    public String getShareRatioBegin() {
        return shareRatioBegin;
    }

    public void setShareRatioBegin(String shareRatioBegin) {
        this.shareRatioBegin = shareRatioBegin;
    }

    public String getShareRatioEnd() {
        return shareRatioEnd;
    }

    public void setShareRatioEnd(String shareRatioEnd) {
        this.shareRatioEnd = shareRatioEnd;
    }

    public String getValuationBegin() {
        return valuationBegin;
    }

    public void setValuationBegin(String valuationBegin) {
        this.valuationBegin = valuationBegin;
    }

    public String getValuationEnd() {
        return valuationEnd;
    }

    public void setValuationEnd(String valuationEnd) {
        this.valuationEnd = valuationEnd;
    }
}

