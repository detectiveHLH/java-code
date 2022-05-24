package com.leonsh.java.code.servicedemo.controller;

import com.leonsh.java.code.servicedemo.model.dto.UserDTO;
import com.leonsh.java.code.servicedemo.service.HelloService;
import org.springframework.web.bind.annotation.*;

/**
 * HelloController
 *
 * @author leonsh
 * @date 2022-05-24 15:22
 **/
@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("users/{userId}")
    public UserDTO hello(@PathVariable("userId") Long userId) {
        return helloService.getUserById(userId);
    }

    @PostMapping("users")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return helloService.createUser(userDTO);
    }
}
