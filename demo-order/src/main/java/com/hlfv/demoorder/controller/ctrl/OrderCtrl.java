package com.hlfv.demoorder.controller.ctrl;

import com.hlfv.democommon.vo.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rpc/order")
public class OrderCtrl {

    @GetMapping("/getOrderByUserId")
    public CommonResult<String> getOrderByUserId(Long userId) {
        return CommonResult.success(String.format("userId: %s orderId: 123", userId));
    }

}
