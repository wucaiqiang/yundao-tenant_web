package com.yundao.tenant.web.dto.project;


import com.yundao.tenant.web.dto.dictionary.DictionaryDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jan
 * @create 2017-11-20 15:09
 **/
public class ProjectScopeDto {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "状态范围")
    private List<DictionaryDto> statuss;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DictionaryDto> getStatuss() {
        return statuss;
    }

    public void setStatuss(List<DictionaryDto> statuss) {
        this.statuss = statuss;
    }
}
