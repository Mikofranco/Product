package org.example.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.data.model.Post;


public interface PostRepo extends JpaRepository<Post, Long> {
}
