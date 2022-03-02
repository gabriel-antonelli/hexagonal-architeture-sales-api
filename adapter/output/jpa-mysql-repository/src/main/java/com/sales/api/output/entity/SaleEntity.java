package com.sales.api.output.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "SALES")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@IdClass(SaleId.class)
public class SaleEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Column(name = "TOTAL_PRICE")
    private Double totalPrice;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Id
    @Column(name = "TRANSACTION_DT")
    private LocalDateTime transactionTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleEntity that = (SaleEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(productId, that.productId) && Objects.equals(totalPrice, that.totalPrice) && Objects.equals(quantity, that.quantity) && Objects.equals(transactionTime, that.transactionTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, totalPrice, quantity, transactionTime);
    }
}
