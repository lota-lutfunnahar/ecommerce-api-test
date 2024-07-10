package com.example.ecommerceapi.controller;

import com.example.ecommerceapi.model.Item;
import com.example.ecommerceapi.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class SalesController {


    @Autowired
    private SalesService salesService;

    @GetMapping("/sales/today")
    public ResponseEntity<BigDecimal> getTotalSalesToday() {
        log.info("Received request to get today's total sales");
        BigDecimal totalSales = salesService.getTotalSalesToday();
        if (totalSales == null) {
            log.warn("No sales data found for today");
            return ResponseEntity.noContent().build();
        }
        log.info("Total sales for today: {}", totalSales);
        return ResponseEntity.ok(totalSales);
    }

    @GetMapping("/sales/max")
    public ResponseEntity<LocalDate> getMaxSaleDay(@RequestParam(name = "startDate", required = false, defaultValue = "2024-07-01") String startDate,
                                                   @RequestParam(name = "endDate", required = false, defaultValue = "2024-07-31") String endDate)

    {
        log.info("Received request to get max sale day between {} and {}", startDate, endDate);
        LocalDate maxSaleDay = salesService.getMaxSaleDay(startDate, endDate);
        if (maxSaleDay == null) {
            log.warn("No sales data found between {} and {}", startDate, endDate);
            return ResponseEntity.noContent().build();
        }
        log.warn("Returning max sales values is {}", maxSaleDay);

        return ResponseEntity.ok(maxSaleDay);
    }

    @GetMapping("/sales/top5/all-time")
    public ResponseEntity<Map<String, Object>>  getTop5SellingItemsAllTime() {
        log.info("Received request to get top 5 selling items of all time");
        List<Item> top5SellingItems = salesService.getTop5SellingItemsAllTime();
        if (top5SellingItems == null || top5SellingItems.isEmpty()) {
            log.warn("No top selling items found for all time");
            return ResponseEntity.noContent().build();
        }
        Map<String, Object> response = new HashMap<>();
        response.put("data", top5SellingItems);

        log.info("Returning top 5 selling items of all time {}", response);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/sales/top5/last-month")
    public  ResponseEntity<Map<String, Object>>  getTop5SellingItemsLastMonth() {
        log.info("Received request to get top 5 selling items of the last month");
        List<Item> top5SellingItems = salesService.getTop5SellingItemsLastMonth();
        if (top5SellingItems == null || top5SellingItems.isEmpty()) {
            log.warn("No top selling items found for the last month");
            return ResponseEntity.noContent().build();
        }
        Map<String, Object> response = new HashMap<>();
        response.put("data", top5SellingItems);
        log.info("Returning top 5 selling items of the last month {}", response);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}