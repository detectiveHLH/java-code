package com.leonsh.java.code.framework.springservicedemo.service;

import com.leonsh.java.code.framework.springservicedemo.model.dto.UserDTO;

/**
 * HelloService
 *
 * @author leonsh
 * @date 2022-05-24 15:31
 **/
public interface HelloService {
    /**
     * 根据用户 ID 获取用户数据
     *
     * @param userId 用户 ID
     * @return 用户数据
     */
    UserDTO getUserById(Long userId) throws Exception;

    UserDTO createUser(UserDTO userDTO);
}
