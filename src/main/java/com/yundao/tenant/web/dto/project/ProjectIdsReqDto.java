package com.yundao.tenant.web.dto.project;


import io.swagger.annotations.ApiModelProperty;

/**
 * 项目IDdto
 *
 * @author jan
 * @create 2017-11-18 15:34
 **/
public class ProjectIdsReqDto {

    @ApiModelProperty(value = "项目id")
    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
