
package com.yundao.tenant.web.dto.fieldgroup;

import com.yundao.tenant.web.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

public class FieldGroupPageDto extends AbstractBasePageDto{
    @ApiModelProperty(value = "开始创建时间")
    private String createDateBegin;

    @ApiModelProperty(value = "结束时间")
    private String createDateEnd;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "是否启用，0：否，1：是")
    private Integer isEnabled;

    @ApiModelProperty(value = "关联的产品要素")
    private String fieldGroupRelIds;

    public String getCreateDateBegin() {
        return createDateBegin;
    }

    public void setCreateDateBegin(String createDateBegin) {
        this.createDateBegin = createDateBegin;
    }

    public String getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(String createDateEnd) {
        this.createDateEnd = createDateEnd;
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

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getFieldGroupRelIds() {
        return fieldGroupRelIds;
    }

    public void setFieldGroupRelIds(String fieldGroupRelIds) {
        this.fieldGroupRelIds = fieldGroupRelIds;
    }
}
