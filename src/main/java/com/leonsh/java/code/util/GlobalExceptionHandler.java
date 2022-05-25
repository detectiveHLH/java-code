package com.leonsh.java.code.util;

import com.leonsh.java.code.servicedemo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * GlobalExceptionHandler
 *
 * @author leonsh
 * @date 2022-05-24 17:50
 **/
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = BusinessException.class)
    public <T> Result<T> bizExceptionHandler(HttpServletRequest req, BusinessException e) {
        return Result.error(Integer.valueOf(e.getErrorCode()), e.getErrorMessage());
    }
}
