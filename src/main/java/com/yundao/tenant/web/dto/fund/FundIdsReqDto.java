package com.yundao.tenant.web.dto.fund;


import io.swagger.annotations.ApiModelProperty;

/**
 * 基金ids
 *
 * @author jan
 * @create 2017-11-25 19:29
 **/
public class FundIdsReqDto {

    @ApiModelProperty(value = "基金id，多个逗号分隔")
    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}