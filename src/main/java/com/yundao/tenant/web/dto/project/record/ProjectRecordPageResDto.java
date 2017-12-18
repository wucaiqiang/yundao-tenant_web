package com.yundao.tenant.web.dto.project.record;

import io.swagger.annotations.ApiModelProperty;

/**
 * 项目记录分页数据
 *
 * @author jan
 * @create 2017-11-22 16:11
 **/
public class ProjectRecordPageResDto {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "操作人")
    private String creator;

    @ApiModelProperty(value = "部门")
    private String department;

    @ApiModelProperty(value = "时间")
    private String createDate;

    @ApiModelProperty(value = "行为信息")
    private String actionInfo;

    @ApiModelProperty(value = "项目负责人id")
    private Long leaderId;

    @ApiModelProperty(value = "组员id")
    private String crewIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getActionInfo() {
        return actionInfo;
    }

    public void setActionInfo(String actionInfo) {
        this.actionInfo = actionInfo;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    public String getCrewIds() {
        return crewIds;
    }

    public void setCrewIds(String crewIds) {
        this.crewIds = crewIds;
    }
}
