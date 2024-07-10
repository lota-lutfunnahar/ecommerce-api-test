package com.example.ecommerceapi.service;

import com.example.ecommerceapi.model.Item;
import com.example.ecommerceapi.repository.SalesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class SalesService {
    @Autowired
    private SalesRepository saleRepository;

    public BigDecimal getTotalSalesToday() {

        log.info("Request param are {}", LocalDate.now());
        return saleRepository.findTotalSalesByDate(LocalDate.now());
    }

    public LocalDate getMaxSaleDay(String startDate, String endDate) {
        return saleRepository.findMaxSaleDay(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }

    public List<Item> getTop5SellingItemsAllTime() {
        return saleRepository.findTop5SellingItemsAllTime();
    }

    public List<Item> getTop5SellingItemsLastMonth() {
        LocalDate now = LocalDate.now();
        LocalDate startDate = now.minusMonths(1).withDayOfMonth(1);
        LocalDate endDate = now.withDayOfMonth(1).minusDays(1);
        log.info("Request param are {} {}", startDate, endDate);
        return saleRepository.findTop5SellingItemsByDateRange(startDate, endDate);
    }
}
