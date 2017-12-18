package com.yundao.tenant.web.service.product;

import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.web.dto.common.PermissionResultDto;
import com.yundao.tenant.web.dto.product.ProductBaseUpdateReqDto;
import com.yundao.tenant.web.dto.product.ProductManagerListReqDto;
import com.yundao.tenant.web.dto.product.ProductManagerListResDto;
import com.yundao.tenant.web.dto.product.detail.ProductDataDetailDto;

/**
 * 产品服务接口
 *
 * @author jan
 * @create 2017-07-31 PM9:01
 **/
public interface ProductService {

	/**
	 * 产品管理查询
	 * getManagerList:
	 * @author: 欧阳利
	 * @param reqDto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	Result<PaginationSupport<ProductManagerListResDto>> getManagerList(ProductManagerListReqDto reqDto) throws BaseException;
	
	
    /**
     * 删除产品
     */
    Result<PermissionResultDto> delete(String ids) throws BaseException;

    /**
     * 修改产品
     */
    Result<Integer> update(ProductBaseUpdateReqDto dto, Map<String, Object> paramMap) throws BaseException;

    /**
     * 获取产品
     *
     * @param id 产品id
     */
    Result<ProductDataDetailDto> getProductDetailDto(Long id) throws BaseException;
    
    /**
     * 获取产品的创建用户id
     * @param id
     * @return
     * @throws BaseException
     */
    Long getProductCreateUserId(Long id) throws BaseException;
    
    /**
     * 检查修改权限
     * @param id
     * @return
     * @throws BaseException
     */
    public Boolean updatePermission(Long id ,String dataObjectCode)throws BaseException;
    
}
