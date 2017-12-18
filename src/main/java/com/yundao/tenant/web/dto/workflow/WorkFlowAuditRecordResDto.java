package com.yundao.tenant.web.dto.workflow;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * @author jan
 * @create 2017-12-05 20:35
 **/
public class WorkFlowAuditRecordResDto {

    @ApiModelProperty("业务类型名称")
    private String typeText;

    @ApiModelProperty("业务类型")
    private String type;

    @ApiModelProperty("业务number")
    private String businessNo;

    @ApiModelProperty("是否已完成，1：是，0：否")
    private Integer isComplete;

    @ApiModelProperty("创建时间")
    private Date createDate;

    @ApiModelProperty("审核记录")
    private List<AuditDetailResDTO> auditList;

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public Integer getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Integer isComplete) {
        this.isComplete = isComplete;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<AuditDetailResDTO> getAuditList() {
        return auditList;
    }

    public void setAuditList(List<AuditDetailResDTO> auditList) {
        this.auditList = auditList;
    }
}
