package com.leonsh.java.code.framework.springservicedemo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * BusinessException
 *
 * @author leonsh
 * @date 2022-05-24 17:44
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public BusinessException(BaseException baseException) {
        super(baseException.getResultCode());
        this.errorCode = baseException.getResultCode();
        this.errorMessage = baseException.getResultMsg();
    }
}
