package com.yundao.tenant.web.dto.finance.receipt.plan;


import io.swagger.annotations.ApiModelProperty;

/**
 * 移除关联报单请求dto
 *
 * @author jan
 * @create 2017-10-16 09:27
 **/
public class DeclarationRelDelReqDto {

    @ApiModelProperty(value = "报单id，多个逗号分隔")
    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
