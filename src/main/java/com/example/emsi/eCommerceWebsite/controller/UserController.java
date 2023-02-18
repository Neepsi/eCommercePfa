package com.example.emsi.eCommerceWebsite.controller;

import com.example.emsi.eCommerceWebsite.entity.User;
import com.example.emsi.eCommerceWebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @GetMapping("users")
    public List<User> findAllUsers() {
        return service.getUsers();
    }

    @GetMapping("users/{username}")
    public User findUserByUsername(@PathVariable String username) {
        return service.getUserByUsername(username);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }
}
