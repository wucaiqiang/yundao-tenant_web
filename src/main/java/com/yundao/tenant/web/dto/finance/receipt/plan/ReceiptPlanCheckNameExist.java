package com.yundao.tenant.web.dto.finance.receipt.plan;


import io.swagger.annotations.ApiModelProperty;

/**
 * 检查回款计划名称是否存在
 *
 * @author jan
 * @create 2017-10-13 08:28
 **/
public class ReceiptPlanCheckNameExist {

    @ApiModelProperty(value = "回款计划名称")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
