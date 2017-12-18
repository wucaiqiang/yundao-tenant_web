package com.yundao.tenant.web.dto.user.password;

import com.yundao.tenant.web.constant.CodeConstant;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用户密码校验
 *
 * @author jan
 * @create 2017-11-27 14:52
 **/
public class UserCheckPwdReqDto {

    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "{" + CodeConstant.CODE_1200121 + "}")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
