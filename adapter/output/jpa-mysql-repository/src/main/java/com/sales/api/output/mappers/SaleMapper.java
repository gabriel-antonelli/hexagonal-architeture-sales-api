package com.sales.api.output.mappers;

import com.sales.api.domain.Sale;
import com.sales.api.output.entity.SaleEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class SaleMapper {

    public Sale toDomain(final SaleEntity saleEntity) {
        return Sale.builder()
                .id(saleEntity.getId())
                .productId(saleEntity.getProductId())
                .quantity(saleEntity.getQuantity())
                .totalPrice(saleEntity.getTotalPrice())
                .transactionTime(saleEntity.getTransactionTime())
                .build();
    }

    public SaleEntity toEntity(Sale sale) {
        return SaleEntity.builder()
                .id(sale.getId())
                .productId(sale.getProductId())
                .quantity(sale.getQuantity())
                .totalPrice(sale.getTotalPrice())
                .transactionTime(sale.getTransactionTime())
                .build();
    }

    public List<Sale> toDomainList(final List<SaleEntity> saleEntities) {
        List<Sale> listOfSales = new ArrayList<>();

        saleEntities.forEach(item -> {
            Sale saleDomain = toDomain(item);
            listOfSales.add(saleDomain);
        });
        return listOfSales;
    }
}
