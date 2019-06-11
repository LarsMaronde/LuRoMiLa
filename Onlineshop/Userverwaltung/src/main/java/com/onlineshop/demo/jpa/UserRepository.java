package com.onlineshop.demo.jpa;

import com.onlineshop.demo.jpa.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long>{

    User findUserByUsername(@Param("username") String username);

}
