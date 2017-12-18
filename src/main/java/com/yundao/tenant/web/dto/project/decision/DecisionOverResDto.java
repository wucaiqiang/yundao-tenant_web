package com.yundao.tenant.web.dto.project.decision;

import java.util.Date;

/**
 * Created by gjl on 2017/11/23.
 */
public class DecisionOverResDto extends BaseAmDecision {
    private String overUser;
    private Date overDate;
    private String roundText;

    public String getOverUser() {
        return overUser;
    }

    public void setOverUser(String overUser) {
        this.overUser = overUser;
    }

    public Date getOverDate() {
        return overDate;
    }

    public void setOverDate(Date overDate) {
        this.overDate = overDate;
    }

    public String getRoundText() {
        return roundText;
    }

    public void setRoundText(String roundText) {
        this.roundText = roundText;
    }
}
