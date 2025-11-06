package com.example.lab1.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data

public class Product {
    private Long id;
    private String name;
    private String color;
    private Double price;
    private Date date;
}
