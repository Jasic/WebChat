package com.lemontree.daemon.domm.reslt;

/**
 * Author Jasic
 * Date 13-12-17.
 * <p/>
 * 处理后端交互接口的状态
 */
public interface Status {

    // 执行命令成功响应代码
    public static final int EXECUTE_CMD_SUCCESS_CODE = 0x00;
    // 执行命令失败响应代码
    public static final int EXECUTE_CMD_FAIL_CODE = 0x01;


    /**
     * 处理过程的状态
     */
    public static class ProcessStatus {

        /**
         * 处理结果
         */
        private Integer status;

        /**
         * 失败原因（如果成功，则为""）
         */
        private String reason;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }
}


