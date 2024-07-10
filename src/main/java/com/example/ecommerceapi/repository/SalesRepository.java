package com.example.ecommerceapi.repository;

import com.example.ecommerceapi.model.Item;
import com.example.ecommerceapi.model.Sale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface SalesRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT SUM(s.quantity * i.price) FROM Sale s JOIN Item i ON s.itemId = i.id WHERE s.saleDate = :date")
    BigDecimal findTotalSalesByDate(@Param("date") LocalDate date);

    @Query("SELECT s.saleDate FROM Sale s JOIN Item i ON s.itemId = i.id WHERE s.saleDate BETWEEN :startDate AND :endDate GROUP BY s.saleDate ORDER BY SUM(s.quantity * i.price) DESC LIMIT 1")
    LocalDate findMaxSaleDay(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT i FROM Sale s JOIN Item i ON s.itemId = i.id GROUP BY i.id ORDER BY SUM(s.quantity * i.price) DESC LIMIT 5")
    List<Item> findTop5SellingItemsAllTime();

    @Query("SELECT i FROM Sale s JOIN Item i ON s.itemId = i.id WHERE s.saleDate BETWEEN :startDate AND :endDate GROUP BY i.id ORDER BY SUM(s.quantity) DESC LIMIT 5")
    List<Item> findTop5SellingItemsByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
