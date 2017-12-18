package com.yundao.tenant.web.dto.sale.leads;

import java.util.Date;

/**
 * 销售线索
 *
 * @author jan
 * @create 2017-09-11 PM9:56
 **/
public class LeadsDetailDto {

    private Long id;
    private Long createUserId;
    private Date createDate;
    private Long updateUserId;
    private Date updateDate;

    /**
     * 客户id
     */
    private Long customerId;

    /**
     * 线索类型，1：预约产品；2：注册；
     */
    private Integer type;

    /**
     * 渠道，1：网站；2：服务号
     */
    private Integer channel;

    /**
     * 内容
     */
    private String content;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态，0：未处理；1：已联系；2：关闭
     */
    private Integer status;

    /**
     * 处理人id
     */
    private Long processUserId;

    /**
     * 处理时间
     */
    private Date processDate;

    /**
     * 线索所属客户的状态，是否曾经被设置过无效，0：否，1：是，默认0
     */
    private Integer isOnceInvalid;

    /**
     * 是否已被分配给客服，0：否，1：是
     */
    private Integer isAllotedCs;

    /**
     * 是否已被分配给理财师，0：否，1：是
     */
    private Integer isAllotedFp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getProcessUserId() {
        return processUserId;
    }

    public void setProcessUserId(Long processUserId) {
        this.processUserId = processUserId;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public Integer getIsOnceInvalid() {
        return isOnceInvalid;
    }

    public void setIsOnceInvalid(Integer isOnceInvalid) {
        this.isOnceInvalid = isOnceInvalid;
    }

    public Integer getIsAllotedCs() {
        return isAllotedCs;
    }

    public void setIsAllotedCs(Integer isAllotedCs) {
        this.isAllotedCs = isAllotedCs;
    }

    public Integer getIsAllotedFp() {
        return isAllotedFp;
    }

    public void setIsAllotedFp(Integer isAllotedFp) {
        this.isAllotedFp = isAllotedFp;
    }
}
