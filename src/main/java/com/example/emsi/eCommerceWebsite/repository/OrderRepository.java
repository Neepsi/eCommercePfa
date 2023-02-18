package com.example.emsi.eCommerceWebsite.repository;

import com.example.emsi.eCommerceWebsite.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
