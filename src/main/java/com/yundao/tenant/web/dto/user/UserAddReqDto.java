package com.yundao.tenant.web.dto.user;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * 添加用户请求参数dto
 *
 * @author 欧阳利
 *         2017年6月22日
 */
public class UserAddReqDto {

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private Long departmentId;


//    /**
//     * 用户名
//     */
//    @ApiModelProperty(value = "用户名")
//    private String username;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    private String realName;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String mobile;

//    /**
//     * 邮箱
//     */
//    @ApiModelProperty(value = "邮箱")
//    private String email;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 角色id集合
     */
    @ApiModelProperty(value = "角色id集合,多个角色使用逗号分割开")
    private String roleIds;

    /**
     * 工号
     */
    @ApiModelProperty(value = "工号")
    private String jobNumber;

//    /**
//     * 系统集合
//     */
//    @ApiModelProperty(value = "系统集合code, 多个系统code使用逗号分割开")
//    private List<String> systemCodes;
    /**
     * 领导id
     */
    @ApiModelProperty(value = "领导id")
    private Long leaderId;
    
	public Long getLeaderId() {
		return leaderId;
	}


	public void setLeaderId(Long leaderId) {
		this.leaderId = leaderId;
	}
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }




    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getRoleIds() {
		return roleIds;
	}


	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}





}
