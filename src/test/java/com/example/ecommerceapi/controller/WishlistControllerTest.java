package com.example.ecommerceapi.controller;

import com.example.ecommerceapi.model.Item;
import com.example.ecommerceapi.service.WishlistService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WishlistController.class)
public class WishlistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WishlistService wishlistService;

    @Test
    public void testGetWishlist() throws Exception {
        List<Item> wishlist = Arrays.asList(
                new Item(1L, "Item A", 10.00),
                new Item(2L, "Item B", 20.00),
                new Item(3L, "Item C", 30.00)
        );

        Mockito.when(wishlistService.getWishlist(1L)).thenReturn(wishlist);

        mockMvc.perform(get("/api/wishlist/1"))
                .andExpect(status().isOk());
    }
}