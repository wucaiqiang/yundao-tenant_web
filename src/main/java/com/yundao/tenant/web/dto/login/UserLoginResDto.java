
package com.yundao.tenant.web.dto.login;

import java.io.Serializable;

/**
 * Function: Reason: Date: 2017年7月17日 上午10:08:35
 * 
 * @author wucq
 * @version
 */
public class UserLoginResDto implements Serializable {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String mobile;
	private String username;
	private String email;
	private String password;
	private String ticket;
	private String tenantId;
	private String realName;

	/**
	 * 是否修改过密码，1：是，0：否
	 */
	private Integer onceEditPwd;

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {

		this.id = id;
	}

	public String getMobile() {

		return mobile;
	}

	public void setMobile(String mobile) {

		this.mobile = mobile;
	}

	public String getUsername() {

		return username;
	}

	public void setUsername(String username) {

		this.username = username;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public String getTicket() {

		return ticket;
	}

	public void setTicket(String ticket) {

		this.ticket = ticket;
	}

	public String getTenantId() {

		return tenantId;
	}

	public void setTenantId(String tenantId) {

		this.tenantId = tenantId;
	}

	public String getRealName() {
	
		return realName;
	}

	public void setRealName(String realName) {
	
		this.realName = realName;
	}

	public Integer getOnceEditPwd() {
		return onceEditPwd;
	}

	public void setOnceEditPwd(Integer onceEditPwd) {
		this.onceEditPwd = onceEditPwd;
	}
}
