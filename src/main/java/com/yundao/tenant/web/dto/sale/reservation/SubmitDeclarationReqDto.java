

package com.yundao.tenant.web.dto.sale.reservation;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月13日 下午5:33:27 
 * @author   欧阳利
 * @version   
 */
public class SubmitDeclarationReqDto {
    @ApiModelProperty(value = "预约id")
    private Long reservationId;

    @ApiModelProperty(value = "打款日期")
    private Date payDate;

    @ApiModelProperty(value = "认购金额")
    private Double dealAmount;

    @ApiModelProperty(value = "备注")
    private String remark;

    public Long getReservationId (){
        return reservationId;
    }

    public void setReservationId (Long reservationId){
        this.reservationId = reservationId;
    }

    public Date getPayDate (){
        return payDate;
    }

    public void setPayDate (Date payDate){
        this.payDate = payDate;
    }

    public String getRemark (){
        return remark;
    }

    public void setRemark (String remark){
        this.remark = remark;
    }

    public Double getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(Double dealAmount) {
        this.dealAmount = dealAmount;
    }
}

