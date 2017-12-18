package com.yundao.tenant.web.dto.sale.declaration;


import io.swagger.annotations.ApiModelProperty;

/**
 * 我的报单申请审核请求数据dto
 *
 * @author jan
 * @create 2017-08-25 AM11:39
 **/
public class DeclarationApplyrReqDto {

    @ApiModelProperty(value = "报单id")
    private Long id;

    @ApiModelProperty(value = "取消原因")
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
}
