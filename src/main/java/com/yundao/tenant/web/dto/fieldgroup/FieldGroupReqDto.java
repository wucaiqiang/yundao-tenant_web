
package com.yundao.tenant.web.dto.fieldgroup;

import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.number.Number;
import io.swagger.annotations.ApiModelProperty;

public class FieldGroupReqDto {
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "名字")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "是否启用，0：否，1：是")
    private Integer isEnabled;

    @ApiModelProperty(value = "关联的产品要素")
    private String fieldGroupRelIds;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public String getName (){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getDescription (){
        return description;
    }

    public void setDescription (String description){
        this.description = description;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public void setFieldGroupRelIds(String fieldGroupRelIds) {
        this.fieldGroupRelIds = fieldGroupRelIds;
    }

    public String getFieldGroupRelIds() {
        return fieldGroupRelIds;
    }
}
