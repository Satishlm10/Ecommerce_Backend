package com.SmProjects.dreamshops.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDto {
    private Long ProductId;
    private String ProductName;
    private int quantity;
    private BigDecimal price;

}
