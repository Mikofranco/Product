package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Setter
@Getter
public class AddProductRequest {
    private long userId;
    private String description;
    private BigDecimal price;
    private String name;
    private int quantity;
}
