package com.yundao.tenant.web.controller.project.decision;


import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.web.dto.project.decision.flow.DecisionFlowFileIdReqDto;
import com.yundao.tenant.web.dto.project.decision.flow.DecisionFlowFileReqDto;
import com.yundao.tenant.web.dto.project.decision.flow.DecisionFlowRemarkReqDto;
import com.yundao.tenant.web.dto.project.file.DecisionFlowFileResDto;
import com.yundao.tenant.web.service.am.project.decision.flow.DecisionFlowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 立项流程控制器
 *
 * @author jan
 * @create 2017-11-22 14:26
 **/
@Controller
@RequestMapping("/assets/project/decision/flow")
@ResponseBody
@Api("项目管理 - 立项投决 - 立项流程")
public class DecisionFlowController {

    @Autowired
    private DecisionFlowService decisionFlowService;

    @RequestMapping(value = "/add_file", method = RequestMethod.POST)
    @ApiOperation("添加文件")
    public Result<DecisionFlowFileResDto> addFile(@ModelAttribute DecisionFlowFileReqDto dto) throws BaseException {
        return decisionFlowService.addFile(dto);
    }

    @RequestMapping(value = "/delete_file", method = RequestMethod.POST)
    @ApiOperation("删除文件")
    public Result<Boolean> deleteFile(@ModelAttribute DecisionFlowFileIdReqDto dto) throws BaseException {
        return decisionFlowService.deleteFile(dto);
    }

    @RequestMapping(value = "/update_remark", method = RequestMethod.POST)
    @ApiOperation("编辑备注")
    public Result<Long> updateRemark(@ModelAttribute DecisionFlowRemarkReqDto dto) throws BaseException {
        return decisionFlowService.updateRemark(dto);
    }

}
