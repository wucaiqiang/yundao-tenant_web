package com.yundao.tenant.web.service.user;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.web.dto.user.UserUpdateReqDto;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public interface UserService {

    List<Long> getCurrentUserDepartmentUserIds() throws BaseException;

    /**
     * 修改用户信息
     */
    Result<Long> modifyUser(@ModelAttribute UserUpdateReqDto UseReqDto) throws Exception;
}
