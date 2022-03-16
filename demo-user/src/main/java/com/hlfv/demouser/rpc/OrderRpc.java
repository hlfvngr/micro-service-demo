package com.hlfv.demouser.rpc;

import com.hlfv.democommon.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/rpc/order")
@FeignClient("demo-order")
public interface OrderRpc {

    @GetMapping("/getOrderByUserId")
    CommonResult<String> getOrderByUserId(@RequestParam("userId") Long userId);

}
