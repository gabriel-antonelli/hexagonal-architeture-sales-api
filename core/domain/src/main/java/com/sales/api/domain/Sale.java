package com.sales.api.domain;

import com.sales.api.domain.exception.NoProductException;
import com.sales.api.domain.exception.NoPriceException;
import com.sales.api.domain.exception.NoQuantityException;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
public class Sale {
    @EqualsAndHashCode.Include
    private Integer id;
    private Integer productId;
    private Double totalPrice;
    private Integer quantity;
    private LocalDateTime transactionTime;

    @Builder
    public Sale(Integer id, Integer productId, Double totalPrice, Integer quantity, LocalDateTime transactionTime) {
        if(productId == null) {
            throw new NoProductException("Product cannot be null");
        }
        if(totalPrice == null) {
            throw new NoPriceException("Total sale price cannot be null");
        }
        if(quantity == null || quantity < 1) {
            throw new NoQuantityException("Sale quantity cannot be null or less than 1");
        }
        this.id = id;
        this.productId = productId;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.transactionTime = transactionTime;
    }
}
