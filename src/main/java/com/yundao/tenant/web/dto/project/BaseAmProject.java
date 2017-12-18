package com.yundao.tenant.web.dto.project;

import com.yundao.core.base.model.BaseModel;

import java.io.Serializable;

public class BaseAmProject extends BaseModel implements Serializable {
    /**
	 * 项目名称
	 */
    private String name;

    /**
	 * 行业领域id
	 */
    private Long industryId;

    /**
	 * 项目负责人
	 */
    private Long leaderId;

    /**
	 * 目前估值
	 */
    private Double valuation;

    /**
	 * 币种
	 */
    private Integer currency;

    /**
	 * 来源
	 */
    private Integer source;

    /**
	 * 优先级
	 */
    private Integer priority;

    /**
	 * 省份
	 */
    private String provinceCode;

    /**
	 * 市
	 */
    private String cityCode;

    /**
	 * 主页链接
	 */
    private String url;

    /**
	 * 项目介绍
	 */
    private String description;

    /**
	 * 状态
	 */
    private Integer status;

    /**
	 * 备注
	 */
    private String remark;

    private static final long serialVersionUID = 1L;

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

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    public Double getValuation() {
        return valuation;
    }

    public void setValuation(Double valuation) {
        this.valuation = valuation;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}