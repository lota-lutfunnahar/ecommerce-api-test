package com.example.ecommerceapi.model;

import jakarta.persistence.*;

@Entity
@IdClass(WishlistId.class)
public class Wishlist {

    @Id()
    private Long customerId;

    @Id
    private Long itemId;

    // Getters and Setters
}
