package com.onlineshop.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class OnlineshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineshopApplication.class, args);
    }

}
