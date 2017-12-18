package com.yundao.tenant.web.dto.product;

import io.swagger.annotations.ApiModelProperty;

/**
 * 回款计划产品下拉选项
 *
 * @author jan
 * @create 2017-10-12 16:27
 **/
public class ProductSelectionForDeclaration {

    @ApiModelProperty(value = "产品id")
    private Long id;

    @ApiModelProperty(value = "产品名称")
    private String name;

    @ApiModelProperty(value = "产品发行状态(0:未上线; 1:上线准备中; 2:预售; 3:募集中; 4:募集结束; 5:存续封闭中;6:清算退出)")
    private Long issuedStatus;

    @ApiModelProperty(value = "募集形式： 1：直接报单: 2：先预约在报单")
    private String declarationModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Long getIssuedStatus() {
	
		return issuedStatus;
	}

	public void setIssuedStatus(Long issuedStatus) {
	
		this.issuedStatus = issuedStatus;
	}

	public String getDeclarationModel() {
	
		return declarationModel;
	}

	public void setDeclarationModel(String declarationModel) {
	
		this.declarationModel = declarationModel;
	}

}
