package com.onlineshop.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
@EnableEurekaClient
public class BewertungenApplication {

    public static void main(String[] args) {
        SpringApplication.run(BewertungenApplication.class, args);
    }

}
