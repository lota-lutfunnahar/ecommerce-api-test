package com.example.ecommerceapi.controller;

import com.example.ecommerceapi.model.Item;
import com.example.ecommerceapi.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @GetMapping("/wishlist/{customerId}")
    public ResponseEntity<List<Item>> getWishlist(@PathVariable Long customerId) {
        List<Item> wishlist = wishlistService.getWishlist(customerId);
        return ResponseEntity.ok(wishlist);
    }
}