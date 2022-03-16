package com.hlfv.demouser.controller;

import com.hlfv.democommon.exception.DemoException;
import com.hlfv.democommon.vo.CommonResult;
import com.hlfv.demouser.properties.DemoProperties;
import com.hlfv.demouser.rpc.OrderRpc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private DemoProperties demoProperties;
    @Resource
    private OrderRpc orderRpc;

    @RequestMapping("/getOrderByUserId")
    public CommonResult<String> getOrderByUserId(Long userId) {
        CommonResult<String> commonResult = orderRpc.getOrderByUserId(userId);
        if (!commonResult.getSuccess()) {
            throw new DemoException("系统内部异常！");
        }
        return CommonResult.success(commonResult.getData());
    }

    @RequestMapping("/getById")
    public String getById(Long userId) {
        return String.format("userId: %s name: %s", userId, demoProperties.getName());
    }
}
