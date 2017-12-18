package com.yundao.tenant.web.controller.roadshow;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.web.dto.roadshow.BaseRoadshowColumn;
import com.yundao.tenant.web.dto.roadshow.RoadshowColumnAddReqDto;
import com.yundao.tenant.web.dto.roadshow.RoadshowColumnReqDto;
import com.yundao.tenant.web.dto.roadshow.RoadshowColumnResDto;
import com.yundao.tenant.web.dto.roadshow.RoadshowColumnUpdateReqDto;
import com.yundao.tenant.web.service.roadshow.RoadshowColumnService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/roadshow/column/")
@ResponseBody
@Api("路演栏目表")
public class RoadshowColumnController{

    @Autowired
    private RoadshowColumnService roadshowColumnService;

    @RequestMapping(value = "get_page",method=RequestMethod.GET)
    @ApiOperation(value="分页查询路演栏目表")
    public Result<PaginationSupport<RoadshowColumnResDto>> getPage(@ModelAttribute RoadshowColumnReqDto dto) throws Exception{
		return roadshowColumnService.getPage(dto);
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增路演栏目表", notes="根据RoadshowColumn对象创建路演栏目表")
    public Result<Long> add(@Validated @ModelAttribute RoadshowColumnAddReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return roadshowColumnService.add(reqDto);
    }

    @RequestMapping(value = "update", method=RequestMethod.POST)
    @ApiOperation(value="编辑路演栏目表信息")
    public Result<Long> update(@Validated @ModelAttribute RoadshowColumnUpdateReqDto reqDto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return roadshowColumnService.update(reqDto);
    }

    @RequestMapping(value = "get", method=RequestMethod.GET)
    @ApiOperation(value="获取路演栏目表详细信息")
    public Result<RoadshowColumnResDto> get(@RequestParam Long id) throws Exception{
       return roadshowColumnService.get(id);
    }
    @RequestMapping(value = "get_by_platform_id", method = RequestMethod.GET)
	@ApiOperation(value = "获取路演栏目表详细信息")
	public Result<List<BaseRoadshowColumn>> getsByPlatformId(@RequestParam Long platformId) throws Exception {
		return roadshowColumnService.getsByPlatformId(platformId);
	}
    
    @RequestMapping(value = "delete", method=RequestMethod.POST)
    @ApiOperation(value="删除路演栏目表信息")
    public Result<Integer> delete(@RequestParam String ids) throws Exception{
        return roadshowColumnService.delete(ids);
    }

}
