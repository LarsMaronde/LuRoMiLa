package com.onlineshop.demo.remote;

import com.onlineshop.demo.jpa.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public interface RegistrationService {

    //save user
    public User createUser(User user);

    //search all users
    public List<User> findAll();

    //get one
    public User findOne(Long uid);

    //delete an user
    public void delete(User user);

}
