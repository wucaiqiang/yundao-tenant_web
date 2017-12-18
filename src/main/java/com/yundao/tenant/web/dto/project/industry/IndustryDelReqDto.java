package com.yundao.tenant.web.dto.project.industry;

import io.swagger.annotations.ApiModelProperty;

/**
 * 删除行业
 *
 * @author jan
 * @create 2017-11-18 08:41
 **/
public class IndustryDelReqDto {

    @ApiModelProperty(value = "行业id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
