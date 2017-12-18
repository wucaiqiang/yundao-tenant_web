package com.yundao.tenant.web.dto.resource;

import io.swagger.annotations.ApiModelProperty;

/**
 * 角色权限资源DTO
 *
 * @author jan
 * @create 2017-07-01 PM3:59
 **/
public class RoleResourceDto extends ResourceResDto {

    /**
     * 是否选中 1：是；0：否
     */
    @ApiModelProperty("表示角色是否拥有该资源；1：是；0：否")
    private Integer check;

    public Integer getCheck() {
        return check;
    }

    public void setCheck(Integer check) {
        this.check = check;
    }
}
