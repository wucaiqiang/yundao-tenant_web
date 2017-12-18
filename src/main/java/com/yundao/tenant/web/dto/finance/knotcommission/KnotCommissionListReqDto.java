
package com.yundao.tenant.web.dto.finance.knotcommission;

import com.yundao.tenant.web.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

public class KnotCommissionListReqDto{
    @ApiModelProperty(value = "报单ID")
    private Long declarationId;


    public Long getDeclarationId (){
        return declarationId;
    }

    public void setDeclarationId (Long declarationId){
        this.declarationId = declarationId;
    }
}
