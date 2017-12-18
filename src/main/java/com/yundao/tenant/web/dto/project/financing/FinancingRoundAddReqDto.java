
package com.yundao.tenant.web.dto.project.financing;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class FinancingRoundAddReqDto {
    @ApiModelProperty(value = "项目id")
    private Long projectId;

    @ApiModelProperty(value = "轮次")
    private Integer round;

    @ApiModelProperty(value = "融资时间")
    private Date time;


    public Long getProjectId (){
        return projectId;
    }

    public void setProjectId (Long projectId){
        this.projectId = projectId;
    }

    public Integer getRound (){
        return round;
    }

    public void setRound (Integer round){
        this.round = round;
    }

    public Date getTime (){
        return time;
    }

    public void setTime (Date time){
        this.time = time;
    }

}
