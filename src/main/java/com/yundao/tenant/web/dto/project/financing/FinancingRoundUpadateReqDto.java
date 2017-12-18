
package com.yundao.tenant.web.dto.project.financing;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class FinancingRoundUpadateReqDto {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "融资时间")
    private Date time;

    public Date getTime (){
        return time;
    }

    public void setTime (Date time){
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
