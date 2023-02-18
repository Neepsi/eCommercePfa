package com.example.emsi.eCommerceWebsite.repository;

import com.example.emsi.eCommerceWebsite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
