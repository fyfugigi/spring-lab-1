package com.example.lab1.Service;

import com.example.lab1.Dto.ProductDto;
import com.example.lab1.Entity.ProductEntity;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductDto> getAll();

    ProductDto getById(UUID id);

    ProductDto save(ProductDto productDto);

    ProductDto update(UUID id, ProductDto productDto);

    void delete(UUID id);

}