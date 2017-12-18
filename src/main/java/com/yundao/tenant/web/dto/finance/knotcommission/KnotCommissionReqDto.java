
package com.yundao.tenant.web.dto.finance.knotcommission;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class KnotCommissionReqDto{
    @ApiModelProperty(value = "报单ID")
    private Long declarationId;

    @ApiModelProperty(value = "佣金类型")
    private String type;

    @ApiModelProperty(value = "佣金费率")
    private Double rate;

    @ApiModelProperty(value = "佣金金额")
    private Double amount;

    @ApiModelProperty(value = "发放时间")
    private Date provideDate;

    @ApiModelProperty(value = "备注")
    private String remark;

    public Long getDeclarationId (){
        return declarationId;
    }

    public void setDeclarationId (Long declarationId){
        this.declarationId = declarationId;
    }

    public String getType (){
        return type;
    }

    public void setType (String type){
        this.type = type;
    }

    public Date getProvideDate (){
        return provideDate;
    }

    public void setProvideDate (Date provideDate){
        this.provideDate = provideDate;
    }

    public String getRemark (){
        return remark;
    }

    public void setRemark (String remark){
        this.remark = remark;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
