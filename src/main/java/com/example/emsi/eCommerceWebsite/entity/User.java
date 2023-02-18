package com.example.emsi.eCommerceWebsite.entity;

import com.example.emsi.eCommerceWebsite.enums.UserRoles;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private UserRoles role;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    private String address;
}
