package com.yundao.tenant.web.dto.department;

import com.yundao.tenant.web.annotation.FieldCode;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 部门列表
 *
 * @author jan
 * @create 2017-07-05 PM10:24
 **/
public class DepartmentListResDto {


    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private Long id;

    /**
     * 子部门
     */
    @ApiModelProperty(value = "子部门")
    private List<DepartmentListResDto> childs;

    /**
     * 名字
     */
    @FieldCode("product_name")
    @ApiModelProperty(value = "名字")
    private String name;

    /**
     * 编码（最小八位数，最大支持八层，从00000001开始）
     */
    @ApiModelProperty(value = "编码（最小八位数，最大支持八层，从00000001开始）")
    private String code;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
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

    public List<DepartmentListResDto> getChilds() {
        return childs;
    }

    public void setChilds(List<DepartmentListResDto> childs) {
        this.childs = childs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
