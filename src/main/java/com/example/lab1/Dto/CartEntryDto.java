package com.example.lab1.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CartEntryDto {
    private UUID id;

    @Range(min = 1, max = 100, message = "Quantity cannot exceed 100.")
    @NotBlank(message = "Quantity cannot be null.")
    private Integer quantity;

    @NotBlank(message = "Product cannot be null.")
    private UUID productId;

    @NotBlank(message = "Cart cannot be null.")
    private UUID cartId;
}
