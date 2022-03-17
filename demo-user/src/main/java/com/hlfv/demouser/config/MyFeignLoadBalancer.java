package com.hlfv.demouser.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import feign.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.ribbon.ServerIntrospector;
import org.springframework.cloud.openfeign.ribbon.FeignLoadBalancer;

import java.net.URI;
import java.util.Collection;
import java.util.Map;

@Slf4j
public class MyFeignLoadBalancer extends FeignLoadBalancer {

    public MyFeignLoadBalancer(ILoadBalancer lb, IClientConfig clientConfig, ServerIntrospector serverIntrospector) {
        super(lb, clientConfig, serverIntrospector);
    }

    @Override
    protected void customizeLoadBalancerCommandBuilder(RibbonRequest request, IClientConfig config,
                                                       LoadBalancerCommand.Builder<RibbonResponse> builder) {
        Request req = request.getRequest();
        Map<String, Collection<String>> headers = req.headers();
        log.info("{}", headers);
        if (request.getLoadBalancerKey() != null) {
            builder.withServerLocator(request.getLoadBalancerKey());
        }
    }

}
