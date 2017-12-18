package com.yundao.tenant.web.dto.customer.customer;


import com.yundao.tenant.web.annotation.FieldCode;
import com.yundao.tenant.web.constant.field.code.Contact;
import com.yundao.tenant.web.constant.field.code.Customer;
import io.swagger.annotations.ApiModelProperty;

/**
 * 客户下拉选项dto
 *
 * @author jan
 * @create 2017-08-23 PM8:26
 **/
public class CustomerSelectionResDto {

    @ApiModelProperty(value = "客户id")
    private Long id;

    @FieldCode(Customer.NAME)
    @ApiModelProperty(value = "客户姓名")
    private String name;

    @FieldCode(Contact.MOBILE)
    @ApiModelProperty(value = "手机号码")
    private String mobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
