
package com.yundao.tenant.web.dto.project.financing;


import io.swagger.annotations.ApiModelProperty;

public class FinancingPageResDto extends BaseAmFinancing{
    @ApiModelProperty("用户名称")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
