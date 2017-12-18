package com.yundao.tenant.web.dto.user.visit;


import com.yundao.core.utils.DateUtils;
import io.swagger.annotations.ApiModelProperty;

/**
 * 客户回访添加数据dto
 *
 * @author jan
 * @create 2017-08-29 PM4:04
 **/
public class UserVisitAddReqDto {

    @ApiModelProperty(value = "回访数据id")
    private Long id;

    @ApiModelProperty(value = "回访时间")
    private String visitDate;

    @ApiModelProperty(value = "回访方式")
    private Integer type;

    @ApiModelProperty(value = "回访状态")
    private Integer status;

    @ApiModelProperty(value = "回访内容")
    private String content;

    @ApiModelProperty(value = "下次回访时间")
    private String nextTime;


    @ApiModelProperty(value = "客户状态 ")
    private Integer customerStatus;
    
    public Integer getCustomerStatus() {
	
		return customerStatus;
	}

	public void setCustomerStatus(Integer customerStatus) {
	
		this.customerStatus = customerStatus;
	}

	public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        boolean validDate = DateUtils.isValidDate(visitDate, DateUtils.YYYY_MM_DD_HH_MM);
        if (validDate)
            this.visitDate = visitDate + ":00";
        else
            this.visitDate = visitDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNextTime() {
        return nextTime;
    }

    public void setNextTime(String nextTime) {
        boolean validDate = DateUtils.isValidDate(nextTime, DateUtils.YYYY_MM_DD_HH_MM);
        if (validDate)
            this.nextTime = nextTime + ":00";
        else
            this.nextTime = nextTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
