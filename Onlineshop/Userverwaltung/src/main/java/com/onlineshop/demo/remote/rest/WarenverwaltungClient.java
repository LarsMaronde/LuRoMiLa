package com.onlineshop.demo.remote.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.core.io.Resource;

@FeignClient("Warenverwaltung-service")
public interface WarenverwaltungClient {


    @GetMapping("users")
    Resource getBestand();

}
