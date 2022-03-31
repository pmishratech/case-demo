package com.cisco.code.demo.repository;

import com.cisco.code.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserId(Integer userId);
}
