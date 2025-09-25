package com.exemple.orderservice.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String productId;
    private int quantity;
}