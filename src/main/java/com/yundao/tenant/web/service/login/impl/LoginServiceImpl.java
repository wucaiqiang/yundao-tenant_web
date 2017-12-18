
package com.yundao.tenant.web.service.login.impl;

import com.esotericsoftware.minlog.Log;
import com.yundao.core.code.Result;
import com.yundao.core.constant.HeaderConstant;
import com.yundao.core.enums.AppTypeEnum;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.UUIDUtils;
import com.yundao.tenant.web.constant.CodeConstant;
import com.yundao.tenant.web.constant.RequestHeaderConstant;
import com.yundao.tenant.web.constant.url.ScmUrl;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.keypair.KeyPairResDto;
import com.yundao.tenant.web.dto.login.RsaPublicResDto;
import com.yundao.tenant.web.dto.login.UserLoginResDto;
import com.yundao.tenant.web.dto.tenant.TenantDomainResDto;
import com.yundao.tenant.web.dto.tenant.TenantDto;
import com.yundao.tenant.web.dto.user.UserDetailResDto;
import com.yundao.tenant.web.dto.user.password.UserloginReqDto;
import com.yundao.tenant.web.enums.keypair.KeyPairAreaEnum;
import com.yundao.tenant.web.service.login.LoginService;
import com.yundao.tenant.web.util.HttpUtils;
import com.yundao.tenant.web.util.ObjectAndByteUtils;
import com.yundao.tenant.web.util.TenantUtils;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * Function: Reason: Date: 2017年7月27日 下午4:03:51
 *
 * @author wucq
 */
@Service
public class LoginServiceImpl extends AbstractService implements LoginService {

    @Override
    public Result<RsaPublicResDto> selectKeyPairPublic() throws Exception {

        Map<String, Object> methodParams = new HashMap<String, Object>();
        methodParams.put("tenantId", "-1");
        methodParams.put("area", KeyPairAreaEnum.TRAN.getValue());
        Result<KeyPairResDto> result = HttpUtils.get(ScmUrl.KEY_PAIR_GET_BY_TENANT_ID, methodParams,
                new BaseTypeReference<Result<KeyPairResDto>>() {
                });
        KeyPairResDto keyPairResDto = result.getResult();

        KeyPair keyPair = (KeyPair) ObjectAndByteUtils.toObject(keyPairResDto.getKeyPair());
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        String uuid = UUIDUtils.getUUID();
        RsaPublicResDto dto = new RsaPublicResDto();
        dto.setExponent(new String(Hex.encodeHex(publicKey.getPublicExponent().toByteArray())));
        dto.setModulus(new String(Hex.encodeHex(publicKey.getModulus().toByteArray())));
        dto.setRandom(uuid);

        return Result.newSuccessResult(dto);
    }

    @Override
    public Result<UserDetailResDto> login(UserloginReqDto loginReqDto, HttpServletRequest request) throws Exception {
        if (BooleanUtils.isNotBlank(loginReqDto.getUserName()))
            loginReqDto.setUserName(loginReqDto.getUserName().trim());
        // 检查帐号有效性
        Map<String, Object> checkParams = new HashMap<String, Object>();
        checkParams.put("userName", loginReqDto.getUserName());
        checkParams.put("tenantId", this.getHeaderTenantId());

        Result<Boolean> checkResult = HttpUtils.get(ScmUrl.USER_CHECK_ACCOUNT, checkParams,
                new BaseTypeReference<Result<Boolean>>() {
                });
        if (!checkResult.getSuccess()) {
            throw new BaseException(checkResult.getCode(), checkResult.getMessage());
        }
        // 调用公共库校验用户名和密码
        Map<String, Object> methodParams = new HashMap<String, Object>();
        methodParams.put("userName", loginReqDto.getUserName());
        methodParams.put("password", loginReqDto.getPassword());
        methodParams.put("tenantId", this.getHeaderTenantId());

        Map<String, Object> headerParams = new HashMap<>();
        headerParams.put(HeaderConstant.HEADER_APP_TYPE, AppTypeEnum.B_PC.getType());// pc端登录

        Result<UserLoginResDto> result = HttpUtils.post(ScmUrl.USER_LOGIN, headerParams, methodParams,
                new BaseTypeReference<Result<UserLoginResDto>>() {
                });
        Log.info("登录common返回结果" + result);
        if (result.getResult() == null || !result.getSuccess()) {
            throw new BaseException(result.getCode(), result.getMessage());
        }
        UserLoginResDto commonDto = result.getResult();

        // 获取用户详情
        TenantDomainResDto tenant = TenantUtils.getTenant(request.getServerName(),
                ((Integer) request.getServerPort()).toString());
        if (tenant == null) {
            throw new BaseException(CodeConstant.CODE_900005);
        }
        Map<String, Object> userHeaderParams = new HashMap<>();
        userHeaderParams.put(RequestHeaderConstant.HEADER_USER_ID, commonDto.getId());
        userHeaderParams.put(RequestHeaderConstant.HEADER_TENANT_ID, tenant.getId());
        Map<String, Object> userMethodParams = new HashMap<>();
        userMethodParams.put("id", String.valueOf(commonDto.getId()));
        Result<UserDetailResDto> userDetailResult = HttpUtils.get(TenantUrl.GET_USER_BY_ID, userHeaderParams,
                userMethodParams, new BaseTypeReference<Result<UserDetailResDto>>() {
                });

        if (userDetailResult == null || userDetailResult.getResult() == null) {
            throw new BaseException(CodeConstant.CODE_900004);
        }

        UserDetailResDto currentdto = userDetailResult.getResult();

        currentdto.setTicket(commonDto.getTicket());
        currentdto.setEmail(commonDto.getEmail());
        currentdto.setUsername(commonDto.getUsername());
        currentdto.setMobile(commonDto.getMobile());
        currentdto.setOnceEditPwd(commonDto.getOnceEditPwd());
        // 获取租户名称
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", currentdto.getTenantId());
        Result<TenantDto> resultTenant = HttpUtils.get(ScmUrl.GET_TENANT, map,
                new BaseTypeReference<Result<TenantDto>>() {
                });
        if (resultTenant != null && resultTenant.getResult() != null) {
            currentdto.setTenantName(resultTenant.getResult().getName());
        }

        return Result.newSuccessResult(currentdto);

    }

    @Override
    public Result<Boolean> validate(String ticket) throws Exception {

        Map<String, Object> methodParams = new HashMap<String, Object>();
        methodParams.put("ticket", ticket);
        Result<Boolean> result = HttpUtils.post(ScmUrl.TICKET_VALIDATE, methodParams,
                new BaseTypeReference<Result<Boolean>>() {
                });
        return result;

    }

    @Override
    public Result<Boolean> logout() throws Exception {
        // 调用公共库校验用户名和密码
        Result<Boolean> result = HttpUtils.post(ScmUrl.USER_LOGINOUT, null, new BaseTypeReference<Result<Boolean>>() {
        });
        return result;
    }

}
