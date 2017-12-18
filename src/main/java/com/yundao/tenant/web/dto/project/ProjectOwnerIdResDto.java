package com.yundao.tenant.web.dto.project;

/**
 * @author jan
 * @create 2017-11-21 20:43
 **/
public class ProjectOwnerIdResDto {

    /**
     * 项目id
     */
    private Long id;

    /**
     * 项目负责人
     */
    private Long leaderId;

    /**
     * 项目组员id
     */
    private String crewIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrewIds() {
        return crewIds;
    }

    public void setCrewIds(String crewIds) {
        this.crewIds = crewIds;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }
}

