package com.sales.api.usecase;

import com.sales.api.domain.Sale;
import com.sales.api.usecase.exception.ProductNotFoundException;
import com.sales.api.usecase.port.ProductRepository;
import com.sales.api.usecase.port.SaleRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@Named
@ApplicationScoped
public class CreateSale {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;

    @Inject
    public CreateSale(SaleRepository saleRepository, ProductRepository productRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
    }

    public Sale create(Sale sale) {
        Integer productId = sale.getProductId();
        if (productRepository.exists(productId)) {
            saleRepository.create(sale);
            productRepository.updateQuantity(productId, sale.getQuantity());
            return sale;
        }
        throw new ProductNotFoundException("No product: " + productId + " found.");
    }
}
