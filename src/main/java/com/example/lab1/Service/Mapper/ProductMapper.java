package com.example.lab1.Service.Mapper;

import com.example.lab1.Dto.ProductDto;
import com.example.lab1.Entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    ProductEntity toEntity(ProductDto productDto);

    ProductDto toDto(ProductEntity productEntity);

    List<ProductDto> toDto(List<ProductEntity> productEntityList);
}