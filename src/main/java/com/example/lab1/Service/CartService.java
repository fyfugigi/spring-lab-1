package com.example.lab1.Service;

import com.example.lab1.Dto.CartDto;

import java.util.List;
import java.util.UUID;

public interface CartService {
    List<CartDto> getAll();

    CartDto getById(UUID id);

    CartDto create();

    void deleteById(UUID id);
}
