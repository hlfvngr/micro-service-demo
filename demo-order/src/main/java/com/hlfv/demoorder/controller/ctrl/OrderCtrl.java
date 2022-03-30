package com.hlfv.demoorder.controller.ctrl;

import com.hlfv.democommon.vo.CommonResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rpc/order")
public class OrderCtrl {

    @GetMapping("/getOrderByUserId")
    public CommonResult<String> getOrderByUserId(Long userId) {
        return CommonResult.success(String.format("userId: %s orderId: 123", userId));
    }


    @PostMapping("/getOrderByUserIds")
    CommonResult<String> getOrderByUserIds(@RequestParam("username") String username, @RequestParam("userIds") List<String> userIds) {
        String userIdsStr = userIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        return CommonResult.success(String.format("userId: %s orderId: 123 username: %s", userIdsStr, username));
    }

}
