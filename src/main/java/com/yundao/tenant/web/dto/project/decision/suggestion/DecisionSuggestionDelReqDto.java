package com.yundao.tenant.web.dto.project.decision.suggestion;

import io.swagger.annotations.ApiModelProperty;

/**
 * 立项意见删除dto
 *
 * @author jan
 * @create 2017-11-20 20:47
 **/
public class DecisionSuggestionDelReqDto {

    @ApiModelProperty(value = "id，多个逗号分隔")
    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
