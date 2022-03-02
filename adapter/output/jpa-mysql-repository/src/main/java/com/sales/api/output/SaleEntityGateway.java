package com.sales.api.output;

import com.sales.api.domain.Sale;
import com.sales.api.output.entity.SaleEntity;
import com.sales.api.output.mappers.SaleMapper;
import com.sales.api.output.repositories.SaleEntityRepository;
import com.sales.api.usecase.port.SaleRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;
import java.util.Optional;

@Named
@ApplicationScoped
class SaleEntityGateway implements SaleRepository {

    private final SaleEntityRepository saleEntityRepository;
    private final SaleMapper saleMapper;

    @Inject
    public SaleEntityGateway(SaleEntityRepository saleEntityRepository, SaleMapper saleMapper) {
        this.saleEntityRepository = saleEntityRepository;
        this.saleMapper = saleMapper;
    }

    @Override
    public Sale create(Sale sale) {
        SaleEntity entity = saleMapper.toEntity(sale);
        saleEntityRepository.save(entity);
        return sale;
    }

    @Override
    public void delete(Integer id) {
        saleEntityRepository.deleteById(id);
    }

    @Override
    public Optional<Sale> findById(Integer id) {
        return saleEntityRepository.findAllById(id).map(saleMapper::toDomain);
    }

    @Override
    public Optional<List<Sale>> findAll() {
        return saleEntityRepository.findAll().map(saleMapper::toDomainList);
    }
}
