package com.yundao.tenant.web.dto.role;


import io.swagger.annotations.ApiModelProperty;

/**
 * 添加或更新角色
 *
 * @author jan
 * @create 2017-06-22 PM3:00
 **/
public class RoleReqDto {

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
}
