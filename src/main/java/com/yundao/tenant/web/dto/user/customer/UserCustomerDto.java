package com.yundao.tenant.web.dto.user.customer;

import java.util.Date;

/**
 * @author jan
 * @create 2017-09-06 PM1:55
 **/
public class UserCustomerDto {


    private Long id;

    /**
     * 客户id
     */
    private Long customerId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 分配日期
     */
    private Date distributionDate;

    /**
     * 分配人
     */
    private Long distributionUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDistributionDate() {
        return distributionDate;
    }

    public void setDistributionDate(Date distributionDate) {
        this.distributionDate = distributionDate;
    }

    public Long getDistributionUserId() {
        return distributionUserId;
    }

    public void setDistributionUserId(Long distributionUserId) {
        this.distributionUserId = distributionUserId;
    }
}
