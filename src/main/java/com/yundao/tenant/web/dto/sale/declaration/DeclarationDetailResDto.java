package com.yundao.tenant.web.dto.sale.declaration;

import com.yundao.tenant.web.dto.common.DataPermissionDto;

/**
 * Created by gjl on 2017/8/28.
 */
public class DeclarationDetailResDto{
    private DeclarationResDto data;

    private DataPermissionDto permission;

    public DeclarationResDto getData() {
        return data;
    }

    public void setData(DeclarationResDto data) {
        this.data = data;
    }

    public DataPermissionDto getPermission() {
        return permission;
    }

    public void setPermission(DataPermissionDto permission) {
        this.permission = permission;
    }
}
