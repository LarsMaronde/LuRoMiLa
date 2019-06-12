package com.onlineshop.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserverwaltungApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserverwaltungApplication.class, args);
    }

}
