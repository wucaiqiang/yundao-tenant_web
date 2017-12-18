
package com.yundao.tenant.web.dto.productnotice;

import io.swagger.annotations.ApiModelProperty;

public class ProductNoticeTypeReqDto {
    @ApiModelProperty(value = "类型名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

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

}
