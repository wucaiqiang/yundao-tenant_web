package com.yundao.tenant.web.dto.bo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 业务对象字段修改请求dto
 *
 * @author jan
 * @create 2017-07-09 PM5:31
 **/
public class ObjectFieldUpdateReqDto {


    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 要素名称
     */
    @ApiModelProperty(value = "要素名称")
    private String name;

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

    /**
     * 选中的角色id
     */
    @ApiModelProperty(value = "选中的角色id,多个逗号分隔")
    private String roleIds;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sequence;

    /**
     * 单位
     */
    @ApiModelProperty(value = "单位；数值、数值区间需要传值")
    private String unit;

    @ApiModelProperty(value = "业务对象编码，前端无需填写")
    private String boCode;

    @ApiModelProperty(value = "下拉选项、单选、多选需要传值", dataType = "value,text,sequence")
    private String selections;

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

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSelections() {
        return selections;
    }

    public void setSelections(String selections) {
        this.selections = selections;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getBoCode() {
        return boCode;
    }

    public void setBoCode(String boCode) {
        this.boCode = boCode;
    }
}
