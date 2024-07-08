package com.example.ecommerceapi.controller;

import com.example.ecommerceapi.model.Item;
import com.example.ecommerceapi.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping("/sales/today")
    public ResponseEntity<BigDecimal> getTotalSalesToday() {
        BigDecimal totalSales = salesService.getTotalSalesToday();
        return ResponseEntity.ok(totalSales);
    }
    @GetMapping("/sales/max")
    public ResponseEntity<LocalDate> getMaxSaleDay(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        LocalDate maxSaleDay = salesService.getMaxSaleDay(startDate, endDate);
        return ResponseEntity.ok(maxSaleDay);
    }

    @GetMapping("/sales/top5/all-time")
    public ResponseEntity<List<Item>> getTop5SellingItemsAllTime() {
        List<Item> top5SellingItems = salesService.getTop5SellingItemsAllTime();
        return ResponseEntity.ok(top5SellingItems);
    }

    @GetMapping("/sales/top5/last-month")
    public ResponseEntity<List<Item>> getTop5SellingItemsLastMonth() {
        List<Item> top5SellingItems = salesService.getTop5SellingItemsLastMonth();
        return ResponseEntity.ok(top5SellingItems);
    }
}
