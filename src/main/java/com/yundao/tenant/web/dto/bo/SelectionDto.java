package com.yundao.tenant.web.dto.bo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 选项
 *
 * @author jan
 * @create 2017-07-09 PM8:01
 **/
public class SelectionDto {

    /**
     * id
     */
    @ApiModelProperty(value = "选项id，更新操作使用")
    private Long id;

    /**
     * 选项文本
     */
    @ApiModelProperty(value = "选项文本")
    private String label;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sequence;

    @ApiModelProperty(value = "是否系统预置，0：否，1：是")
    private Integer isSystem;

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
    }
}
