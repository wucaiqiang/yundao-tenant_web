package com.yundao.tenant.web.dto.productnotice;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by gjl on 2017/7/12.
 */
public class ProductNoticeModel extends BaseProductNotice {
    private String productName;
    private String noticeTypeName;
    private Boolean canProcess = true;
    private String notCanProcess;

    public Boolean getCanProcess() {
        return canProcess;
    }

    public void setCanProcess(Boolean canProcess) {
        this.canProcess = canProcess;
    }

    public String getNotCanProcess() {
        return notCanProcess;
    }

    public void setNotCanProcess(String notCanProcess) {
        this.notCanProcess = notCanProcess;
    }

    @ApiModelProperty("申请人名称")
    private String applyUserRealName;
    
    @ApiModelProperty("是否是申请人")
    private boolean isApplyUser;
    
    @ApiModelProperty("创建人名称")
    private String createUserRealName;
    
    
    public String getCreateUserRealName() {
	
		return createUserRealName;
	}

	public void setCreateUserRealName(String createUserRealName) {
	
		this.createUserRealName = createUserRealName;
	}
    
    public boolean isApplyUser() {
	
		return isApplyUser;
	}

	public void setApplyUser(boolean isApplyUser) {
	
		this.isApplyUser = isApplyUser;
	}

	private List<BaseProductNoticeAttach> baseProductNoticeAttach;

    public String getApplyUserRealName() {
	
		return applyUserRealName;
	}

	public void setApplyUserRealName(String applyUserRealName) {
	
		this.applyUserRealName = applyUserRealName;
	}

	public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getNoticeTypeName() {
        return noticeTypeName;
    }

    public void setNoticeTypeName(String noticeTypeName) {
        this.noticeTypeName = noticeTypeName;
    }

    public List<BaseProductNoticeAttach> getBaseProductNoticeAttach() {
        return baseProductNoticeAttach;
    }

    public void setBaseProductNoticeAttach(List<BaseProductNoticeAttach> baseProductNoticeAttach) {
        this.baseProductNoticeAttach = baseProductNoticeAttach;
    }
}
