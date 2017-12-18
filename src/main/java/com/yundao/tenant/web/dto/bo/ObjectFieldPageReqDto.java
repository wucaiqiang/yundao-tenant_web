package com.yundao.tenant.web.dto.bo;

import com.yundao.tenant.web.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * 业务对象字段分页请求参数dto
 *
 * @author jan
 * @create 2017-07-04 AM9:30
 **/
public class ObjectFieldPageReqDto extends AbstractBasePageDto {

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 类型文本
     */
    @ApiModelProperty(value = "类型文本")
    private String typeText;

    /**
     * 业务对象模块编码
     */
    private String boCode;

    /**
     * 是否必填，0：否；1：是
     */
    @ApiModelProperty(value = "是否必填，0：否；1：是")
    private Integer isMandatory;


    /**
     * 是否通用，0：否；1：是
     */
    @ApiModelProperty(value = "是否通用，0：否；1：是")
    private Integer isShare;


    /**
     * 是否启用，0：否；1：是
     */
    @ApiModelProperty(value = "是否启用，0：否；1：是")
    private Integer isEnabled;


    /**
     * 权限限制
     */
    @ApiModelProperty(value = "权限限制，0：全部可见；1：部分可见")
    private Integer access;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }

    public Integer getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(Integer isMandatory) {
        this.isMandatory = isMandatory;
    }

    public Integer getIsShare() {
        return isShare;
    }

    public void setIsShare(Integer isShare) {
        this.isShare = isShare;
    }


    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public String getBoCode() {
        return boCode;
    }

    public void setBoCode(String boCode) {
        this.boCode = boCode;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }
}
