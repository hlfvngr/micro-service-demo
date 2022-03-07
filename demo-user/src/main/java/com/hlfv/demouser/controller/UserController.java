package com.hlfv.demouser.controller;

import com.hlfv.demouser.properties.DemoProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private DemoProperties demoProperties;

    @RequestMapping("/getOrderByUserId")
    public String getOrderByUserId(Long userId) {
        return String.format("userId: %s orderId: 123", userId);
    }

    @RequestMapping("/getById")
    public String getById(Long userId) {
        return String.format("userId: %s name: %s", userId, demoProperties.getName());
    }
}
