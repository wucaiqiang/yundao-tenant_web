package com.yundao.tenant.web.dto;

import java.util.List;

/**
 * Created by gjl on 2017/11/24.
 */
public class UpdateMultipleDto {
    private List<UpdateOnlyReqDto> data;

    public List<UpdateOnlyReqDto> getData() {
        return data;
    }

    public void setData(List<UpdateOnlyReqDto> data) {
        this.data = data;
    }
}
