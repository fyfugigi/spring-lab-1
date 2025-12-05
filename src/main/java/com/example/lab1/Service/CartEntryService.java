package com.example.lab1.Service;

import com.example.lab1.Dto.CartEntryDto;

import java.util.UUID;

public interface CartEntryService {
    CartEntryDto getById(UUID id);

    CartEntryDto create(CartEntryDto cartEntryDto);

    void delete(UUID id);
}
