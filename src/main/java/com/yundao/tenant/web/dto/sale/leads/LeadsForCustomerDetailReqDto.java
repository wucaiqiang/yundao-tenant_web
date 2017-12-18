package com.yundao.tenant.web.dto.sale.leads;


import com.yundao.tenant.web.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * 客户详情销售线索数据请求dto
 *
 * @author jan
 * @create 2017-09-07 PM6:05
 **/
public class LeadsForCustomerDetailReqDto extends AbstractBasePageDto {

    @ApiModelProperty(value = "客户id")
    private Long customerId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
