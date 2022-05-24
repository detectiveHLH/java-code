package com.leonsh.java.code.servicedemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Result
 *
 * @author leonsh
 * @date 2022-05-24 17:22
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Boolean success;

    private Integer code;

    private String message;

    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setSuccess(Boolean.TRUE);
        result.setCode(0);
        result.setMessage(null);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(Integer errorCode, String errorMessage) {
        Result<T> result = new Result<>();
        result.setSuccess(Boolean.FALSE);
        result.setCode(errorCode);
        result.setMessage(errorMessage);
        return result;
    }
}
