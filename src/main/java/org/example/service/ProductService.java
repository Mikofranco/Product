package org.example.service;

import org.example.data.model.Product;

import java.math.BigDecimal;

public interface ProductService {
    Product add(String name, String description, BigDecimal price, int quantity);
    void delete(long productId);
    Product updateQuantity(long productId, int quantity);
}
