package com.yundao.tenant.web.dto.project.decision;


import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jan
 * @create 2017-11-19 15:15
 **/
public class DecisionFlowDto {

    @ApiModelProperty(value = "流程id")
    private Long flowId;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "排序值")
    private Integer sort;

    @ApiModelProperty(value = "审批状态")
    private Integer auditStatus;

    @ApiModelProperty(value = "审批状态文本")
    private String auditStatusText;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "是否已完成")
    private Boolean isComplete;

    @ApiModelProperty(value = "文件列表")
    private List<DecisionFlowFileDto> files;

    @ApiModelProperty(value = "是否可以修改")
    private Boolean canEdit;

    @ApiModelProperty(value = "审批提示文本")
    private String auditTips;

    @ApiModelProperty(value = "是否能提交审批")
    private Boolean canSubmit;

    @ApiModelProperty(value = "是否能重新提交审批")
    private Boolean canReSubmit;

    @ApiModelProperty(value = "审批被驳回文本")
    private String rejectText;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditStatusText() {
        return auditStatusText;
    }

    public void setAuditStatusText(String auditStatusText) {
        this.auditStatusText = auditStatusText;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<DecisionFlowFileDto> getFiles() {
        return files;
    }

    public void setFiles(List<DecisionFlowFileDto> files) {
        this.files = files;
    }

    public Boolean getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
    }

    public Boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }

    public String getAuditTips() {
        return auditTips;
    }

    public void setAuditTips(String auditTips) {
        this.auditTips = auditTips;
    }

    public Boolean getCanSubmit() {
        return canSubmit;
    }

    public void setCanSubmit(Boolean canSubmit) {
        this.canSubmit = canSubmit;
    }

    public Boolean getCanReSubmit() {
        return canReSubmit;
    }

    public void setCanReSubmit(Boolean canReSubmit) {
        this.canReSubmit = canReSubmit;
    }

    public String getRejectText() {
        return rejectText;
    }

    public void setRejectText(String rejectText) {
        this.rejectText = rejectText;
    }

    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }
}