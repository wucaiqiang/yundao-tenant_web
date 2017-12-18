package com.yundao.tenant.web.dto.customercenter;


import io.swagger.annotations.ApiModelProperty;

/**
 * 预约产品数据请求dto
 *
 * @author jan
 * @create 2017-09-07 PM3:57
 **/
public class ConsultProductReqDto {

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "产品id,可为空")
    private Long productId;

    @ApiModelProperty(value = "产品名称，可为空，当无法根据id找到产品，使用该值")
    private String productName;

    @ApiModelProperty(value = "渠道")
    private Integer channel;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
