package com.sales.api.config;

import com.sales.api.usecase.FindAllSales;
import jakarta.inject.Inject;
import org.glassfish.hk2.api.Factory;

public class FindAllSalesFactory implements Factory<FindAllSales> {

    private final FindAllSales findAllSales;

    @Inject
    public FindAllSalesFactory(FindAllSales findAllSales) {
        this.findAllSales = findAllSales;
    }

    @Override
    public FindAllSales provide() {
        return findAllSales;
    }

    @Override
    public void dispose(FindAllSales findAllSales) {
    }
}
