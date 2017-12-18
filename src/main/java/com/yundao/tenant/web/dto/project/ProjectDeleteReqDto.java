package com.yundao.tenant.web.dto.project;


/**
 * 项目删除请求dto
 *
 * @author jan
 * @create 2017-11-22 09:57
 **/
public class ProjectDeleteReqDto extends ProjectIdsReqDto {

    /**
     * 没有权限操作的项目id
     */
    private String noPermissionProjectIds;

    public String getNoPermissionProjectIds() {
        return noPermissionProjectIds;
    }

    public void setNoPermissionProjectIds(String noPermissionProjectIds) {
        this.noPermissionProjectIds = noPermissionProjectIds;
    }
}
