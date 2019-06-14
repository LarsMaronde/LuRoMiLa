package com.onlineshop.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableEurekaServer
@SpringBootApplication
public class ServiceDiscorveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDiscorveryApplication.class, args);
    }

}
