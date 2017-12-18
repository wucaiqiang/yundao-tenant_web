package com.yundao.tenant.web.dto.project.decision.suggestion;


import com.yundao.tenant.web.dto.project.decision.DecisionSuggestionDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jan
 * @create 2017-11-21 08:17
 **/
public class DecisionSuggestionListResDto {

    @ApiModelProperty(value = "是否能编辑")
    private Boolean canEdit;

    @ApiModelProperty(value = "是否能删除")
    private Boolean canDelete;

    @ApiModelProperty(value = "意见列表")
    private List<DecisionSuggestionDto> suggestions;

    public Boolean getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
    }

    public Boolean getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Boolean canDelete) {
        this.canDelete = canDelete;
    }

    public List<DecisionSuggestionDto> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<DecisionSuggestionDto> suggestions) {
        this.suggestions = suggestions;
    }
}
