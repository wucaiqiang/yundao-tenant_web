package com.yundao.tenant.web.service.dictionary;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.web.dto.dictionary.DictionaryDto;

import java.util.List;

/**
 * 数据字典服务接口
 *
 * @author jan
 * @create 2017-11-28 14:54
 **/
public interface DictionaryService {

    Result<List<DictionaryDto>> gets(String codes) throws BaseException;

}
