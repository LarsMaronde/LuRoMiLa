package com.onlineshop.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaAuditing
public class UserverwaltungApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserverwaltungApplication.class, args);
    }

}
