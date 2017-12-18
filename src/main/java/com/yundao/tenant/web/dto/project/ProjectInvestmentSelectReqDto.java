package com.yundao.tenant.web.dto.project;


import io.swagger.annotations.ApiModelProperty;

/**
 * 项目分页列表数据返回dto
 *
 * @author jan
 * @create 2017-11-17 14:02
 **/
public class ProjectInvestmentSelectReqDto {
    private Long fundId;

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }
}