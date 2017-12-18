package com.yundao.tenant.web.dto.project.investment;


/**
 * Created by gjl on 2017/11/27.
 */
public class InvestmentProjectResDto extends BaseAmInvestment {
    private String projectName;
    private String roundText;
    private String investLevelText;
    private String investTypeText;

    public String getInvestLevelText() {
        return investLevelText;
    }

    public void setInvestLevelText(String investLevelText) {
        this.investLevelText = investLevelText;
    }

    public String getInvestTypeText() {
        return investTypeText;
    }

    public void setInvestTypeText(String investTypeText) {
        this.investTypeText = investTypeText;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getRoundText() {
        return roundText;
    }

    public void setRoundText(String roundText) {
        this.roundText = roundText;
    }
}
