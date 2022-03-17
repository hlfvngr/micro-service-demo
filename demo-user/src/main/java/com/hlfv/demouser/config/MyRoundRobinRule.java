package com.hlfv.demouser.config;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyRoundRobinRule extends RoundRobinRule {

    public MyRoundRobinRule() {
    }

    public MyRoundRobinRule(ILoadBalancer lb) {
        super(lb);
    }

    @Override
    public Server choose(ILoadBalancer lb, Object key) {
        log.info("this is my self-define select rule");
        return super.choose(lb, key);
    }

}
