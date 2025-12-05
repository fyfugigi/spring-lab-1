package com.example.lab1.Controller;

import com.example.lab1.Dto.CartEntryDto;
import com.example.lab1.Service.CartEntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/entries")
public class CartEntryController {
    private final CartEntryService cartEntryService;

    public CartEntryController(CartEntryService cartEntryService) {
        this.cartEntryService = cartEntryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartEntryDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(cartEntryService.getById(id));
    }

    @PostMapping
    public ResponseEntity<CartEntryDto> create(@RequestBody CartEntryDto cartEntryDto) {
        return ResponseEntity.ok(cartEntryService.create(cartEntryDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        cartEntryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
