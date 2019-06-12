package com.onlineshop.demo.jpa;

import com.onlineshop.demo.jpa.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
