package com.leonsh.java.code.framework.springservicedemo.util;

/**
 * BaseException
 *
 * @author leonsh
 * @date 2022-05-24 17:59
 **/
public interface BaseException {
    /**
     * 错误码
     */
    String getResultCode();

    /**
     * 错误描述
     */
    String getResultMsg();
}
