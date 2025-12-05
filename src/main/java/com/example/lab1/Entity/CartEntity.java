package com.example.lab1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "carts")

public class CartEntity {
    @Id
    @Column(nullable = false, unique = true)
    private UUID id;

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CartEntryEntity> cartEntries;

}
