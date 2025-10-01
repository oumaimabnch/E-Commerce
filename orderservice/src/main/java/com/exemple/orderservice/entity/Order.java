package com.exemple.orderservice.entity;

import jakarta.persistence.*;

import lombok.*;

@Entity               
@Table(name = "orders") 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) 
    private String id;

    private String productId;

    private int quantity;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}