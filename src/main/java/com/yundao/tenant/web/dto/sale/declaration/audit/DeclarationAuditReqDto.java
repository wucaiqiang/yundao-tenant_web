package com.yundao.tenant.web.dto.sale.declaration.audit;


import io.swagger.annotations.ApiModelProperty;

/**
 * @author jan
 * @create 2017-08-28 PM10:12
 **/
public class DeclarationAuditReqDto {


    @ApiModelProperty(value = "报单id")
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

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
