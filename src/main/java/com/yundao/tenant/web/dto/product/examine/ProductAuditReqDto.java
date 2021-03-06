package com.yundao.tenant.web.dto.product.examine;


import io.swagger.annotations.ApiModelProperty;

/**
 * 产品审核请求dto
 *
 * @author jan
 * @create 2017-08-03 PM3:05
 **/
public class ProductAuditReqDto {

    @ApiModelProperty(value = "产品审核id")
    private Long id;

    @ApiModelProperty(value = "动作，1：通过  2：驳回 3：取消")
    private Integer action;

    @ApiModelProperty(value = "驳回理由")
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
