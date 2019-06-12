package com.onlineshop.demo.rest;

import com.onlineshop.demo.jpa.entity.User;
import com.onlineshop.demo.remote.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("users")
    public User createUser(@RequestBody User user){
        return this.userService.createUser(user);
    }

    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long userid){

        User user = userService.findOne(userid);

        if(user == null){
            return ResponseEntity.notFound().build();
        }

        userService.delete(user);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userid){
        User user = userService.findOne(userid);

        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }


    @PutMapping("users")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @GetMapping("users/{name}")
    public User getUserByName(@PathVariable String name){
        return userService.findUserByUsername(name);
    }

}
