package com.yundao.tenant.web.dto.fund;


import com.yundao.tenant.web.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jan
 * @create 2017-11-23 17:22
 **/
public class FundPageReqDto extends AbstractBasePageDto {

    @ApiModelProperty(value = "范围；全部:all,启动直销的基金:imported,我关注的:focus")
    private String scope;

    @ApiModelProperty(value = "基金名称")
    private String name;

    @ApiModelProperty(value = "类别id，多个逗号分隔")
    private String typeIds;

    @ApiModelProperty(value = "基金等级,多个逗号分隔")
    private String levels;

    @ApiModelProperty(value = "风险等级,多个逗号分隔")
    private String riskLevels;

    @ApiModelProperty(value = "募集规模 - 开始")
    private String productScaleBegin;

    @ApiModelProperty(value = "募集规模 - 结束")
    private String productScaleEnd;

    @ApiModelProperty(value = "已投金额 - 开始")
    private String investAmountTotalBegin;

    @ApiModelProperty(value = "已投金额 - 结束")
    private String investAmountTotalEnd;

    @ApiModelProperty(value = "已退金额 - 开始")
    private String withdrawalAmountTotalBegin;

    @ApiModelProperty(value = "已退金额 - 结束")
    private String withdrawalAmountTotalEnd;

    @ApiModelProperty(value = "基金负责人名称")
    private String receiverName;

    @ApiModelProperty(value = "创建时间 - 开始")
    private String createDateBegin;

    @ApiModelProperty(value = "创建时间 - 结束")
    private String createDateEnd;

    @ApiModelProperty(value = "发行状态,多个逗号分隔")
    private String issuedStatuss;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeIds() {
        return typeIds;
    }

    public void setTypeIds(String typeIds) {
        this.typeIds = typeIds;
    }

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }

    public String getRiskLevels() {
        return riskLevels;
    }

    public void setRiskLevels(String riskLevels) {
        this.riskLevels = riskLevels;
    }

    public String getProductScaleBegin() {
        return productScaleBegin;
    }

    public void setProductScaleBegin(String productScaleBegin) {
        this.productScaleBegin = productScaleBegin;
    }

    public String getProductScaleEnd() {
        return productScaleEnd;
    }

    public void setProductScaleEnd(String productScaleEnd) {
        this.productScaleEnd = productScaleEnd;
    }

    public String getInvestAmountTotalBegin() {
        return investAmountTotalBegin;
    }

    public void setInvestAmountTotalBegin(String investAmountTotalBegin) {
        this.investAmountTotalBegin = investAmountTotalBegin;
    }

    public String getInvestAmountTotalEnd() {
        return investAmountTotalEnd;
    }

    public void setInvestAmountTotalEnd(String investAmountTotalEnd) {
        this.investAmountTotalEnd = investAmountTotalEnd;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
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

    public String getIssuedStatuss() {
        return issuedStatuss;
    }

    public void setIssuedStatuss(String issuedStatuss) {
        this.issuedStatuss = issuedStatuss;
    }

    public String getWithdrawalAmountTotalBegin() {
        return withdrawalAmountTotalBegin;
    }

    public void setWithdrawalAmountTotalBegin(String withdrawalAmountTotalBegin) {
        this.withdrawalAmountTotalBegin = withdrawalAmountTotalBegin;
    }

    public String getWithdrawalAmountTotalEnd() {
        return withdrawalAmountTotalEnd;
    }

    public void setWithdrawalAmountTotalEnd(String withdrawalAmountTotalEnd) {
        this.withdrawalAmountTotalEnd = withdrawalAmountTotalEnd;
    }
}
