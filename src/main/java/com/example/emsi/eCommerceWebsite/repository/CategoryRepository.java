package com.example.emsi.eCommerceWebsite.repository;

import com.example.emsi.eCommerceWebsite.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
