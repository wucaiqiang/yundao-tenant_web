package com.yundao.tenant.web.controller.customer.imports;

import com.yundao.core.code.Result;
import com.yundao.tenant.web.service.customer.imports.CustomerImportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 客户导入
 *
 * @author jan
 * @create 2017-08-31 PM5:02
 **/
@Controller
@RequestMapping("/customer/import")
@Api("客户导入")
@ResponseBody
public class CustomerImportController {

    @Autowired
    private CustomerImportService customerImportService;
    
    /**
     * 批量导入客户
     */
    @RequestMapping(value = "/multi_from_opensea", method = RequestMethod.POST)
    @ApiOperation("从公海批量导入客户")
    public Result<Object> importCustomerFromOpensea(@RequestParam(value = "file") MultipartFile file, HttpServletResponse response) throws Exception {
        return customerImportService.importFromOpensea(response, file);
    }

}
