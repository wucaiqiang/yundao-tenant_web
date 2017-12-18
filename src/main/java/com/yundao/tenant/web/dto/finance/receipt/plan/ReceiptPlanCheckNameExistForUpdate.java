package com.yundao.tenant.web.dto.finance.receipt.plan;


import io.swagger.annotations.ApiModelProperty;

/**
 * 检查回款计划名称是否存在（更新操作）
 *
 * @author jan
 * @create 2017-10-13 08:29
 **/
public class ReceiptPlanCheckNameExistForUpdate extends ReceiptPlanCheckNameExist {

    @ApiModelProperty(value = "回款计划id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
