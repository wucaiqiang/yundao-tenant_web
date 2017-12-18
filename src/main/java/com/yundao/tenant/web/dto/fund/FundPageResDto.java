package com.yundao.tenant.web.dto.fund;


import com.yundao.tenant.web.util.DateUtils;
import io.swagger.annotations.ApiModelProperty;

/**
 * 基金分页列表dto
 *
 * @author jan
 * @create 2017-11-23 16:40
 **/
public class FundPageResDto {

    @ApiModelProperty(value = "基金id")
    private Long id;

    @ApiModelProperty(value = "基金名称")
    private String name;

    @ApiModelProperty(value = "类别id")
    private Long typeId;

    @ApiModelProperty(value = "类别名称")
    private String typeName;

    @ApiModelProperty(value = "基金等级")
    private String level;

    @ApiModelProperty(value = "基金等级文本")
    private String levelText;

    @ApiModelProperty(value = "风险等级")
    private Integer riskLevel;

    @ApiModelProperty(value = "风险等级文本")
    private String riskLevelText;

    @ApiModelProperty(value = "募集规模")
    private String productScale;

    @ApiModelProperty(value = "已投金额")
    private String investAmountTotal;

    @ApiModelProperty(value = "已退金额")
    private String withdrawalAmountTotal;

    @ApiModelProperty(value = "基金负责人id")
    private Long receiverId;

    @ApiModelProperty(value = "基金负责人名称")
    private String receiverName;

    @ApiModelProperty(value = "创建时间")
    private String createDate;

    @ApiModelProperty(value = "发行状态")
    private Integer issuedStatus;

    @ApiModelProperty(value = "发行状态文本")
    private String issuedStatusText;

    @ApiModelProperty(value = "已导入的产品id，为空表示没有导入")
    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevelText() {
        return levelText;
    }

    public void setLevelText(String levelText) {
        this.levelText = levelText;
    }

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getRiskLevelText() {
        return riskLevelText;
    }

    public void setRiskLevelText(String riskLevelText) {
        this.riskLevelText = riskLevelText;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getInvestAmountTotal() {
        return investAmountTotal;
    }

    public void setInvestAmountTotal(String investAmountTotal) {
        this.investAmountTotal = investAmountTotal;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = DateUtils.formatExactDay(createDate);
    }

    public Integer getIssuedStatus() {
        return issuedStatus;
    }

    public void setIssuedStatus(Integer issuedStatus) {
        this.issuedStatus = issuedStatus;
    }

    public String getIssuedStatusText() {
        return issuedStatusText;
    }

    public void setIssuedStatusText(String issuedStatusText) {
        this.issuedStatusText = issuedStatusText;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getWithdrawalAmountTotal() {
        return withdrawalAmountTotal;
    }

    public void setWithdrawalAmountTotal(String withdrawalAmountTotal) {
        this.withdrawalAmountTotal = withdrawalAmountTotal;
    }
}
