package com.example.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.inventoryservice.entity.Product;
import com.example.inventoryservice.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final InventoryRepository inventoryRepository;

    @Override
    public void run(String... args) {
        if (inventoryRepository.count() == 0) {
            inventoryRepository.save(new Product("p1", 100, "Electronics"));
            inventoryRepository.save(new Product("p2", 200, "Clothing"));
            inventoryRepository.save(new Product("p3", 150,"Books"));
        }
    }
}
