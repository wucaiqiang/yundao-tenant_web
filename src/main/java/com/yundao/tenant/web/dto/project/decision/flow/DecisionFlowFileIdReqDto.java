package com.yundao.tenant.web.dto.project.decision.flow;


import io.swagger.annotations.ApiModelProperty;

/**
 * 删除流程文件dto
 *
 * @author jan
 * @create 2017-11-22 14:51
 **/
public class DecisionFlowFileIdReqDto {

    @ApiModelProperty(value = "流程文件id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
