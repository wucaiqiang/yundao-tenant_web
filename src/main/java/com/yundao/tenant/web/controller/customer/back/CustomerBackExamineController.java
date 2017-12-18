package com.yundao.tenant.web.controller.customer.back;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.constant.url.TenantUrl;
import com.yundao.tenant.web.dto.customer.back.CustomerBackApplyReqDto;
import com.yundao.tenant.web.dto.customer.back.CustomerBackExamineListReqDto;
import com.yundao.tenant.web.dto.customer.back.CustomerBackExamineListResDto;
import com.yundao.tenant.web.dto.customer.back.CustomerBackExamineReqDto;
import com.yundao.tenant.web.service.customer.CustomerBackExamineService;
import com.yundao.tenant.web.util.ArgsUtils;
import com.yundao.tenant.web.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 客户回退
 *
 * @author jan
 * @create 2017-08-10 PM3:35
 **/
@Controller
@RequestMapping("/customer/back")
@ResponseBody
@Api("客户回退")
public class CustomerBackExamineController {

	@Autowired
	CustomerBackExamineService customerBackExamineService;
	
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    @ApiOperation(value = "申请回退")
    public Result<Boolean> apply(@ModelAttribute CustomerBackApplyReqDto dto) throws BaseException {
        return HttpUtils.post(TenantUrl.BACK_CUSTOMER_APPLY, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Boolean>>
                () {
        });
    }
    

    /**
	 * 分页查询回退客户审核列表
	 * @param reqDto
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value = "/gets", method = RequestMethod.GET)
	@ApiOperation(value = "客户回退审核列表")
	public Result<PaginationSupport<CustomerBackExamineListResDto>> gets(@ModelAttribute CustomerBackExamineListReqDto reqDto)throws BaseException{
		return customerBackExamineService.gets(reqDto);
	}

	
	/**
	 * 回退客户审核
	 * @param id
	 * @param isPass
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value = "/audit", method = RequestMethod.POST)
    @ApiOperation(value = "回退客户审核")
    public Result<Integer> audit(@ModelAttribute  CustomerBackExamineReqDto dto) throws BaseException {
		 if(dto == null || dto.getId() == null){
			 return Result.newFailureResult(1200000,"id不能为空",null);
		 }
		 if(dto.getIsPass() == null){
			 return Result.newFailureResult(1200000,"isPass不能为空",null);
		 }
		 if(dto.getIsPass()){
			 return HttpUtils.post(TenantUrl.BACK_CUSTOMER_PASS, ArgsUtils.toIdMap(dto.getId()), new BaseTypeReference<Result<Integer>>() {});
		 }else{
			 return HttpUtils.post(TenantUrl.BACK_CUSTOMER_REJECT, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Integer>>() {});
		 }
    }

//	@RequestMapping(value = "/pass", method = RequestMethod.POST)
//    @ApiOperation(value = "客户回退通过")
//    public Result<Integer> pass(@RequestParam Long id) throws BaseException {
//    	 return HttpUtils.post(TenantUrl.BACK_CUSTOMER_PASS, ArgsUtils.toIdMap(id), new BaseTypeReference<Result<Integer>>() {});
//    }
//    
//    
//    @RequestMapping(value = "/reject", method = RequestMethod.POST)
//    @ApiOperation(value = "客户回退驳回")
//    public Result<Integer> reject(@ModelAttribute CustomerBackExamineReqDto dto) throws BaseException {
//    	 return HttpUtils.post(TenantUrl.BACK_CUSTOMER_REJECT, ArgsUtils.toMap(dto), new BaseTypeReference<Result<Integer>>() {});
//    }
}
