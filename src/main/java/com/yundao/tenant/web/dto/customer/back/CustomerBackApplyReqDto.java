package com.yundao.tenant.web.dto.customer.back;


import com.yundao.tenant.web.dto.customer.CustomerMultiIdReqDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * 申请请求回退dto
 *
 * @author jan
 * @create 2017-08-10 PM3:40
 **/
public class CustomerBackApplyReqDto extends CustomerMultiIdReqDto {

    @ApiModelProperty(value = "回退原因")
    private String reason;

    @ApiModelProperty(value = "是否执行，默认false")
    private Boolean execute;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getExecute() {
        return execute;
    }

    public void setExecute(Boolean execute) {
        this.execute = execute;
    }
}