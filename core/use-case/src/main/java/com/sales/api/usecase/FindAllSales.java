package com.sales.api.usecase;

import com.sales.api.domain.Sale;
import com.sales.api.usecase.exception.SaleNotFoundException;
import com.sales.api.usecase.port.SaleRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@ApplicationScoped
public class FindAllSales {

    private final SaleRepository saleRepository;

    @Inject
    public FindAllSales(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> findAll() {
        return saleRepository.findAll()
                .orElseThrow(() ->
                        new SaleNotFoundException("No sales found")
                );
    }
}
