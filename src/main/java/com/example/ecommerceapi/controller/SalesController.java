package com.example.ecommerceapi.controller;

import com.example.ecommerceapi.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

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
}
