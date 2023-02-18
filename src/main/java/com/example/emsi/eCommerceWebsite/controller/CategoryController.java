package com.example.emsi.eCommerceWebsite.controller;

import com.example.emsi.eCommerceWebsite.entity.Category;
import com.example.emsi.eCommerceWebsite.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return ResponseEntity.ok(category.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer id, @RequestBody Category updatedCategory) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            Category category = existingCategory.get();
            category.setName(updatedCategory.getName());
            category.setProducts(updatedCategory.getProducts());
            categoryRepository.save(category);
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
