package com.yundao.tenant.web.dto.department;


import io.swagger.annotations.ApiModelProperty;

/**
 * 添加部门dto
 *
 * @author jan
 * @create 2017-07-02 AM10:57
 **/
public class DepartmentAddReqDto {


    /**
     * 名字
     */
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



    public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	private static final long serialVersionUID = 1000L;

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
