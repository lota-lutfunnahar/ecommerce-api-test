package com.example.ecommerceapi.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(SalesController.class)
public class SalesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SalesService salesService;

    @Test
    public void testGetTotalSalesToday() throws Exception {
        Mockito.when(salesService.getTotalSalesToday()).thenReturn(BigDecimal.valueOf(1000.00));

        mockMvc.perform(get("/api/sales/today"))
                .andExpect(status().isOk())
                .andExpect(content().string("1000.0"));
    }
}
