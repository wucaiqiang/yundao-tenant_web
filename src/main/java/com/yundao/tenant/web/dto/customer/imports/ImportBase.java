package com.yundao.tenant.web.dto.customer.imports;

import com.yundao.tenant.web.annotation.FieldDescription;
import io.swagger.annotations.ApiModelProperty;

/**
 * 导入基础数据
 *
 * @author jan
 * @create 2017-11-28 14:27
 **/
public class ImportBase {

    /**
     * 客户姓名
     */
    @FieldDescription("客户姓名")
    private String name;

    /**
     * 手机号码
     */
    @FieldDescription("手机号码")
    private String mobile;

    /**
     * 性别，1：男，2：女
     */
    @FieldDescription("性别")
    private String sex;

    /**
     * 微信
     */
    @FieldDescription("微信")
    private String wechat;

    /**
     * 邮箱
     */
    @FieldDescription("邮箱")
    private String email;

    /**
     * 客户有效性
     */
    @FieldDescription("客户有效性")
    private String status;

    /**
     * 备注
     */
    @FieldDescription("备注")
    private String remark;

    @ApiModelProperty(value = "客户级别")
    private String level;

    @ApiModelProperty(value = "标签")
    private String tag;

    @ApiModelProperty(value = "来源")
    private String source;

    @ApiModelProperty(value = "证件类型")
    private String credentialsType;

    @ApiModelProperty(value = "证件号码")
    private String credentialsNumber;

    @ApiModelProperty(value = "省份")
    private String province;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "行业")
    private String trade;

    @ApiModelProperty(value = "机构")
    private String organization;

    @ApiModelProperty(value = "职位")
    private String position;

    @ApiModelProperty(value = "QQ")
    private String qq;

    @ApiModelProperty(value = "银行卡账号")
    private String bankAccount;

    @ApiModelProperty(value = "开户行")
    private String bankName;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(String credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsNumber() {
        return credentialsNumber;
    }

    public void setCredentialsNumber(String credentialsNumber) {
        this.credentialsNumber = credentialsNumber;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
