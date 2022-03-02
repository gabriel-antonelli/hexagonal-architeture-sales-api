package com.sales.api.usecase;

import com.sales.api.domain.Sale;
import com.sales.api.usecase.exception.SaleNotFoundException;
import com.sales.api.usecase.port.SaleRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class FindSale {

    private final SaleRepository saleRepository;

    @Inject
    public FindSale(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public Sale findById(Integer id) {
        return saleRepository.findById(id)
                .orElseThrow(() ->
                        new SaleNotFoundException("No sale found with id: " + id)
                );
    }
}
