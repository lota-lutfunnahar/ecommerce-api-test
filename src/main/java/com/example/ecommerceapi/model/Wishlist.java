package com.example.ecommerceapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "wishlist")
@IdClass(WishlistId.class)
public class Wishlist {

    @Id()
    private Long customerId;

    @Id
    private Long itemId;

    // Getters and Setters
}
