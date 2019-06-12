package com.onlineshop.demo.remote;

import com.onlineshop.demo.jpa.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> findAll();

    User findOne(Long uid);

    void delete(User user);

    ResponseEntity<User> updateUser(User user);

    //Resource getBestand(Long artikelid);


}
