package com.yundao.tenant.web.dto.sale.reservation.audit;


import io.swagger.annotations.ApiModelProperty;

/**
 * 预约审核更改状态数据dto
 *
 * @author jan
 * @create 2017-08-24 PM7:41
 **/
public class ReservationAuditReqDto {

    @ApiModelProperty(value = "预约id")
    private Long id;

    @ApiModelProperty(value = "动作，1：通过  2：驳回 3：取消")
    private Integer action;

    @ApiModelProperty(value = "驳回/取消原因")
    private String reason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }
}
