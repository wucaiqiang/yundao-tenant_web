package com.yundao.tenant.web.dto.dictionary;

import com.yundao.tenant.web.dto.common.LabelValueDto;

import java.util.List;

/**
 * 数据字典dto
 *
 * @author jan
 * @create 2017-07-16 PM8:16
 **/
public class DictionaryDto {

    /**
     * 文本
     */
    private String label;

    /**
     * 值
     */
    private String value;

    /**
     * 选项
     */
    private List<LabelValueDto> selections;

    public List<LabelValueDto> getSelections() {
        return selections;
    }

    public void setSelections(List<LabelValueDto> selections) {
        this.selections = selections;
    }

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
