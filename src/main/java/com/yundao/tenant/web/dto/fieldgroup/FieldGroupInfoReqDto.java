
package com.yundao.tenant.web.dto.fieldgroup;

import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.number.Number;
import io.swagger.annotations.ApiModelProperty;

public class FieldGroupInfoReqDto {
    private Long id;

    @ApiModelProperty(value = "名字")
    private String name;

    @ApiModelProperty(value = "是否启用，0：否，1：是")
    private Integer isEnabled;


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

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }
}
