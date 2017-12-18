package com.yundao.tenant.web.dto.fieldgroup;

import com.yundao.tenant.web.dto.bo.ObjectFieldPageResDto;
import com.yundao.tenant.web.dto.product.ProductManagerListResDto;
import com.yundao.tenant.web.dto.product.ProductSelectOptionDto;

import java.util.List;

/**
 * Created by gjl on 2017/7/6.
 */
public class FieldGroupRelDto {
    private BaseFieldGroup fieldGroup;
    private List<ObjectFieldPageResDto> existObjectField;
    private List<ObjectFieldPageResDto> allObjectField;
    private List<ProductSelectOptionDto> productList;

    public FieldGroupRelDto(BaseFieldGroup fieldGroup, List<ObjectFieldPageResDto> existObjectField, List<ObjectFieldPageResDto> allObjectField,List<ProductSelectOptionDto> productList) {
        this.fieldGroup = fieldGroup;
        this.existObjectField = existObjectField;
        this.allObjectField = allObjectField;
        this.productList = productList;
    }

    public FieldGroupRelDto() {
    }

    public BaseFieldGroup getFieldGroup() {
        return fieldGroup;
    }

    public void setFieldGroup(BaseFieldGroup fieldGroup) {
        this.fieldGroup = fieldGroup;
    }

    public List<ObjectFieldPageResDto> getExistObjectField() {
        return existObjectField;
    }

    public void setExistObjectField(List<ObjectFieldPageResDto> existObjectField) {
        this.existObjectField = existObjectField;
    }

    public List<ObjectFieldPageResDto> getAllObjectField() {
        return allObjectField;
    }

    public void setAllObjectField(List<ObjectFieldPageResDto> allObjectField) {
        this.allObjectField = allObjectField;
    }

    public List<ProductSelectOptionDto> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductSelectOptionDto> productList) {
        this.productList = productList;
    }
}
