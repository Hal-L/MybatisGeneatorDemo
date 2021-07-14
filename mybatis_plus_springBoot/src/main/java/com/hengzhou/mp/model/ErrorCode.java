package com.hengzhou.mp.model;

/**
 * Time:    2016-05-25 09:42
 * Author:  yuanqi@alibaba-inc.com
 */
public enum ErrorCode {

    /**
     * Common code
     */
    SUCCESS("000000", "success"),

    SUCCESS_200("200", "success"),
    FAILED("100000", "failed"),

    NONENTITY("000010", "nonentity"),
    //add by wubin 2019-05-16
    WARN("200000", "warning"),

    /**
     * resource
     */
    RESOURCE_NOT_FOUND("200001", "RESOURCE_NOT_FOUND"),
    RESOURCE_ALREADY_EXIST("200002", "RESOURCE_ALREADY_EXIST"),

    /**
     * session
     */
    SESSION_TIMEOUT_ERROR("001000", "SESSION TIMEOUT"),

    /**
     * server error
     */
    INTERNAL_SERVER_ERROR("400000", "INTERNAL_SERVER_ERROR"),
    PARAM_VALIDATE_ERROR("400001", "PARAM_VALIDATE_ERROR"),
    NOT_LOG_IN("400002", "NOT_LOG_IN"),
    REGION_NOT_SET("400003", "REGION_NOT_SET"),

    READ_DATA_ERROR("500001", "READ_DATA_ERROR"),
    READ_META_ERROR("600001", "READ_META_ERROR"),

    /**
     * authorize
     */
    NO_PERMISSION("700000", "Authorize Failed");

    private String errorCode;
    private String errorMsg;

    ErrorCode(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
