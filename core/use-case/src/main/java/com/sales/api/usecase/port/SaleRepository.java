package com.sales.api.usecase.port;

import com.sales.api.domain.Sale;

import java.util.List;
import java.util.Optional;

public interface SaleRepository {

    Sale create(Sale sale);

    void delete(Integer id);

    Optional<Sale> findById(Integer id);

    Optional<List<Sale>> findAll();
}
