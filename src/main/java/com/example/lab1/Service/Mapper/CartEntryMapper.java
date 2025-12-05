package com.example.lab1.Service.Mapper;

import com.example.lab1.Dto.CartEntryDto;
import com.example.lab1.Entity.CartEntryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface CartEntryMapper {

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "cartId", source = "cart.id")
    CartEntryDto toDto(CartEntryEntity entity);

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "product.id", source = "productId")
    @Mapping(target = "cart.id", source = "cartId")
    CartEntryEntity toEntity(CartEntryDto dto);
}
