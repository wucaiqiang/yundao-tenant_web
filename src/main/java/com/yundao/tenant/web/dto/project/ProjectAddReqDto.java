package com.yundao.tenant.web.dto.project;

import io.swagger.annotations.ApiModelProperty;

/**
 * 添加项目
 *
 * @author jan
 * @create 2017-11-18 09:17
 **/
public class ProjectAddReqDto {

    @ApiModelProperty(value = "项目名称")
    private String name;

    @ApiModelProperty(value = "行业领域id")
    private Long industryId;

    @ApiModelProperty(value = "项目负责人id")
    private Long leaderId;

    @ApiModelProperty(value = "项目来源")
    private Integer source;

    @ApiModelProperty(value = "省份编码")
    private String provinceCode;

    @ApiModelProperty(value = "市编码")
    private String cityCode;

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

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
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

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }
}
