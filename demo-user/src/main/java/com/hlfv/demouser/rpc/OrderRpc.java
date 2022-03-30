package com.hlfv.demouser.rpc;

import com.hlfv.democommon.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@RequestMapping("/rpc/order")
@FeignClient("demo-order")
public interface OrderRpc {

    @GetMapping("/getOrderByUserId")
    CommonResult<String> getOrderByUserId(@RequestParam("userId") Long userId);

    @PostMapping("/getOrderByUserIds")
    CommonResult<String> getOrderByUserIds(@RequestParam("username") String username, @RequestParam("userIds") List<String> userIds);

    //@GetMapping("/getOrderByUserIds")
    //CommonResult<String> getOrderByUserIds(@RequestParam("userIds") List<String> userIds, @RequestParam("username") String username);
}
