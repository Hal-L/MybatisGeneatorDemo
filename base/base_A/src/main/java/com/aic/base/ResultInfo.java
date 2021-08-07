package com.aic.base;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("resultInfo")
public class ResultInfo {
    private Integer code = 200;

    private String msg = "success";

    private Object result;

    public void setAll(Integer code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }
}
