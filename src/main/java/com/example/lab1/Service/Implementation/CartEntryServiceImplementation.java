package com.example.lab1.Service.Implementation;

import com.example.lab1.Dto.CartEntryDto;
import com.example.lab1.Repository.CartEntryRepository;
import com.example.lab1.Service.CartEntryService;
import com.example.lab1.Service.Exception.NotFoundException;
import com.example.lab1.Service.Mapper.CartEntryMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartEntryServiceImplementation implements CartEntryService {

    private final CartEntryRepository cartEntryRepository;
    private final CartEntryMapper cartEntryMapper;

    public CartEntryServiceImplementation(CartEntryRepository cartEntryRepository, CartEntryMapper cartEntryMapper) {
        this.cartEntryRepository = cartEntryRepository;
        this.cartEntryMapper = cartEntryMapper;
    }

    @Override
    public CartEntryDto getById(UUID id) {
        return cartEntryMapper.toDto(cartEntryRepository.findById(id).orElseThrow(() -> new NotFoundException("Cart entry", id)));
    }

    @Override
    public CartEntryDto create(CartEntryDto cartEntryDto) {
        return cartEntryMapper.toDto(cartEntryRepository.save(cartEntryMapper.toEntity(cartEntryDto)));
    }

    @Override
    public void delete(UUID id) {
        cartEntryRepository.deleteById(id);
    }
}
