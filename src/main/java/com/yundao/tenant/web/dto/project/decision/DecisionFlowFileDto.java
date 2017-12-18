package com.yundao.tenant.web.dto.project.decision;


import com.yundao.tenant.web.util.DateUtils;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jan
 * @create 2017-11-19 15:17
 **/
public class DecisionFlowFileDto {

    @ApiModelProperty(value = "文件id")
    private Long id;

    @ApiModelProperty(value = "立项流程id")
    private Long decisionFlowId;

    @ApiModelProperty(value = "文件名称")
    private String name;

    @ApiModelProperty(value = "文件扩展名")
    private String extName;

    @ApiModelProperty(value = "创建者")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    private String createDate;

    @ApiModelProperty("url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = DateUtils.formatExactDay(createDate);
    }

    public Long getDecisionFlowId() {
        return decisionFlowId;
    }

    public void setDecisionFlowId(Long decisionFlowId) {
        this.decisionFlowId = decisionFlowId;
    }
}
