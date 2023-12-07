package org.example.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    @CreatedDate
    private LocalDateTime createdDate;
    @PrePersist
    public void setCreatedAt(){
        this.createdDate=LocalDateTime.now();
    }
}
