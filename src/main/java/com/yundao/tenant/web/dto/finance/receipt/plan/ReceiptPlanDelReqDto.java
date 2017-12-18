package com.yundao.tenant.web.dto.finance.receipt.plan;


import io.swagger.annotations.ApiModelProperty;

/**
 * 回款计划删除
 *
 * @author jan
 * @create 2017-10-13 13:37
 **/
public class ReceiptPlanDelReqDto {

    @ApiModelProperty(value = "回款计划id，多个逗号分隔")
    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
