package com.yundao.tenant.web.dto.project.file;

import com.yundao.core.base.model.BaseModel;

import java.io.Serializable;

public class BaseAmProjectFile extends BaseModel implements Serializable {
    /**
	 * 项目id
	 */
    private Long projectId;

    /**
	 * 项目文件名
	 */
    private String sourceName;

    /**
	 * 文件地址
	 */
    private String url;

    /**
	 * 类型
	 */
    private String type;

    /**
	 * 扩展名
	 */
    private String extName;

    private static final long serialVersionUID = 1L;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }
}