package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.User;

import jakarta.transaction.Transactional;

@RestController
public class UserController{
    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/all")
    public Iterable<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/users/{name}")
    public User findByName(@PathVariable String name) {
        System.out.println("SEARCHING");
        return this.userRepository.findByName(name);
    }

    @GetMapping("/users/{name}/{password}")
    public User findByNameAndPassword(@PathVariable String name, @PathVariable String password) {
        return this.userRepository.findByNameAndPassword(name, password);
    }

    @GetMapping("/users/check/{name}/{password}")
    public boolean existsByNameAndPassword(@PathVariable String name, @PathVariable String password) {
        if(this.userRepository.existsByNameAndPassword(name, password)) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/users/add")
    public User addUser(@RequestBody User newUser) {
        String name = newUser.getName();
        String password = newUser.getPassword();
        User user = new User(name, password);
        return this.userRepository.save(user);
    }

    @Transactional
    @RequestMapping(value="/users/delete/{name}/{password}", method={RequestMethod.DELETE, RequestMethod.GET})
    public void deleteUser(@PathVariable String name, @PathVariable String password) {
        if(this.userRepository.existsByNameAndPassword(name, password)) {
            this.userRepository.deleteByNameAndPassword(name, password);
        }
    }
}
