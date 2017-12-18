package com.yundao.tenant.web.dto.common;


/**
 * 文本值dto
 *
 * @author jan
 * @create 2017-07-14 PM8:41
 **/
public class LabelValueDto {
    /**
     * 文本
     */
    private String label;

    /**
     * 值
     */
    private String value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
