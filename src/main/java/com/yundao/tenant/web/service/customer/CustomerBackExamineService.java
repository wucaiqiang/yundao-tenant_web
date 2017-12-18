package com.yundao.tenant.web.service.customer;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.customer.back.CustomerBackExamineListReqDto;
import com.yundao.tenant.web.dto.customer.back.CustomerBackExamineListResDto;

public interface CustomerBackExamineService {

	 /**
	  * 分页查询客户回退审核列表
	  * @param reqDto
	  * @return
	  * @throws BaseException
	  */
	 public Result<PaginationSupport<CustomerBackExamineListResDto>> gets(CustomerBackExamineListReqDto reqDto)throws BaseException;
}
