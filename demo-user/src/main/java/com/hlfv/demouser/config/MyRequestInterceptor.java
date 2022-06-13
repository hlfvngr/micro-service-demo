package com.hlfv.demouser.config;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MyRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", "Bear qwer123456")
                .header("Mxc", "mac");
        SecurityContextHolder.getContext().getAuthentication();

        Request request = template.request();

        System.out.println(request);
    }
}
