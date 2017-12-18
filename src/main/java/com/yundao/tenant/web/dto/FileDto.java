package com.yundao.tenant.web.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by gjl on 2017/7/20.
 */
public class FileDto {
    @ApiModelProperty(value = "附件url")
    private String fileUrl;

    @ApiModelProperty(value = "附件名称")
    private String fileName;

    @ApiModelProperty(value = "附件类型")
    private String fileType;

    /**
     * 云链接
     */
    private String url;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
