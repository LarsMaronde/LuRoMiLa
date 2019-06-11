package com.onlineshop.demo.rest;

import com.onlineshop.demo.jpa.entity.User;
import com.onlineshop.demo.remote.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @PostMapping("user")
    public User createUser(@RequestBody User user){
        return this.registrationService.createUser(user);
    }


    @GetMapping("users")
    public List<User> getAllUsers(){
        return registrationService.findAll();
    }


    //delete an user
    @DeleteMapping("users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long userid){

        User user = registrationService.findOne(userid);

        if(user == null){
            return ResponseEntity.notFound().build();
        }

        registrationService.delete(user);
        return  ResponseEntity.ok().build();
    }


    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userid){
        User user = registrationService.findOne(userid);

        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }


    @PutMapping("users")
    public User updateUser(@RequestBody User user){
        return registrationService.updateUser(user);
    }

    @PutMapping("users/{name}")
    public User getUserByName(@PathVariable String name){
        return registrationService.findUserByUsername(name);
    }

}
