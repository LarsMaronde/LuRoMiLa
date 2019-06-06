package com.onlineshop.warenverwaltung.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages={"com.onlineshop.warenverwaltung.demo.Produkt.Repository"})
@EnableEurekaClient
public class WarenverwaltungApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarenverwaltungApplication.class, args);
    }

}
