package com.yundao.tenant.web.dto.project.decision;


import io.swagger.annotations.ApiModelProperty;

/**
 * 立项投决
 *
 * @author jan
 * @create 2017-11-18 14:55
 **/
public class DecisionIdReqDto {

    @ApiModelProperty(value = "立项投决id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
