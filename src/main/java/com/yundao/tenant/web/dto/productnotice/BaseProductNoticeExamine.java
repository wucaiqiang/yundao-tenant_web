package com.yundao.tenant.web.dto.productnotice;

import com.yundao.core.base.model.BaseModel;

import java.io.Serializable;
import java.util.List;

public class BaseProductNoticeExamine extends BaseModel implements Serializable {
    /**
	 * 公告id
	 */
    private Long noticeId;

    /**
     * 产品ID
     */
    private String productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
	 * 标题
	 */
    private String title;

    /**
	 * 内容
	 */
    private String content;

    /**
	 * 公告类型
	 */
    private String noticeType;

    /**
	 * 审核状态 1未提交  2审核中  3已通过  4已驳回  5 已撤销
	 */
    private Integer status;

    /**
	 * 原因
	 */
    private String reason;

    /**
	 * 申请人
	 */
    private String createUser;

    /**
	 * 审核人
	 */
    private String updateUser;

    /**
     * 附件
     */
    private List<BaseProductNoticeAttach> baseProductNoticeAttach;

    private static final long serialVersionUID = 1L;

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public List<BaseProductNoticeAttach> getBaseProductNoticeAttach() {
        return baseProductNoticeAttach;
    }

    public void setBaseProductNoticeAttach(List<BaseProductNoticeAttach> baseProductNoticeAttach) {
        this.baseProductNoticeAttach = baseProductNoticeAttach;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}