package com.hlfv.demouser.config;

import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.netflix.ribbon.ZonePreferenceServerListFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration.*;

@Configuration
public class MyRibbonConfig {

    @Bean
    public MyCachingSpringLoadBalancerFactory myCachingSpringLoadBalancerFactory(SpringClientFactory springClientFactory) {
        return new MyCachingSpringLoadBalancerFactory(springClientFactory);
    }

    @Bean
    public IRule ribbonRule() {
        MyRoundRobinRule rule = new MyRoundRobinRule();
        return rule;
    }

}
