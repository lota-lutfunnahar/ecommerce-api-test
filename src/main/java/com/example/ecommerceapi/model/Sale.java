package com.example.ecommerceapi.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long itemId;
    private Integer quantity;
    private LocalDate saleDate;

    // Getters and Setters
}