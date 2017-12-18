package com.yundao.tenant.web.dto.project.company;

import com.yundao.core.base.model.BaseModel;

import java.io.Serializable;
import java.util.Date;

public class BaseAmCompany extends BaseModel implements Serializable {
    /**
	 * 项目id
	 */
    private Long projectId;

    /**
	 * 名称
	 */
    private String name;

    /**
	 * 登记机关
	 */
    private String registrationAuthority;

    /**
	 * 注册号
	 */
    private String registrationNumber;

    /**
	 * 注册时间
	 */
    private Date registrationDate;

    /**
	 * 类型
	 */
    private Integer type;

    /**
	 * 营业期限开始时间
	 */
    private Date businessTermBegin;

    /**
	 * 营业期限结束时间
	 */
    private Date businessTermEnd;

    /**
	 * 法定代表
	 */
    private String legalRepresentative;

    /**
	 * 注册资本
	 */
    private Double registrationCapital;

    /**
	 * 发照日期
	 */
    private Date approvalDate;

    /**
	 * 公司地址
	 */
    private String address;

    private static final long serialVersionUID = 1L;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationAuthority() {
        return registrationAuthority;
    }

    public void setRegistrationAuthority(String registrationAuthority) {
        this.registrationAuthority = registrationAuthority;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getBusinessTermBegin() {
        return businessTermBegin;
    }

    public void setBusinessTermBegin(Date businessTermBegin) {
        this.businessTermBegin = businessTermBegin;
    }

    public Date getBusinessTermEnd() {
        return businessTermEnd;
    }

    public void setBusinessTermEnd(Date businessTermEnd) {
        this.businessTermEnd = businessTermEnd;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public Double getRegistrationCapital() {
        return registrationCapital;
    }

    public void setRegistrationCapital(Double registrationCapital) {
        this.registrationCapital = registrationCapital;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}