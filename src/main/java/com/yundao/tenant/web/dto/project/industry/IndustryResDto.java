package com.yundao.tenant.web.dto.project.industry;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 行业领域
 *
 * @author jan
 * @create 2017-11-18 08:54
 **/
public class IndustryResDto implements Serializable {

    @ApiModelProperty(value = "行业id")
    private String value;

    @ApiModelProperty(value = "行业名称")
    private String label;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
