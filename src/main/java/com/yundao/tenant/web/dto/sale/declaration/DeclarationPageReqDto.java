
package com.yundao.tenant.web.dto.sale.declaration;

import com.yundao.tenant.web.dto.BasePageDto;
import com.yundao.tenant.web.util.DateUtils;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class DeclarationPageReqDto extends BasePageDto {
    @ApiModelProperty(value = "报单编号")
    private String number;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "认购开始金额")
    private String dealAmountStart;

    @ApiModelProperty(value = "认购结束金额")
    private String dealAmountEnd;

    @ApiModelProperty(value = "打款日期开始")
    private Date payDateStart;

    @ApiModelProperty(value = "打款日期结束")
    private Date payDateEnd;

    @ApiModelProperty(value = "是否已上传打款凭证；1：是，0：否")
    private Integer hasPayEvidence;

    @ApiModelProperty(value = "报单状态， 0：未提交  1：审核中  2：已通过  3：已驳回  4： 已取消")
    private String statuss;

    @ApiModelProperty(value = "报单时间开始")
    private Date commitDateStart;

    @ApiModelProperty(value = "报单时间结束")
    private Date commitDateEnd;

    @ApiModelProperty(value = "创建时间开始")
    private Date createDateStart;

    @ApiModelProperty(value = "创建时间结束")
    private Date createDateEnd;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDealAmountStart() {
        return dealAmountStart;
    }

    public void setDealAmountStart(String dealAmountStart) {
        this.dealAmountStart = dealAmountStart;
    }

    public String getDealAmountEnd() {
        return dealAmountEnd;
    }

    public void setDealAmountEnd(String dealAmountEnd) {
        this.dealAmountEnd = dealAmountEnd;
    }

    public Date getPayDateStart() {
        return payDateStart;
    }

    public void setPayDateStart(Date payDateStart) {
        this.payDateStart = payDateStart;
    }


    public Date getPayDateEnd() {
        return payDateEnd;
    }

    public void setPayDateEnd(Date payDateEnd) {
        this.payDateEnd = DateUtils.toEndDate(payDateEnd);
    }

    public Integer getHasPayEvidence() {
        return hasPayEvidence;
    }

    public void setHasPayEvidence(Integer hasPayEvidence) {
        this.hasPayEvidence = hasPayEvidence;
    }

    public Date getCommitDateStart() {
        return commitDateStart;
    }

    public void setCommitDateStart(Date commitDateStart) {
        this.commitDateStart = commitDateStart;
    }

    public Date getCommitDateEnd() {
        return commitDateEnd;
    }

    public void setCommitDateEnd(Date commitDateEnd) {
        this.commitDateEnd = DateUtils.toEndDate(commitDateEnd);
    }

    public String getStatuss() {
        return statuss;
    }

    public void setStatuss(String statuss) {
        this.statuss = statuss;
    }

    public Date getCreateDateStart() {
        return createDateStart;
    }

    public void setCreateDateStart(Date createDateStart) {
        this.createDateStart = createDateStart;
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }
}
