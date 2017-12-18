package com.yundao.tenant.web.dto.project.foundimport;

/**
 * Created by gjl on 2017/11/23.
 */
public class FoundImportPageResDto extends BaseAmProjectFoundImport {
    private String fundName;
    private String projectName;
    private Integer round;
    private String roundText;


    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getRoundText() {
        return roundText;
    }

    public void setRoundText(String roundText) {
        this.roundText = roundText;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
