package com.leonsh.java.code.basic.exception;

/**
 * OSExecutorException
 *
 * @author leonsh
 * @date 2022-07-07 20:41
 **/
public class OSExecutorException extends RuntimeException {
    public OSExecutorException(String why) {
        super(why);
    }
}
