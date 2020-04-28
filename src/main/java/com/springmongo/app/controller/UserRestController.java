package com.springmongo.app.controller;

import com.springmongo.app.model.Users;
import com.springmongo.app.repo.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    final UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping
    public List<Users> getAllUsers() {
//        get all users list
        return userRepository.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Users saveUser(@RequestBody Users users) {
//        save users
        return userRepository.save(users);
    }

    @DeleteMapping(value = "{name}")
    public void deleteUserByName(@PathVariable("name") String name) {
//        delete user by name
        userRepository.deleteAll(userRepository.findByName(name));
    }

    @DeleteMapping(value = "{id}")
    public void deleteUserById(@PathVariable("id") String id) {
//        delete user by id
        userRepository.delete(userRepository.findById(id).get());
    }

    @GetMapping(value = "{id}")
    public Users getOneUser(@PathVariable("id") String id) {
//        get one user by Id
        return userRepository.findById(id).get();
    }

    @PutMapping
    public Users updateUser(@RequestBody Users user) {
//        update user
        return userRepository.save(user);
    }


}
