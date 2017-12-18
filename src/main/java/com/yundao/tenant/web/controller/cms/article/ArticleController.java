package com.yundao.tenant.web.controller.cms.article;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.cms.article.*;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 文章控制器
 *
 * @author jan
 * @create 2017-10-21 10:39
 **/
@Controller
@RequestMapping("/cms/article/")
@ResponseBody
@Api("内容配置-->文章管理")
public class ArticleController {

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation("获取文章分页数据")
    public Result<PaginationSupport<ArticlePageResDto>> getPage(@ModelAttribute ArticlePageReqDto dto) throws BaseException {
        return HttpUtils.get(TenantUrl.GET_ARTICLE_PAGE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<ArticlePageResDto>>>() {
        });
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation("删除文章")
    public Result<PermissionResultDto> delete(@ModelAttribute ArticleDeleteReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.DELETE_ARTICLE, ArgsUtils.toMap(dto), new BaseTypeReference<Result<PermissionResultDto>>
                () {
        });
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation("新增文章")
    public Result<Long> add(@ModelAttribute ArticleAddReqDto dto) throws Exception{
        return HttpUtils.post(TenantUrl.ADD_ARTICLE,ArgsUtils.toMap(dto),new BaseTypeReference<Result<Long>>(){});
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation("编辑文章")
    public Result<Long> update(@ModelAttribute ArticleUpdateReqDto dto) throws Exception{
        return HttpUtils.post(TenantUrl.UPDATE_ARTICLE,ArgsUtils.toMap(dto),new BaseTypeReference<Result<Long>>(){});
    }
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ApiOperation("获取文章详情")
    public Result<ArticleDetailResDto> get(@RequestParam Long id) throws Exception{
        return HttpUtils.get(TenantUrl.GET_ARTICLE,ArgsUtils.toIdMap(id),new BaseTypeReference<Result<ArticleDetailResDto>>(){});
    }
}
