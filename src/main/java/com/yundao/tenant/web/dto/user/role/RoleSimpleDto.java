package com.yundao.tenant.web.dto.user.role;

public class RoleSimpleDto {
    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 姓名
     */
    private String roleName;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


}
