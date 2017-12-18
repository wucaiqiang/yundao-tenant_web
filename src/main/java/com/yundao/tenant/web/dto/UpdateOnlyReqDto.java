package com.yundao.tenant.web.dto;

import io.swagger.annotations.ApiParam;

/**
 * Created by gjl on 2017/11/17.
 */
public class UpdateOnlyReqDto {

    @ApiParam("数据ID")
    private Long id;
    @ApiParam("字段名")
    private String name;
    @ApiParam("字段值")
    private Object value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
