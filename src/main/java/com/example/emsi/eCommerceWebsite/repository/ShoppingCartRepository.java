package com.example.emsi.eCommerceWebsite.repository;

import com.example.emsi.eCommerceWebsite.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    List<ShoppingCart> findByUserId(Long userId);
}
