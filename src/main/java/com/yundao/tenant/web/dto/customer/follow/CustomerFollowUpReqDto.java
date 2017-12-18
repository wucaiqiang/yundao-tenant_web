
package com.yundao.tenant.web.dto.customer.follow;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class CustomerFollowUpReqDto{

    @ApiModelProperty(value = "客户id")
    private Long customerId;

    @ApiModelProperty(value = "跟进方式")
    private Long type;

    @ApiModelProperty(value = "跟进内容")
    private String content;

    @ApiModelProperty(value = "下次跟进时间")
    private Date nextFollowDate;


    public Long getCustomerId (){
        return customerId;
    }

    public void setCustomerId (Long customerId){
        this.customerId = customerId;
    }

    public Long getType (){
        return type;
    }

    public void setType (Long type){
        this.type = type;
    }

    public String getContent (){
        return content;
    }

    public void setContent (String content){
        this.content = content;
    }

    public Date getNextFollowDate (){
        return nextFollowDate;
    }

    public void setNextFollowDate (Date nextFollowDate){
        this.nextFollowDate = nextFollowDate;
    }

}
