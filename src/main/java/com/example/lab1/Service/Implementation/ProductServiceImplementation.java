package com.example.lab1.Service.Implementation;

import com.example.lab1.Dto.ProductDto;
import com.example.lab1.Entity.ProductEntity;
import com.example.lab1.Repository.ProductRepository;
import com.example.lab1.Service.Exception.ProductNotFoundException;
import com.example.lab1.Service.Mapper.ProductMapper;
import com.example.lab1.Service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImplementation(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    @Transactional
    public List<ProductDto> getAll() {
        return productMapper.toDto(productRepository.findAll());
    }

    @Override
    @Transactional
    public ProductDto getById(UUID id) {
        return productMapper.toDto(productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id)));
    }

    @Override
    @Transactional
    public ProductDto save(ProductDto productDto) {
        productDto.setDate(new Date());
        return productMapper.toDto(productRepository.save(productMapper.toEntity(productDto)));
    }

    @Override
    @Transactional
    public ProductDto update(UUID id, ProductDto productDto) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        productEntity.setName(productDto.getName());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setColor(productDto.getColor());
        return productMapper.toDto(productRepository.save(productEntity));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        productRepository.deleteById(id);
    }
}
