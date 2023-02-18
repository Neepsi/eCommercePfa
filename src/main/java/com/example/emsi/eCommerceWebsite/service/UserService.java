package com.example.emsi.eCommerceWebsite.service;

import com.example.emsi.eCommerceWebsite.entity.User;
import com.example.emsi.eCommerceWebsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    public String deleteUser(int id) {
        repository.deleteById(id);
        return "User deleted" + id;
    }

    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);

        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setAddress(user.getAddress());

        return repository.save(existingUser);
    }
}
