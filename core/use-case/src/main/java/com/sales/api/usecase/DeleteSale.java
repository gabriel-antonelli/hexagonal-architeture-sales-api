package com.sales.api.usecase;

import com.sales.api.domain.Sale;
import com.sales.api.usecase.exception.SaleNotFoundException;
import com.sales.api.usecase.port.ProductRepository;
import com.sales.api.usecase.port.SaleRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Optional;

@Named
@ApplicationScoped
public class DeleteSale {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;

    @Inject
    public DeleteSale(final SaleRepository saleRepository, ProductRepository productRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
    }

    public void delete(final Integer id) {
        Optional<Sale> sale = saleRepository.findById(id);
        if (sale.isPresent()) {
            productRepository.updateQuantity(id, sale.get().getQuantity());
            saleRepository.delete(id);
        } else {
            throw new SaleNotFoundException("No sale with id " + id + " found");
        }
    }
}
