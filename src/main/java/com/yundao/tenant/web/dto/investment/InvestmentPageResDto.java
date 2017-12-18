package com.yundao.tenant.web.dto.investment;


import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 投资返回数据dto
 *
 * @author jan
 * @create 2017-11-27 16:14
 **/
public class InvestmentPageResDto {

    @ApiModelProperty(value = "基金id")
    private Long id;

    @ApiModelProperty(value = "基金名称")
    private String name;

    @ApiModelProperty(value = "基金规模")
    private String productScale;

    @ApiModelProperty(value = "已投金额")
    private String investAmountTotal;

    @ApiModelProperty(value = "项目")
    private List<InvestmentPageProjectDto> projects;

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

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getInvestAmountTotal() {
        return investAmountTotal;
    }

    public void setInvestAmountTotal(String investAmountTotal) {
        this.investAmountTotal = investAmountTotal;
    }

    public List<InvestmentPageProjectDto> getProjects() {
        return projects;
    }

    public void setProjects(List<InvestmentPageProjectDto> projects) {
        this.projects = projects;
    }
}
