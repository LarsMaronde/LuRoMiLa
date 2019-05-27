package com.onlineshop.bewertung.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BewertungApplication {

    public static void main(String[] args) {
        SpringApplication.run(BewertungApplication.class, args);
    }

}
