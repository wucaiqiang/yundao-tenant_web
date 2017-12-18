package com.yundao.tenant.web.dto.cms.article;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class ArticleAddReqDto{
    /**
	 * 平台id
	 */
    @ApiModelProperty(value = "平台ID")
    private Long platformId;

    @ApiModelProperty(value = "文章栏目Ids")
    private String columnIds;

    /**
	 * 标题
	 */
    @ApiModelProperty(value = "文章标题")
    private String title;

    /**
	 * 封面图片
	 */
    @ApiModelProperty(value = "封面图片")
    private String coverUrl;

    /**
	 * 浏览量
	 */
    @ApiModelProperty(value = "浏览量")
    private Integer pageview;

    /**
	 * 发布时间
	 */
    @ApiModelProperty(value = "发布时间")
    private Date publishDate;

    /**
	 * 排序，越小越靠前
	 */
    @ApiModelProperty(value = "排序，越小越靠前")
    private Integer sequence;

    /**
	 * 状态，0：停用，1：启用
	 */
    @ApiModelProperty(value = "状态，0：停用，1：启用")
    private Integer status;

    @ApiModelProperty(value = "seo title")
    private String seoTitle;

    @ApiModelProperty(value = "seo keywords")
    private String seoKeywords;

    @ApiModelProperty(value = "seo description")
    private String seoDescription;

    @ApiModelProperty("文章导读")
    private String feature;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "文章来源")
    private String source;

    @ApiModelProperty("文章内容")
    private String content;



    private static final long serialVersionUID = 1L;

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Integer getPageview() {
        return pageview;
    }

    public void setPageview(Integer pageview) {
        this.pageview = pageview;
    }


    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getSeoKeywords() {
        return seoKeywords;
    }

    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    public String getColumnIds() {
        return columnIds;
    }

    public void setColumnIds(String columnIds) {
        this.columnIds = columnIds;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}