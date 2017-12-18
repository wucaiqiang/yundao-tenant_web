package com.yundao.tenant.web.dto.project.financing;

import com.yundao.core.base.model.BaseModel;

import java.io.Serializable;

public class BaseAmFinancing extends BaseModel implements Serializable {
    /**
	 * 项目id
	 */
    private Long finacingRoundId;

    /**
	 * 投资方，来源；1：内部基金产品，2：其他
	 */
    private Integer investmentSource;

    /**
	 * 基金id
	 */
    private Long fundId;

    /**
	 * 基金名称
	 */
    private String fundName;

    /**
	 * 出资金额
	 */
    private Double investmentAmount;

    /**
	 * 占股比例
	 */
    private Double shareRatio;

    /**
	 * 添加方式，1：手动添加，2：立项通过自动添加
	 */
    private Integer insertType;

    private static final long serialVersionUID = 1L;

    public Long getFinacingRoundId() {
        return finacingRoundId;
    }

    public void setFinacingRoundId(Long finacingRoundId) {
        this.finacingRoundId = finacingRoundId;
    }

    public Integer getInvestmentSource() {
        return investmentSource;
    }

    public void setInvestmentSource(Integer investmentSource) {
        this.investmentSource = investmentSource;
    }

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public Double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(Double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public Double getShareRatio() {
        return shareRatio;
    }

    public void setShareRatio(Double shareRatio) {
        this.shareRatio = shareRatio;
    }

    public Integer getInsertType() {
        return insertType;
    }

    public void setInsertType(Integer insertType) {
        this.insertType = insertType;
    }
}