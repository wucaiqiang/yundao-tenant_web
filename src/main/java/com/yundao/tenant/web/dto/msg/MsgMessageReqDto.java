package com.yundao.tenant.web.dto.msg;

import com.yundao.tenant.web.dto.BasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by gjl on 2017/8/23.
 */
public class MsgMessageReqDto extends BasePageDto {
    @ApiModelProperty(value = "1、代办 ，2、消息")
    private Integer firstType;

    public Integer getFirstType() {
        return firstType;
    }

    public void setFirstType(Integer firstType) {
        this.firstType = firstType;
    }
}
