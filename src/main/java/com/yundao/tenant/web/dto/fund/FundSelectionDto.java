package com.yundao.tenant.web.dto.fund;


import io.swagger.annotations.ApiModelProperty;

/**
 * 基金选项
 *
 * @author jan
 * @create 2017-11-25 17:54
 **/
public class FundSelectionDto {

    @ApiModelProperty(value = "基金id")
    private Long id;

    @ApiModelProperty(value = "基金名称")
    private String name;

    @ApiModelProperty(value = "是否有编辑权限")
    private Boolean editPermission;

    @ApiModelProperty(value = "负责人")
    private Long receiverId;

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

    public Boolean getEditPermission() {
        return editPermission;
    }

    public void setEditPermission(Boolean editPermission) {
        this.editPermission = editPermission;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }
}
