package com.yundao.tenant.web.dto.sale.declaration.audit;


import com.yundao.tenant.web.annotation.FieldCode;
import com.yundao.tenant.web.annotation.Owner;
import com.yundao.tenant.web.constant.field.code.Contact;
import com.yundao.tenant.web.constant.field.code.Customer;
import com.yundao.tenant.web.util.DateUtils;
import io.swagger.annotations.ApiModelProperty;

/**
 * 报单审核返回数据dto
 *
 * @author jan
 * @create 2017-08-27 PM2:49
 **/
public class DeclarationAuditPageResDto {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "预约编号")
    private String number;

    @ApiModelProperty(value = "客户id")
    private Long customerId;

    @FieldCode(Customer.NAME)
    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "产品id")
    private Long productId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "预约金额(募集进度使用)")
    private String reservationSumAmount;

    @ApiModelProperty(value = "报单金额(募集进度使用)")
    private String declarationSumAmount;

    @ApiModelProperty(value = "认购金额")
    private String dealAmount;

    @ApiModelProperty(value = "打款日期")
    private String payDate;

    @ApiModelProperty(value = "是否已上传打款凭证")
    private Integer hasPayEvidence;

    @ApiModelProperty(value = "是否已上传打款凭证文本")
    private String hasPayEvidenceText;

    @ApiModelProperty(value = "提交时间")
    private String commitDate;

    @ApiModelProperty(value = "提交人")
    private String reservationor;

    @ApiModelProperty(value = "操作时间")
    private String operationDate;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "状态文本")
    private String statusText;

    @ApiModelProperty(value = "是否可以进行审核操作")
    private Boolean isCanAudit;

    @Owner
    @ApiModelProperty(value = "客户所属理财师id")
    private Long fpId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getReservationSumAmount() {
        return reservationSumAmount;
    }

    public void setReservationSumAmount(String reservationSumAmount) {
        this.reservationSumAmount = reservationSumAmount;
    }

    public String getDeclarationSumAmount() {
        return declarationSumAmount;
    }

    public void setDeclarationSumAmount(String declarationSumAmount) {
        this.declarationSumAmount = declarationSumAmount;
    }

    public String getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(String dealAmount) {
        this.dealAmount = dealAmount;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = DateUtils.formatExactDay(payDate);
    }

    public Integer getHasPayEvidence() {
        return hasPayEvidence;
    }

    public void setHasPayEvidence(Integer hasPayEvidence) {
        this.hasPayEvidence = hasPayEvidence;
    }

    public String getHasPayEvidenceText() {
        return hasPayEvidenceText;
    }

    public void setHasPayEvidenceText(String hasPayEvidenceText) {
        this.hasPayEvidenceText = hasPayEvidenceText;
    }

    public String getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(String commitDate) {
        this.commitDate = DateUtils.formatExactMinute(commitDate);
    }

    public String getReservationor() {
        return reservationor;
    }

    public void setReservationor(String reservationor) {
        this.reservationor = reservationor;
    }

    public String getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(String operationDate) {
        this.operationDate = DateUtils.formatExactMinute(operationDate);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Boolean getCanAudit() {
        return isCanAudit;
    }

    public void setCanAudit(Boolean canAudit) {
        isCanAudit = canAudit;
    }

    public Long getFpId() {
        return fpId;
    }

    public void setFpId(Long fpId) {
        this.fpId = fpId;
    }

}
