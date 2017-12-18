
package com.yundao.tenant.web.dto.project.financing;

import io.swagger.annotations.ApiModelProperty;

public class FinancingUpdateReqDto {

    @ApiModelProperty("投资信息ID")
    private Long id;

    @ApiModelProperty(value = "投资方，来源；1：内部基金产品，2：其他")
    private Integer investmentSource;

    @ApiModelProperty(value = "基金id")
    private Long fundId;

    @ApiModelProperty(value = "基金名称")
    private String fundName;

    @ApiModelProperty(value = "出资金额")
    private Double investmentAmount;

    @ApiModelProperty(value = "占股比例")
    private Double shareRatio;

    @ApiModelProperty(value = "添加方式，1：手动添加，2：立项通过自动添加")
    private Integer insertType;

    public Integer getInvestmentSource (){
        return investmentSource;
    }

    public void setInvestmentSource (Integer investmentSource){
        this.investmentSource = investmentSource;
    }

    public Long getFundId (){
        return fundId;
    }

    public void setFundId (Long fundId){
        this.fundId = fundId;
    }

    public String getFundName (){
        return fundName;
    }

    public void setFundName (String fundName){
        this.fundName = fundName;
    }

    public Integer getInsertType (){
        return insertType;
    }

    public void setInsertType (Integer insertType){
        this.insertType = insertType;
    }

    public Double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(Double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public Double getShareRatio() {
        return shareRatio;
    }

    public void setShareRatio(Double shareRatio) {
        this.shareRatio = shareRatio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
