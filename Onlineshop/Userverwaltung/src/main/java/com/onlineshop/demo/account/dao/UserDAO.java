package com.onlineshop.demo.account.dao;

import com.onlineshop.demo.account.model.User;
import com.onlineshop.demo.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// user data access object
@Service
public class UserDAO {

    @Autowired
    private UserRepository repository;


    //save user
    public User save(User user){
        return repository.save(user);
    }

    //search all users
    public List<User> findAll(){
        return repository.findAll();
    }

    //get one
    public User findOne(Long uid){
        return repository.getOne(uid);
    }

    //delete an user
    public void delete(User user){
        repository.delete(user);
    }


}
