package org.example.data.repo;

import org.example.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User>findByEmailAndPassword(String email, String password);
}
