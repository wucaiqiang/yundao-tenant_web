package com.yundao.tenant.web.dto.project.industry;


import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 更新行业
 *
 * @author jan
 * @create 2017-11-18 08:17
 **/
public class IndustryUpdateReqDto extends IndustryAddReqDto {

    @ApiModelProperty(value = "行业id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}