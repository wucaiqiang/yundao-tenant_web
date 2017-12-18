package com.yundao.tenant.web.dto.customer;


import com.yundao.tenant.web.annotation.FieldCode;
import com.yundao.tenant.web.annotation.Owner;
import com.yundao.tenant.web.constant.field.code.Contact;
import com.yundao.tenant.web.constant.field.code.Customer;
import com.yundao.tenant.web.util.DateUtils;
import io.swagger.annotations.ApiModelProperty;

/**
 * 我的客户分页列表
 *
 * @author jan
 * @create 2017-08-09 AM10:44
 **/
public class MyCustomerPageResDto {

    @ApiModelProperty(value = "客户id")
    private Long id;

    @FieldCode(Customer.NAME)
    @ApiModelProperty(value = "客户姓名")
    private String name;

    @ApiModelProperty(value = "客户编号")
    private String number;

    @FieldCode(Contact.MOBILE)
    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "性别文本")
    private String sexText;

    @ApiModelProperty(value = "省份")
    private String provinceCode;

    @ApiModelProperty(value = "城市")
    private String cityCode;

    @FieldCode(Customer.PROVINCE_CODE)
    @ApiModelProperty(value = "省份文本")
    private String provinceText;

    @FieldCode(Customer.CITY_CODE)
    @ApiModelProperty(value = "城市文本")
    private String cityText;

    @ApiModelProperty(value = "客户级别")
    private Integer level;

    @ApiModelProperty(value = "客户级别文本")
    private String levelText;

    @ApiModelProperty(value = "是否成交文本")
    private String isDealText;

    @ApiModelProperty(value = "最近成交时间")
    private String dealDate;

    @ApiModelProperty(value = "分配时间")
    private String distributionDate;

    @Owner
    @ApiModelProperty(value = "理财师id")
    private Long fpId;

    @ApiModelProperty(value = "是否能进行跟进")
    private Boolean canFollow;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSexText() {
        return sexText;
    }

    public void setSexText(String sexText) {
        this.sexText = sexText;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getProvinceText() {
        return provinceText;
    }

    public void setProvinceText(String provinceText) {
        this.provinceText = provinceText;
    }

    public String getCityText() {
        return cityText;
    }

    public void setCityText(String cityText) {
        this.cityText = cityText;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLevelText() {
        return levelText;
    }

    public void setLevelText(String levelText) {
        this.levelText = levelText;
    }

    public String getIsDealText() {
        return isDealText;
    }

    public void setIsDealText(String isDealText) {
        this.isDealText = isDealText;
    }

    public String getDealDate() {
        return dealDate;
    }

    public void setDealDate(String dealDate) {
        this.dealDate = DateUtils.formatExactDay(dealDate);
    }

    public String getDistributionDate() {
        return distributionDate;
    }

    public void setDistributionDate(String distributionDate) {
        this.distributionDate = DateUtils.formatExactDay(distributionDate);
    }

    public Long getFpId() {
        return fpId;
    }

    public void setFpId(Long fpId) {
        this.fpId = fpId;
    }

    public Boolean getCanFollow() {
        return canFollow;
    }

    public void setCanFollow(Boolean canFollow) {
        this.canFollow = canFollow;
    }
}
