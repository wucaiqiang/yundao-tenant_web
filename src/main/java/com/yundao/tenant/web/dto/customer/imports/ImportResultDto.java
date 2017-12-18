package com.yundao.tenant.web.dto.customer.imports;

/**
 * @author jan
 * @create 2017-08-31 PM5:07
 **/
public class ImportResultDto {

    /**
     * 上传总条数
     */
    private Integer total;

    /**
     * 成功条数
     */
    private Integer successCount;

    /**
     * 失败条数
     */
    private Integer failureCount;

    /**
     * 文件路径
     */
    private String filePath;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }

    public Integer getFailureCount() {
        return failureCount;
    }

    public void setFailureCount(Integer failureCount) {
        this.failureCount = failureCount;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
