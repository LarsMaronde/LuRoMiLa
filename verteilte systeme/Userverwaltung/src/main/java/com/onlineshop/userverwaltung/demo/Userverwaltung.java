package com.onlineshop.userverwaltung.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Userverwaltung {

    public static void main(String[] args) {
        SpringApplication.run(Userverwaltung.class, args);
    }

}
