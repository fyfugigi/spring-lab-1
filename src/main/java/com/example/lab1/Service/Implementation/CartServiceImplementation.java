package com.example.lab1.Service.Implementation;

import com.example.lab1.Dto.CartDto;
import com.example.lab1.Repository.CartRepository;
import com.example.lab1.Service.CartService;
import com.example.lab1.Service.Exception.NotFoundException;
import com.example.lab1.Service.Mapper.CartMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartServiceImplementation implements CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    public CartServiceImplementation(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    @Override
    public List<CartDto> getAll() {
        return cartMapper.toDto(cartRepository.findAll());
    }

    @Override
    public CartDto getById(UUID id) {
        return cartMapper.toDto(cartRepository.findById(id).orElseThrow(() -> new NotFoundException("Cart", id)));
    }

    @Override
    public CartDto create() {
        CartDto cartDto = new CartDto();
        return cartMapper.toDto(cartRepository.save(cartMapper.toEntity(cartDto)));
    }

    @Override
    public void deleteById(UUID id) {
        cartRepository.deleteById(id);
    }
}
