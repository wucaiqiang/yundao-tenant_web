package com.yundao.tenant.web.dto.customer.imports;


/**
 * 客户导入提示
 *
 * @author chenyuanjian
 */
public class ImportAlertDto {

    /**
     * 表格行号
     */
    private Integer rowNumber;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 客户名称提示信息
     */
    private String nameAlert;

    /**
     * 手机号码提示信息
     */
    private String mobileAlert;

    /**
     * 有效性提示信息
     */
    private String statusAlert;

    /**
     * 投资偏好提示信息
     */
    private String investTypeAlert;

    /**
     * 银行卡账号提示信息
     */
    private String bankAccountAlert;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobileAlert() {
        return mobileAlert;
    }

    public void setMobileAlert(String mobileAlert) {
        this.mobileAlert = mobileAlert;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getNameAlert() {
        return nameAlert;
    }

    public void setNameAlert(String nameAlert) {
        this.nameAlert = nameAlert;
    }

    public String getStatusAlert() {
        return statusAlert;
    }

    public void setStatusAlert(String statusAlert) {
        this.statusAlert = statusAlert;
    }

    public String getInvestTypeAlert() {
        return investTypeAlert;
    }

    public void setInvestTypeAlert(String investTypeAlert) {
        this.investTypeAlert = investTypeAlert;
    }

    public String getBankAccountAlert() {
        return bankAccountAlert;
    }

    public void setBankAccountAlert(String bankAccountAlert) {
        this.bankAccountAlert = bankAccountAlert;
    }
}
