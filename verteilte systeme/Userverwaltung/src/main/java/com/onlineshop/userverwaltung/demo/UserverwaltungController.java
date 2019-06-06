package com.onlineshop.userverwaltung.demo;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.onlineshop.userverwaltung.demo.account.model.User;
import com.onlineshop.userverwaltung.demo.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserverwaltungController {

    @Autowired
    protected RestTemplate restTemplate;
    private String serviceUrl = "http://DEMOB";

    @Autowired
    private UserRepository userRepos;


    @RequestMapping("/user")
    public String hello() {
        return "Hello user";
    }


    @ResponseBody
    @RequestMapping("/")
    public String index() {
        Iterable<User> all = userRepos.findAll();
        StringBuilder sb = new StringBuilder();
        all.forEach(p -> sb.append(p.getVorname() + "<br>"));
        return sb.toString();
    }



    //CALLING ANOTHER SERVICE

    @HystrixCommand(fallbackMethod = "callGetServiceFallBack")
    public String callGetService(int id) {
        String response = restTemplate.exchange(serviceUrl+"/{id}"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<String>() {}
                , id).getBody();
        return response;
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    public String callGetServiceFallBack(int id) {
        String response = "Fall back response get : " + id;
        return response;
    }

}
