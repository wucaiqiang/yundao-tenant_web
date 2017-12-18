package com.yundao.tenant.web.controller.cms.article.column;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.cms.article.column.*;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Function:
 * Reason:
 * Date:     2017年10月18日 下午3:59:08
 *
 * @author 欧阳利
 */
@RestController
@RequestMapping("/cms/article/column")
@ResponseBody
@Api("内容配置-->文章栏目配置")
public class ArticleColumnController {

    @ApiOperation(value = "添加文章栏目")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Long> add(@ModelAttribute ArticleColumnReqDto reqDto) throws BaseException {
        return HttpUtils.post(TenantUrl.ARTICLE_COLUMN_ADD, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<Long>>
                () {
        });
    }


    @ApiOperation(value = "列表查询")
    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    public Result<PaginationSupport<ArticleColumnPageResDto>> getPage(@ModelAttribute ArticleColumnPageReqDto reqDto) throws BaseException {
        return HttpUtils.get(TenantUrl.ARTICLE_COLUMN_PAGE, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<PaginationSupport<ArticleColumnPageResDto>>>
                () {
        });
    }

    @ApiOperation(value = "删除文章栏目")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Integer> delete(@RequestParam String ids) throws BaseException {
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        return HttpUtils.post(TenantUrl.ARTICLE_COLUMN_DELETE, params, new BaseTypeReference<Result<Integer>>
                () {
        });
    }

    @ApiOperation(value = "编辑文章栏目")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Integer> update(@ModelAttribute ArticleColumnUPReqDto reqDto) throws BaseException {
        return HttpUtils.post(TenantUrl.ARTICLE_COLUMN_UPDATE, ArgsUtils.toMap(reqDto), new BaseTypeReference<Result<Integer>>
                () {
        });
    }

    @ApiOperation(value = "获取指定平台下的栏目")
    @RequestMapping(value = "/get_select_option", method = RequestMethod.GET)
    public Result<List<ArticleColumnSelectDto>> getPage(@RequestParam Long platformId) throws BaseException {
        return HttpUtils.get(TenantUrl.GET_ARTICLE_COLUMN_SELECT_OPTION, ArgsUtils.toIdMap(platformId, "platformId"), new
                BaseTypeReference<Result<List<ArticleColumnSelectDto>>>() {
                });
    }
}

