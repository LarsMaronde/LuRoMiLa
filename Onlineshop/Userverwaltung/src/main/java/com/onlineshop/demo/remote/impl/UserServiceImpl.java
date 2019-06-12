package com.onlineshop.demo.remote.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.onlineshop.demo.jpa.UserRepository;
import com.onlineshop.demo.jpa.entity.User;
import com.onlineshop.demo.remote.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;


    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }


    @HystrixCommand(fallbackMethod = "reliable")
    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @HystrixCommand(fallbackMethod = "reliable2")
    @Override
    public List<User> findAll() {
        Iterable<User> entities = repository.findAll();
        ArrayList<User> userList = new ArrayList<User>();
        entities.forEach(user -> userList.add(user));
        return userList;
    }

    @HystrixCommand(fallbackMethod = "reliable3")
    @Override
    public User findOne(Long uid) {
        return repository.findById(uid).get();
    }

    @HystrixCommand(fallbackMethod = "reliable3")
    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @HystrixCommand(fallbackMethod = "reliable3")
    @Override
    public ResponseEntity<User> updateUser(User userDetails) {

        User user = repository.findById(userDetails.getId()).get();

        if(user == null){
            return ResponseEntity.notFound().build();
        }
        user.setUsername(userDetails.getUsername());
        user.setVorname(userDetails.getVorname());
        user.setNachname(userDetails.getNachname());
        user.setAdresse(userDetails.getAdresse());
        user.setDateOfBirth(userDetails.getDateOfBirth());
        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());

        repository.deleteById(user.getId());
        repository.save(user);

        return ResponseEntity.ok(user);
    }

    public User reliable(){
        User user = new User();
        user.setUsername("fallback");
        return user;
    }

    public ArrayList<User> reliable2(){
        return new ArrayList<User>();
    }

    public ResponseEntity<User> reliable3(){
        return ResponseEntity.notFound().build();
    }


}
