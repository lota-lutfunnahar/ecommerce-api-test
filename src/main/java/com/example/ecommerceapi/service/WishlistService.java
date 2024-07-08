package com.example.ecommerceapi.service;

import com.example.ecommerceapi.model.Item;
import com.example.ecommerceapi.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public List<Item> getWishlist(Long customerId) {
        return wishlistRepository.findItemsByCustomerId(customerId);
    }
}