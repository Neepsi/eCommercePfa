package com.example.emsi.eCommerceWebsite.controller;

import com.example.emsi.eCommerceWebsite.entity.Product;
import com.example.emsi.eCommerceWebsite.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id)
    {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent())
        {
            return ResponseEntity.ok(product.get());
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            productRepository.save(product);
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
