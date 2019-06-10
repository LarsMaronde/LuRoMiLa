package com.onlineshop.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.onlineshop.demo.account.dao.UserDAO;
import com.onlineshop.demo.account.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/userverwaltung")
public class UserverwaltungController {

    @Autowired
    UserDAO userDAO;

    // save user into database
    @HystrixCommand(fallbackMethod = "reliable")
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user){
        return userDAO.save(user);
    }

    //get all users
    @HystrixCommand(fallbackMethod = "reliable2")
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userDAO.findAll();
    }

    //get user by id
    @HystrixCommand(fallbackMethod = "reliable3")
    @GetMapping("/users/{id]")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userid){
        User user = userDAO.findOne(userid);

        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    //update an user
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userid,
                                           @Valid @RequestBody User userDetails){
        User user = userDAO.findOne(userid);

        if(user == null){
            return ResponseEntity.notFound().build();
        }
        user.setUsername(userDetails.getUsername());
        user.setAdresse(userDetails.getAdresse());
        user.setVorname(userDetails.getVorname());
        user.setNachname(userDetails.getNachname());
        user.setEmail(userDetails.getEmail());
        user.setDateOfBirth(userDetails.getDateOfBirth());
        user.setPassword(userDetails.getPassword());

        User updateUser = userDAO.save(user);
        return ResponseEntity.ok().body(updateUser);
    }

    //delete an user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long userid){

        User user = userDAO.findOne(userid);

        if(user == null){
            return ResponseEntity.notFound().build();
        }

        userDAO.delete(user);
        return  ResponseEntity.ok().build();
    }

}
