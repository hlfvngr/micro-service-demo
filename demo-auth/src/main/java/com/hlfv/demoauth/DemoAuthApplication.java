package com.hlfv.demoauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.hlfv"})
public class DemoAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAuthApplication.class, args);
    }

}
