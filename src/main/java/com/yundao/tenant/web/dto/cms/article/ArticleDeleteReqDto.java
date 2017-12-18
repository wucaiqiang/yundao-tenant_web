package com.yundao.tenant.web.dto.cms.article;


import io.swagger.annotations.ApiModelProperty;

/**
 * 文章删除请求dto
 *
 * @author jan
 * @create 2017-10-20 17:46
 **/
public class ArticleDeleteReqDto {

    @ApiModelProperty(value = "文章id，多个逗号分隔")
    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
