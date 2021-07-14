package com.hengzhou.mp.model;

/**
 * @author wb-tt703486
 * @date 2020/3/17 16:57
 */
public enum Code {
    /**
     * 请求成功接受并被处理
     */
    OK("200","ok"),

    /**
     * 请求已完成，并导致了一个或多个资源被创建
     */
    CREATED("201","Created"),

    /**
     * 请求已经接收并开始处理，但是处理还没有完成。一般用在异步处理情况下
     */
    ACCEPTED("202","Accepted"),

    /**
     * 客户端发送的请求错误
     */
    REQ_ERROR("400","Bad Request"),

    /**
     * 请求的资源需要认证
     */
    NEED_AUTHENTICATION("401","Unauthoried"),

    /**
     * 用户权限不足
     */
    USER_PERMISSION_DENIED("403","Forbidden"),

    /**
     * 客户端访问的资源不存在
     */
    NOT_FOUND("404", "Not Found"),

    /**
     * 服务器内部错误，导致无法完成请求的内容
     */
    SERVER_ERROR("500","Internal Server Error"),

    /**
     * 服务器未实现
     */
    SERVER_NOT_IMPLEMEMNT("501","Not Implemented"),

    /**
     * 服务器负载过高或维护，暂时无法提供服务
     */
    SERVER_UNAVAILABLE("503","Service Unavailable");

    private String code;
    private String message;

    Code(String code, String message){
        this.code=code;
        this.message=message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
