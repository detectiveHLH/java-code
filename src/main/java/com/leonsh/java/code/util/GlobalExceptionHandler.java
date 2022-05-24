package com.leonsh.java.code.util;

import com.leonsh.java.code.servicedemo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * GlobalExceptionHandler
 *
 * @author leonsh
 * @date 2022-05-24 17:50
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = BusinessException.class)
    public Result bizExceptionHandler(HttpServletRequest req, BusinessException e) {
        return Result.error(Integer.valueOf(e.getErrorCode()), e.getErrorMessage());
    }
}
