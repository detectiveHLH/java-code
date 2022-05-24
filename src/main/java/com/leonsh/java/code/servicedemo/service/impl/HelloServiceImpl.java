package com.leonsh.java.code.servicedemo.service.impl;

import com.leonsh.java.code.servicedemo.dao.HelloMapper;
import com.leonsh.java.code.servicedemo.model.dto.UserDTO;
import com.leonsh.java.code.servicedemo.model.entity.User;
import com.leonsh.java.code.servicedemo.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * HelloServiceImpl
 *
 * @author leonsh
 * @date 2022-05-24 15:32
 **/
@Service
public class HelloServiceImpl implements HelloService {
    private final HelloMapper helloMapper;

    public HelloServiceImpl(HelloMapper helloMapper) {
        this.helloMapper = helloMapper;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = helloMapper.selectById(userId);
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .wechatOpenId(user.getWechatOpenId())
                .createTime(user.getCreateTime())
                .modifyTime(user.getModifyTime())
                .status(user.getStatus())
                .build();
        return userDTO;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = User.builder()
                .wechatOpenId(userDTO.getWechatOpenId())
                .createTime(System.currentTimeMillis())
                .build();
        helloMapper.insert(user);
        userDTO.setId(user.getId());
        userDTO.setCreateTime(user.getCreateTime());
        userDTO.setStatus(user.getStatus());
        return userDTO;
    }
}
