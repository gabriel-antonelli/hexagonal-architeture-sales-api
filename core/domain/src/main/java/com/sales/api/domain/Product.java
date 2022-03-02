package com.sales.api.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
public class Product {
    @EqualsAndHashCode.Include
    private Integer id;
    private String description;
    private Double price;
    private Integer quantity;
    private LocalDateTime updateTime;

    @Builder
    public Product(Integer id, String description, Double price, Integer quantity, LocalDateTime updateTime) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.updateTime = updateTime;
    }
}
