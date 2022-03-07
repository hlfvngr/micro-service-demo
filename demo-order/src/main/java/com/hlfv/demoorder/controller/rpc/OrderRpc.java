package com.hlfv.demoorder.controller.rpc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rpc/order")
public class OrderRpc {

    @RequestMapping("/getOrderByUserId")
    public String getOrderByUserId(Long userId) {
        return String.format("userId: %s orderId: 123", userId);
    }

}
