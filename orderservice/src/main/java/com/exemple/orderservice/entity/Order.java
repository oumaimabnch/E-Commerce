package com.exemple.orderservice.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @Builder

public class Order {
    // @Id
    private String id;
    private String productId;
    private int quantity;
    @Enumerated (EnumType.STRING)
    private OrderStatus status ;
}