package com.example.ecommerceapi.controller;

import com.example.ecommerceapi.model.Item;
import com.example.ecommerceapi.service.SalesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
    @Test
    public void testGetMaxSaleDay() throws Exception {
        LocalDate maxSaleDay = LocalDate.of(2024, 1, 15);
        Mockito.when(salesService.getMaxSaleDay("2024-01-01", "2024-01-31")).thenReturn(maxSaleDay);

        mockMvc.perform(get("/api/sales/max?startDate=2024-01-01&endDate=2024-01-31"))
                .andExpect(status().isOk())
                .andExpect(content().string(maxSaleDay.toString()));
    }

    @Test
    public void testGetTop5SellingItemsAllTime() throws Exception {
        List<Item> top5Items = Arrays.asList(
                new Item(1L, "Item A", 10.00),
                new Item(2L, "Item B", 20.00),
                new Item(3L, "Item C", 30.00),
                new Item(4L, "Item D", 40.00),
                new Item(5L, "Item E", 50.00)
        );

        Mockito.when(salesService.getTop5SellingItemsAllTime()).thenReturn(top5Items);

        mockMvc.perform(get("/api/sales/top5/all-time"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetTop5SellingItemsLastMonth() throws Exception {
        List<Item> top5ItemsLastMonth = Arrays.asList(
                new Item(1L, "Item A", 10.00),
                new Item(2L, "Item B", 20.00),
                new Item(3L, "Item C", 30.00),
                new Item(4L, "Item D", 40.00),
                new Item(5L, "Item E", 50.00)
        );

        Mockito.when(salesService.getTop5SellingItemsLastMonth()).thenReturn(top5ItemsLastMonth);

        mockMvc.perform(get("/api/sales/top5/last-month"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(5));
    }
}
