package com.example.lab1.Repository;

import com.example.lab1.Entity.CartEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartEntryRepository extends JpaRepository<CartEntryEntity, UUID> {
}
