
package com.yundao.tenant.web.dto.project.file;

import io.swagger.annotations.ApiModelProperty;


public class ProjectFileReqDto {
    @ApiModelProperty(value = "项目id")
    private Long projectId;

    @ApiModelProperty(value = "项目文件名")
    private String sourceName;

    @ApiModelProperty(value = "文件地址")
    private String url;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "扩展名")
    private String extName;

    public Long getProjectId (){
        return projectId;
    }

    public void setProjectId (Long projectId){
        this.projectId = projectId;
    }

    public String getSourceName (){
        return sourceName;
    }

    public void setSourceName (String sourceName){
        this.sourceName = sourceName;
    }

    public String getUrl (){
        return url;
    }

    public void setUrl (String url){
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExtName (){
        return extName;
    }

    public void setExtName (String extName){
        this.extName = extName;
    }

}
