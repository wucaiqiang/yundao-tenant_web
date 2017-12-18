
package com.yundao.tenant.web.dto.fieldgroup;

import io.swagger.annotations.ApiModelProperty;

public class FieldGroupRelReqDto {
    private Long id;

    @ApiModelProperty(value = "关联的产品要素")
    private String fieldGroupRelIds;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public void setFieldGroupRelIds(String fieldGroupRelIds) {
        this.fieldGroupRelIds = fieldGroupRelIds;
    }

    public String getFieldGroupRelIds() {
        return fieldGroupRelIds;
    }
}
