package com.yundao.tenant.web.dto.cms.article;

/**
 * 文章分页数据
 *
 * @author jan
 * @create 2017-10-21 11:00
 **/
public class ArticleDetailResDto extends BaseArticle{
    private BaseArticleDetail articleDetail;

    private String columnIds;

    private String platformName;

    private String columnName;

    public String getColumnIds() {
        return columnIds;
    }

    public void setColumnIds(String columnIds) {
        this.columnIds = columnIds;
    }

    public BaseArticleDetail getArticleDetail() {
        return articleDetail;
    }

    public void setArticleDetail(BaseArticleDetail articleDetail) {
        this.articleDetail = articleDetail;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
