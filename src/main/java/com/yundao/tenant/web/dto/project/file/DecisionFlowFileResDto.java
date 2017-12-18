package com.yundao.tenant.web.dto.project.file;


import com.yundao.tenant.web.util.DateUtils;
import io.swagger.annotations.ApiModelProperty;

/**
 * 立项流文件返回dto
 *
 * @author jan
 * @create 2017-11-24 10:46
 **/
public class DecisionFlowFileResDto {

    @ApiModelProperty(value = "文件id")
    private Long id;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    private String createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = DateUtils.formatExactDay(createDate);
    }
}
