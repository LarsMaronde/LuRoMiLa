package com.onlineshop.userverwaltung.demo.account.repository;


import com.onlineshop.userverwaltung.demo.account.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
    User findById(int id);

}
