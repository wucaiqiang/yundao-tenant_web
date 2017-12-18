package com.yundao.tenant.web.controller.dataobject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.dataobject.DataObjectDetailResDto;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 数据对象控制器
 *
 * @author jan
 * @create 2017-07-15 AM10:55
 **/
@Controller
@RequestMapping("/data/object")
@ResponseBody
@Api("数据权限")
public class DataObjectController {


    @RequestMapping(value = "/gets", method = RequestMethod.GET)
    public Result<List<DataObjectDetailResDto>> gets(@RequestParam(required = false) Long roleId) throws BaseException {
        return HttpUtils.get(TenantUrl.GET_DATA_OBJECTS, ArgsUtils.toIdMap(roleId, "roleId"), new BaseTypeReference<Result<List<DataObjectDetailResDto>>>() {
        });
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新角色的数据权限")
    public Result<Long> update(@RequestParam Long roleId,
                               @RequestParam String selections) throws BaseException {
        Map<String, Object> params = new HashMap<>(2);
        params.put("roleId", roleId);
        params.put("selections", selections);
        return HttpUtils.post(TenantUrl.UPDATE_DATA_OBJECT, params, new BaseTypeReference<Result<Long>>() {
        });
    }

}
