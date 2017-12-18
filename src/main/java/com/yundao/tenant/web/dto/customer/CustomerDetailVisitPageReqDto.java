package com.yundao.tenant.web.dto.customer;

import com.yundao.tenant.web.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * 客户详情页回访分页数据
 *
 * @author jan
 * @create 2017-08-11 AM10:25
 **/
public class CustomerDetailVisitPageReqDto extends AbstractBasePageDto {

    @ApiModelProperty(value = "客户id")
    private Long customerId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
