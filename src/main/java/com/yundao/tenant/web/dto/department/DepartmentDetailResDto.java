package com.yundao.tenant.web.dto.department;

import io.swagger.annotations.ApiModelProperty;

/**
 * 部门详情dto
 *
 * @author jan
 * @create 2017-07-02 AM11:36
 **/
public class DepartmentDetailResDto {


    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private Integer id;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    private String name;

    /**
     * 父级id
     */
    @ApiModelProperty(value = "父级id")
    private long parentId;

    /**
     * 父级部门名称
     */
    @ApiModelProperty(value = "父级部门名称")
    private String parentName;

    private Long createUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }
}
