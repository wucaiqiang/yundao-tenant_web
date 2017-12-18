package com.yundao.tenant.web.controller.dictionary;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.web.dto.dictionary.DictionaryDto;
import com.yundao.tenant.web.service.dictionary.DictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 数据字典控制器
 *
 * @author jan
 * @create 2017-07-16 PM8:15
 **/
@Controller
@RequestMapping("/dictionary")
@ResponseBody
@Api(value = "数据字典")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping(value = "/gets", method = RequestMethod.GET)
    @ApiOperation(value = "根据编码获取数据字典，多个以逗号分隔", notes = "codes请参考：https://www.tapd.cn/20185151/markdown_wikis/view/#1120185151001012832")
    public Result<List<DictionaryDto>> gets(@RequestParam String codes) throws BaseException {
        return dictionaryService.gets(codes);
    }
}
