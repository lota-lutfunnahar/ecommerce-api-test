package com.example.ecommerceapi.controller;

@test
public class testGetWishlist {
    lic void testGetWishlist() throws Exception {
        mockMvc.perform(get("/api/wishlist/{customerId}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(3)); // assuming customer has 3 items in wishlist

    }
