package com.yundao.tenant.web.dto.project.financing;

import com.yundao.core.base.model.BaseModel;

import java.io.Serializable;
import java.util.Date;

public class BaseAmFinancingRound extends BaseModel implements Serializable {
    /**
	 * 项目id
	 */
    private Long projectId;

    /**
	 * 轮次
	 */
    private Integer round;

    /**
	 * 融资时间
	 */
    private Date time;

    private static final long serialVersionUID = 1L;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}