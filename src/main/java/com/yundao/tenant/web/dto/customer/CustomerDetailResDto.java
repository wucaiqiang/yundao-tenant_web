

package com.yundao.tenant.web.dto.customer;

import com.yundao.tenant.web.dto.common.DataAndPermissionDto;
import com.yundao.tenant.web.dto.customer.follow.CustomerFollowUpPageDto;
import com.yundao.tenant.web.dto.tag.TagDto;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Function:
 * Reason:
 * Date:     2017年8月9日 上午11:00:38
 *
 * @author wucq
 */
public class CustomerDetailResDto implements Serializable {


    /**
     * serialVersionUID:
     */
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    private Long id;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 客户手机号码
     */
    private String mobile;

    /**
     * 客户编号
     */
    private String number;

    /**
     * 用户所属理财师ID
     */
    private Long userId;

    /**
     * 是否关注
     */
    private boolean focus;

    /**
     * 客户标签
     */
    private List<TagDto> tags;
    @ApiModelProperty("风险测评结果")
	private String riskText;

    /**
     * 客户联系方式
     */
    private DataAndPermissionDto<CustomerContactDto> contact;

    /**
     * 除了联系方式外其它资料
     */
    private DataAndPermissionDto<CustomerInfoDto> info;

    /**
     * 跟进数据
     */
    private DataAndPermissionDto<CustomerFollowUpPageDto> follow;

    @ApiModelProperty("客户状态")
    private Integer status;

    @ApiModelProperty("客户状态名称")
    private String statusText;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public boolean isFocus() {

        return focus;
    }

    public void setFocus(boolean focus) {

        this.focus = focus;
    }

    public void setContact(DataAndPermissionDto<CustomerContactDto> contact) {

        this.contact = contact;
    }

    public List<TagDto> getTags() {

        return tags;
    }

    public void setTags(List<TagDto> tags) {

        this.tags = tags;
    }

    public Long getUserId() {

        return userId;
    }

    public void setUserId(Long userId) {

        this.userId = userId;
    }

    public DataAndPermissionDto<CustomerContactDto> getContact() {

        return contact;
    }

    public DataAndPermissionDto<CustomerInfoDto> getInfo() {

        return info;
    }

    public void setInfo(DataAndPermissionDto<CustomerInfoDto> info) {

        this.info = info;
    }

    public String getMobile() {

        return mobile;
    }

    public void setMobile(String mobile) {

        this.mobile = mobile;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getNumber() {

        return number;
    }

    public void setNumber(String number) {

        this.number = number;
    }


    public DataAndPermissionDto<CustomerFollowUpPageDto> getFollow() {
        return follow;
    }

    public void setFollow(DataAndPermissionDto<CustomerFollowUpPageDto> follow) {
        this.follow = follow;
    }

	public String getRiskText() {
	
		return riskText;
	}

	public void setRiskText(String riskText) {
	
		this.riskText = riskText;
	}

	public void setStatusText(String statusText) {
	
		this.statusText = statusText;
	}
}

