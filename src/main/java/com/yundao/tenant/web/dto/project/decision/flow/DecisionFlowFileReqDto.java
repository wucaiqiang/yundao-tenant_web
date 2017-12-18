package com.yundao.tenant.web.dto.project.decision.flow;


import io.swagger.annotations.ApiModelProperty;

/**
 * 立项流程文件dto
 *
 * @author jan
 * @create 2017-11-22 14:31
 **/
public class DecisionFlowFileReqDto {

    @ApiModelProperty(value = "立项流程id")
    private Long flowId;

    @ApiModelProperty(value = "文件名称")
    private String name;

    @ApiModelProperty(value = "文件扩展名")
    private String extName;

    @ApiModelProperty(value = "文件地址")
    private String url;

    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
