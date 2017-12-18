
package com.yundao.tenant.web.dto.customer.customer;

import java.io.Serializable;

import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Insert;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.length.Length;
import com.yundao.core.validator.number.Number;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.dto.common.DataDto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: Reason: Date: 2017年8月9日 下午1:52:42
 * 
 * @author wucq
 * @version
 */
public class CustomerContactReqDto implements Serializable {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "新增不需要传")
	private Long id;

	/**
	 * 手机号码
	 */
	@ApiModelProperty(value = "手机号码")
	private String mobile;
	/**
	 * 微信
	 */
	@ApiModelProperty(value = "微信")
	private String wechat;
	/**
	 * qq
	 */
	@ApiModelProperty(value = "qq")
	private String qq;
	/**
	 * 邮箱
	 */
	@ApiModelProperty(value = "邮箱")
	private String email;


	public String getMobile() {

		return mobile;
	}

	public void setMobile(String mobile) {

		this.mobile = mobile;
	}

	public String getWechat() {

		return wechat;
	}

	public void setWechat(String wechat) {

		this.wechat = wechat;
	}

	public String getQq() {

		return qq;
	}

	public void setQq(String qq) {

		this.qq = qq;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}
	
}
