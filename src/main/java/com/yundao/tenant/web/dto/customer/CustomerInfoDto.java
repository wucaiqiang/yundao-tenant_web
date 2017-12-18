package com.yundao.tenant.web.dto.customer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.yundao.tenant.web.dto.common.DataDto;
import com.yundao.tenant.web.dto.customer.tag.BaseTag;
import com.yundao.tenant.web.model.customer.BaseCustomerBank;
import com.yundao.tenant.web.util.DateFormatUtils;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年8月9日 下午1:52:42 
 * @author   wucq
 * @version   
 */
public class CustomerInfoDto implements DataDto,Serializable{
	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 客户姓名
	 */
	private String name;


	/**
	 * 省份
	 */
	private String provinceCode;
	/**
	 * 城市
	 */
	private String cityCode;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 行业
	 */
	private String trade;
	/**
	 * 机构
	 */
	private String organization;
	/**
	 * 职位
	 */
	private String position;

	/**
	 * 客户别
	 */
	private Integer sex;
	private String sexText;
	/**
	 * 客户级别
	 */
	private Integer level;
	private String levelText;
	/**
	 * 客户标签
	 */
	private List<BaseTag> tags;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 客户来源
	 */
	private Integer source;
	private String sourceText;
	/**
	 * 风险特征
	 */
	private Integer riskRating;
	private String riskRatingText;
	/**
	 * 投资人类型
	 */
	private Integer type;
	private String typeText;
	/**
	 * 客户证件
	 */
	private CustomerCredentialsDto credential;
	/**
	 * 客户附件
	 */
	private List<CustomerAttachDto> attachDtos;
	/**
	 * 银行卡信息
	 */
	private List<BaseCustomerBank> banks;
	/**
	 * 客户备注
	 */
	private String remark;
	/**
	 * 投资偏好
	 */
	private List<CustomerInvestTypeDto> investTypes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public List<BaseTag> getTags() {
	
		return tags;
	}
	public void setTags(List<BaseTag> tags) {
	
		this.tags = tags;
	}
	public String getBirthday() {
	   if(this.birthday !=null){
		   return DateFormatUtils.format(this.birthday, "yyyy-MM-dd");
	   }
		return "";
	}
	public void setBirthday(Date birthday) {
	
		this.birthday = birthday;
	}
	public Integer getSource() {
	
		return source;
	}
	public void setSource(Integer source) {
	
		this.source = source;
	}
	public String getSourceText() {
	
		return sourceText;
	}
	public void setSourceText(String sourceText) {
	
		this.sourceText = sourceText;
	}
	public Integer getRiskRating() {
	
		return riskRating;
	}
	public void setRiskRating(Integer riskRating) {
	
		this.riskRating = riskRating;
	}
	public String getRiskRatingText() {
	
		return riskRatingText;
	}
	public void setRiskRatingText(String riskRatingText) {
	
		this.riskRatingText = riskRatingText;
	}
	public Integer getType() {
	
		return type;
	}
	public void setType(Integer type) {
	
		this.type = type;
	}
	public String getTypeText() {
	
		return typeText;
	}
	public void setTypeText(String typeText) {
	
		this.typeText = typeText;
	}
	public CustomerCredentialsDto getCredential() {
	
		return credential;
	}
	public void setCredential(CustomerCredentialsDto credential) {
	
		this.credential = credential;
	}
	public List<CustomerAttachDto> getAttachDtos() {
	
		return attachDtos;
	}
	public void setAttachDtos(List<CustomerAttachDto> attachDtos) {
	
		this.attachDtos = attachDtos;
	}
	public List<BaseCustomerBank> getBanks() {
	
		return banks;
	}
	public void setBanks(List<BaseCustomerBank> banks) {
	
		this.banks = banks;
	}
	public String getRemark() {
	
		return remark;
	}
	public void setRemark(String remark) {
	
		this.remark = remark;
	}
	public List<CustomerInvestTypeDto> getInvestTypes() {
	
		return investTypes;
	}
	public void setInvestTypes(List<CustomerInvestTypeDto> investTypes) {
	
		this.investTypes = investTypes;
	}

}

