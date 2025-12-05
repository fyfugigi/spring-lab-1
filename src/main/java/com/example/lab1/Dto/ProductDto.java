package com.example.lab1.Dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProductDto {

    private UUID id;

    @Length(min = 3, max = 100, message = "Name must 3 to 100 characters long.")
    private String name;

    @Length(min = 3, max = 50, message = "Color must 3 to 50 characters long.")
    private String color;

    @DecimalMax(value = "10000.0", message = "Price must be in range from 1 to 1000.")
    @DecimalMin(value = "1.0", message = "Price must be in range from 1 to 1000.")
    private Double price;

    private Date date;
}