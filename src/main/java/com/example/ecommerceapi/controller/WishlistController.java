package com.example.ecommerceapi.controller;

import com.example.ecommerceapi.model.Item;
import com.example.ecommerceapi.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("/api")
@Slf4j
public class WishlistController {


    @Autowired
    private WishlistService wishlistService;

    @GetMapping("/wishlist/{customerId}")
    public ResponseEntity<Map<String, Object>> getWishlist(@PathVariable Long customerId) {
        log.info("Received request to get wishlist for customer with ID: {}", customerId);
        List<Item> wishlist = wishlistService.getWishlist(customerId);
        Map<String, Object> response = new HashMap<>();
        response.put("data", wishlist);

        log.info("Returning wishlist for customer with response: {}", response);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }
}