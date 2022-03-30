package com.hlfv.demouser.controller;

import com.hlfv.democommon.exception.DemoException;
import com.hlfv.democommon.vo.CommonResult;
import com.hlfv.demouser.properties.DemoProperties;
import com.hlfv.demouser.rpc.OrderRpc;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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

    @RequestMapping("/getOrderByUserIds")
    public CommonResult<String> getOrderByUserIds(@RequestBody List<Long> userIds) {
        List<String> collect = userIds.stream().map(String::valueOf).collect(Collectors.toList());
        // CommonResult<String> commonResult = orderRpc.getOrderByUserIds(collect, "lzr");
        CommonResult<String> commonResult = orderRpc.getOrderByUserIds("lzr", collect);
        if (!commonResult.getSuccess()) {
            throw new DemoException("系统内部异常！");
        }
        return CommonResult.success(commonResult.getData());
    }

    @RequestMapping("/getById")
    public String getById(Long userId) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext();
        return String.format("userId: %s name: %s", userId, demoProperties.getName());
    }
}
