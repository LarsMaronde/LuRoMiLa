package com.onlineshop.demo.remote.impl;

import com.onlineshop.demo.jpa.UserRepository;
import com.onlineshop.demo.jpa.entity.User;
import com.onlineshop.demo.remote.RegistrationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository repository;

    public RegistrationServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> findAll() {
        Iterable<User> entities = repository.findAll();
        ArrayList<User> userList = new ArrayList<User>();
        entities.forEach(user -> userList.add(user));
        return userList;
    }

    @Override
    public User findOne(Long uid) {
        return repository.findById(uid).get();
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }
}
