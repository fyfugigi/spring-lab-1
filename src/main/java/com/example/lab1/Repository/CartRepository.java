package com.example.lab1.Repository;

import com.example.lab1.Entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartRepository extends JpaRepository<CartEntity, UUID> {
}
