package com.example.lab1.Service.Mapper;

import com.example.lab1.Dto.CartDto;
import com.example.lab1.Entity.CartEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = CartEntryMapper.class)
public interface CartMapper {
    CartDto toDto(CartEntity entity);

    List<CartDto> toDto(List<CartEntity> entities);

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    CartEntity toEntity(CartDto dto);
}
