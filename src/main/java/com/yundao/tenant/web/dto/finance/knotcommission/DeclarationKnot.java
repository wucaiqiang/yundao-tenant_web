package com.yundao.tenant.web.dto.finance.knotcommission;

import com.yundao.tenant.web.dto.sale.declaration.DeclarationModel;

/**
 * Created by gjl on 2017/10/13.
 */
public class DeclarationKnot extends DeclarationModel {
    private Integer totalCount;
    private Double totalAmount;
    private String customerNumber;
    private String userName;

    public Integer getTotalCount() {
        if(totalCount == null){
            return 0;
        }
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Double getTotalAmount() {
        if(totalAmount == null){
            return 0D;
        }
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
