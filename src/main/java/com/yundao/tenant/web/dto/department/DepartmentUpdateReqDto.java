package com.yundao.tenant.web.dto.department;

import com.yundao.tenant.web.annotation.FieldCode;
import io.swagger.annotations.ApiModelProperty;

/**
 * 修改部门dto
 *
 * @author jan
 * @create 2017-07-02 AM11:38
 **/
public class DepartmentUpdateReqDto {


    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private Long id;

    /**
     * 名称
     */
    @FieldCode("product")
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 父级id
     */
    @ApiModelProperty(value = "父级id")
    private Long parentId;

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

    private static final Long serialVersionUID = 1000L;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
}
