package org.example.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
public class AddProductResponse {
    private long userId;
    private String userUsername;
    private String userEmail;
    private String description;
    private BigDecimal price;
    private String name;
    private int quantity;
}
