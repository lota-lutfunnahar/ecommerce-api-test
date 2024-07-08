package com.example.ecommerceapi.repository;

import org.springframework.data.jpa.repository.Query;

public interface SalesRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT SUM(s.quantity * i.price) FROM Sale s JOIN Item i ON s.itemId = i.id WHERE s.saleDate = :date")
    BigDecimal findTotalSalesByDate(@Param("date") LocalDate date);
}
