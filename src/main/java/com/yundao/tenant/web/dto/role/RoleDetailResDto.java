package com.yundao.tenant.web.dto.role;

import io.swagger.annotations.ApiModelProperty;

/**
 * 查询角色dto
 *
 * @author jan
 * @create 2017-07-01 PM3:53
 **/

public class RoleDetailResDto {

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private Long id;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String name;

    /**
     * 是否系统预置
     */
    @ApiModelProperty(value = "是否系统预置")
    private Integer isSystem;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
    }
}

