package com.demo.aic.handler;

import com.demo.aic.pojo.dto.ResultDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultDTO exceptionHandler(Exception e) {
        return ResultDTO.ERROR(e.getMessage());
    }
}
