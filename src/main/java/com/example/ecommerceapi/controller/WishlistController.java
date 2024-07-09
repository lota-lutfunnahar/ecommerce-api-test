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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api")
public class WishlistController {

    private static final Logger logger = LoggerFactory.getLogger(WishlistController.class);


    @Autowired
    private WishlistService wishlistService;

    @GetMapping("/wishlist/{customerId}")
    public ResponseEntity<Map<String, Object>> getWishlist(@PathVariable Long customerId) {
        logger.info("Received request to get wishlist for customer with ID: {}", customerId);
        List<Item> wishlist = wishlistService.getWishlist(customerId);
        Map<String, Object> response = new HashMap<>();
        response.put("data", wishlist);

        logger.info("Returning wishlist for customer with ID: {}", customerId);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }
}