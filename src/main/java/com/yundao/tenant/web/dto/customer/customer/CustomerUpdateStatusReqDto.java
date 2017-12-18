package com.yundao.tenant.web.dto.customer.customer;


import io.swagger.annotations.ApiModelProperty;

/**
 * 更改客户状态数据请求dto
 *
 * @author jan
 * @create 2017-09-09 AM11:36
 **/
public class CustomerUpdateStatusReqDto {

    @ApiModelProperty(value = "客户id")
    private Long id;

    @ApiModelProperty(value = "客户状态")
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}