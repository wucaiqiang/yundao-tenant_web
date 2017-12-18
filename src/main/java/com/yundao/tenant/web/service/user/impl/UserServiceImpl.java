package com.yundao.tenant.web.service.user.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.user.UserUpdateReqDto;
import com.yundao.tenant.web.service.resource.ResourceService;
import com.yundao.tenant.web.service.user.UserService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends AbstractService implements UserService {

    @Autowired
    private ResourceService resourceService;

    /**
     * 获取当前用户部门下面的所有用户id集合
     */
    @Override
    public List<Long> getCurrentUserDepartmentUserIds() throws BaseException {
        Result<List<Long>> result = HttpUtils.post(TenantUrl.GET_CURRENT_USER_DEPARTMENT_USERIDS, null, new BaseTypeReference<Result<List<Long>>>() {
        });
        if (!result.getSuccess()) {
            throw new BaseException(result.getCode(), result.getMessage());
        }
        List<Long> userIds = result.getResult();
        if (BooleanUtils.isEmpty(userIds)) {
            throw new BaseException(1, "获取当前用户所属部门的所有用户异常");
        }
        return userIds;
    }

    @Override
    public Result<Long> modifyUser(UserUpdateReqDto useReqDto) throws Exception {
        Result<Long> result = HttpUtils.post(TenantUrl.MODIFY_USER, ArgsUtils.toMap(useReqDto), new
                BaseTypeReference<Result<Long>>() {
                });
        return result;
    }

}
