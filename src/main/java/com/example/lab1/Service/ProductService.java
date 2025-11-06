package com.example.lab1.Service;

import com.example.lab1.Entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getById(Long id);

    Product save(Product product);

    Product update(Long id, Product product);

    void delete(Long id);

}
