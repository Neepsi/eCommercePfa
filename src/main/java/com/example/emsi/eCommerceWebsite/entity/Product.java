package com.example.emsi.eCommerceWebsite.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private Integer quantity;
    private String brand;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
