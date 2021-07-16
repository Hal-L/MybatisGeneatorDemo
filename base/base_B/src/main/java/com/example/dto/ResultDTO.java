package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultDTO {

    private Boolean success;
    private Integer code;
    private String msg;
    private Object data;

    public static ResultDTO OK() {
        return ResultDTO.builder()
                .code(ResultCode.SUCCESS)
                .success(true)
                .msg("success")
                .data(null)
                .build();
    }

    public static ResultDTO OK(Object obj) {
        return ResultDTO.builder()
                .code(ResultCode.SUCCESS)
                .success(true)
                .msg("success")
                .data(obj)
                .build();
    }

    public static ResultDTO ERROR() {
        return ResultDTO.builder()
                .code(ResultCode.ERROR)
                .success(false)
                .msg("failed")
                .data(null)
                .build();
    }

    public static ResultDTO ERROR(String msg) {
        return ResultDTO.builder()
                .code(ResultCode.ERROR)
                .success(false)
                .msg(msg)
                .data(null)
                .build();
    }


}
