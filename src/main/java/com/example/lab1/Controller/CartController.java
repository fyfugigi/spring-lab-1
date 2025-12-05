package com.example.lab1.Controller;

import com.example.lab1.Dto.CartDto;
import com.example.lab1.Service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/carts")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<List<CartDto>> getAll() {
        return ResponseEntity.ok(cartService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDto> getCartById(@PathVariable UUID id) {
        return ResponseEntity.ok(cartService.getById(id));
    }

    @PostMapping
    public ResponseEntity<CartDto> createCart() {
        return ResponseEntity.ok(cartService.create());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartById(@PathVariable UUID id) {
        cartService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
