
package com.yundao.tenant.web.dto.video;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.yundao.tenant.web.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

public class VideoReqDto extends AbstractBasePageDto {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "视频名称")
	private String name;

	@ApiModelProperty(value = "状态0:压缩中 1：压缩完成，多个逗号隔开")
	private String statuss;
	private List<Integer> statusList;
	@ApiModelProperty(value = "创建人名称")
	private String createUserName;

	@ApiModelProperty(value = "创建时间开始")
	private Date createDateBegin;
	@ApiModelProperty(value = "创建时间结束")
	private Date createDateEnd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatuss() {
	
		return statuss;
	}

	public void setStatuss(String statuss) {
	
		this.statuss = statuss;
	}

	public String getCreateUserName() {

		return createUserName;
	}

	public void setCreateUserName(String createUserName) {

		this.createUserName = createUserName;
	}

	public Date getCreateDateBegin() {

		return createDateBegin;
	}

	public void setCreateDateBegin(Date createDateBegin) {

		this.createDateBegin = createDateBegin;
	}

	public Date getCreateDateEnd() {

		return createDateEnd;
	}

	public void setCreateDateEnd(Date createDateEnd) {

		this.createDateEnd = createDateEnd;
	}

	public List<Integer> getStatusList() {
		if (StringUtils.isNotBlank(this.statuss)) {
			String[] statuses = this.statuss.split(",");
			List<Integer> result=new ArrayList<>();
			for (int i = 0; i < statuses.length; i++) {
				result.add(NumberUtils.toInt(statuses[i]));
			}
			return result;
		}
		return statusList;
	}

	public void setStatusList(List<Integer> statusList) {

		this.statusList = statusList;
	}

}
