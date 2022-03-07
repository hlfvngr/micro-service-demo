package com.hlfv.demoorder.controller;

import com.hlfv.demoorder.properties.DemoProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

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
