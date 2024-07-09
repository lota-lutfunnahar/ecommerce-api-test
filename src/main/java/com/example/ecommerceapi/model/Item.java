package com.example.ecommerceapi.model;
import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    public Item(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    public Item(long l, String itemE, double v) {
    }
}
