package com.example.ecommerceapi.controller;

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
