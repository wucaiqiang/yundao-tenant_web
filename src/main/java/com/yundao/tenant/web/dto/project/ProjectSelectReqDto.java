package com.yundao.tenant.web.dto.project;


import com.yundao.tenant.web.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * 项目分页列表数据返回dto
 *
 * @author jan
 * @create 2017-11-17 14:02
 **/
public class ProjectSelectReqDto{

    @ApiModelProperty(value = "项目名称")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}