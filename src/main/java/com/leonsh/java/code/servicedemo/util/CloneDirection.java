package com.leonsh.java.code.servicedemo.util;

/**
 * 克隆方向
 *
 * @author leonsh
 * @date 2020-12-31 09:49
 **/
public interface CloneDirection {
    /**
     * 正向克隆 VO -> DTO DTO -> DO
     */
    Integer FORWARD = 1;
    /**
     * 反向克隆 DO -> DTO DTO -> VO
     */
    Integer OPPOSITE = 2;
}
