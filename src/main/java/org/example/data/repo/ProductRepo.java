package org.example.data.repo;

import org.example.data.model.Product;
import org.example.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product>findByUser(User user);
}
