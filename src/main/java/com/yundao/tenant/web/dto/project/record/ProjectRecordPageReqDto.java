package com.yundao.tenant.web.dto.project.record;

import com.yundao.tenant.web.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jan
 * @create 2017-11-22 16:16
 **/
public class ProjectRecordPageReqDto extends AbstractBasePageDto {

    @ApiModelProperty(value = "项目id")
    private Long projectId;

    @ApiModelProperty(value = "操作人")
    private String creator;

    @ApiModelProperty(value = "部门")
    private String department;

    @ApiModelProperty(value = "时间 - 开始")
    private String createDateBegin;

    @ApiModelProperty(value = "时间 - 结束")
    private String createDateEnd;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCreateDateBegin() {
        return createDateBegin;
    }

    public void setCreateDateBegin(String createDateBegin) {
        this.createDateBegin = createDateBegin;
    }

    public String getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(String createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
