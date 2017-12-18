package com.yundao.tenant.web.dto.dataobject;


import com.yundao.tenant.web.dto.common.LabelValueDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 权限选项
 *
 * @author jan
 * @create 2017-07-14 PM8:38
 **/
public class DataObjectSelectionDto {

    /**
     * 初始化的值
     */
    @ApiModelProperty(value = "初始化的值")
    private Integer initValue;

    /**
     * 所有选项
     */
    @ApiModelProperty(value = "所有选项")
    private List<LabelValueDto> childs;

    public Integer getInitValue() {
        return initValue;
    }

    public void setInitValue(Integer initValue) {
        this.initValue = initValue;
    }

    public List<LabelValueDto> getChilds() {
        return childs;
    }

    public void setChilds(List<LabelValueDto> childs) {
        this.childs = childs;
    }
}
