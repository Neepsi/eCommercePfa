package com.example.emsi.eCommerceWebsite.repository;

import com.example.emsi.eCommerceWebsite.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
