package com.example.ecommerceapi.controller;


@Test
public void testGetTotalSalesToday() throws Exception {
    mockMvc.perform(get("/api/sales/today"))
            .andExpect(status().isOk())
            .andExpect(content().string("1000.00")); // assuming today's sales is 1000.00
}