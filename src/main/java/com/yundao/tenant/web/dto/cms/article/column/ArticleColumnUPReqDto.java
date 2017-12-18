
package com.yundao.tenant.web.dto.cms.article.column;

import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.number.Number;
import io.swagger.annotations.ApiModelProperty;

public class ArticleColumnUPReqDto{

    @ApiModelProperty(value = "ID")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}")
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "封面图片")
    private String coverUrl;

    @ApiModelProperty(value = "seo title")
    private String seoTitle;

    @ApiModelProperty(value = "seo keywords")
    private String seoKeywords;

    @ApiModelProperty(value = "seo description")
    private String seoDescription;

    @ApiModelProperty(value = "排序，越小越靠前")
    private Integer sequence;

    @ApiModelProperty(value = "状态，0：停用，1：启用")
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName (){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getCoverUrl (){
        return coverUrl;
    }

    public void setCoverUrl (String coverUrl){
        this.coverUrl = coverUrl;
    }

    public String getSeoTitle (){
        return seoTitle;
    }

    public void setSeoTitle (String seoTitle){
        this.seoTitle = seoTitle;
    }

    public String getSeoKeywords (){
        return seoKeywords;
    }

    public void setSeoKeywords (String seoKeywords){
        this.seoKeywords = seoKeywords;
    }

    public String getSeoDescription (){
        return seoDescription;
    }

    public void setSeoDescription (String seoDescription){
        this.seoDescription = seoDescription;
    }

    public Integer getSequence (){
        return sequence;
    }

    public void setSequence (Integer sequence){
        this.sequence = sequence;
    }

    public Integer getStatus (){
        return status;
    }

    public void setStatus (Integer status){
        this.status = status;
    }

}
