package com.springmongo.app.repo;

import com.springmongo.app.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface UserRepository extends MongoRepository<Users, String> {
    List<Users> findByName(String name);
}
