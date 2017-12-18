package com.yundao.tenant.web.service.dictionary.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.dictionary.DictionaryDto;
import com.yundao.tenant.web.service.dictionary.DictionaryService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据字典服务实现
 *
 * @author jan
 * @create 2017-11-28 15:01
 **/
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Override
    public Result<List<DictionaryDto>> gets(String codes) throws BaseException {
        return HttpUtils.get(TenantUrl.GET_Dictionaries, ArgsUtils.toIdMap(codes, "codes"), new BaseTypeReference<Result<List<DictionaryDto>>>() {
        });
    }
}
