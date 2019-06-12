package com.onlineshop.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WarenverwaltungApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarenverwaltungApplication.class, args);
    }

}
