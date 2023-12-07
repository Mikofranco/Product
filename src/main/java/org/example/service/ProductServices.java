package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.data.model.Product;
import org.example.data.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
@RequiredArgsConstructor
public class ProductServices implements ProductService{
    private final ProductRepo productRepo;
    @Override
    public Product add(String name, String description, BigDecimal price, int quantity) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);
        return productRepo.save(product);
    }

    @Override
    public void delete(long productId) {
        productRepo.deleteById(productId);
    }

    @Override
    public Product updateQuantity(long productId, int quantity) {
         var product = productRepo.findById(productId).orElseThrow();
         product.setQuantity(quantity);
         return productRepo.save(product);
    }
}
