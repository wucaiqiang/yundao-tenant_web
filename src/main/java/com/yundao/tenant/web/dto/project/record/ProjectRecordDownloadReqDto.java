package com.yundao.tenant.web.dto.project.record;


import io.swagger.annotations.ApiModelProperty;

/**
 * 下载文件上报
 *
 * @author jan
 * @create 2017-11-23 08:29
 **/
public class ProjectRecordDownloadReqDto {

    @ApiModelProperty(value = "文件id")
    private Long fileId;

    @ApiModelProperty(value = "类型；1：项目文档，2：立项流程文件")
    private Integer type;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
