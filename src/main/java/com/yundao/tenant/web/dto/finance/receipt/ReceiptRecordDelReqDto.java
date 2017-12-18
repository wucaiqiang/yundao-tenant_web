package com.yundao.tenant.web.dto.finance.receipt;


import io.swagger.annotations.ApiModelProperty;

/**
 * 回款记录删除
 *
 * @author jan
 * @create 2017-10-15 20:41
 **/
public class ReceiptRecordDelReqDto {

    @ApiModelProperty(value = "回款记录id，多个逗号分隔")
    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

}