package com.example.emsi.eCommerceWebsite.controller;

import com.example.emsi.eCommerceWebsite.entity.ShoppingCart;
import com.example.emsi.eCommerceWebsite.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartRepository cartItemRepository;

    @PostMapping
    public ShoppingCart addToCart(@RequestBody ShoppingCart cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getCartItemById(@PathVariable Integer id) {
        Optional<ShoppingCart> cartItem = cartItemRepository.findById(id);
        if (cartItem.isPresent()) {
            return ResponseEntity.ok(cartItem.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShoppingCart> updateCartItem(@PathVariable Integer id, @RequestBody ShoppingCart updatedCartItem) {
        Optional<ShoppingCart> existingCartItem = cartItemRepository.findById(id);
        if (existingCartItem.isPresent()) {
            ShoppingCart cartItem = existingCartItem.get();
            cartItem.setQuantity(updatedCartItem.getQuantity());
            cartItemRepository.save(cartItem);
            return ResponseEntity.ok(cartItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Integer id) {
        Optional<ShoppingCart> cartItemOptional = cartItemRepository.findById(id);
        if (cartItemOptional.isPresent()) {
            ShoppingCart cartItem = cartItemOptional.get();
            cartItemRepository.delete(cartItem);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userId}")
    public List<ShoppingCart> getCartItemsByUserId(@PathVariable Long userId) {
        return cartItemRepository.findByUserId(userId);
    }
}
