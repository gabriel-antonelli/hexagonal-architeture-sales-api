package com.sales.api.output.repositories;

import com.sales.api.output.entity.SaleEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Named
@ApplicationScoped
public class SaleEntityRepository {

    private final EntityManager entityManager;

    @Inject
    public SaleEntityRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(SaleEntity entity) {
        entityManager.persist(entity);
    }

    @Transactional
    public void deleteById(Integer id) {
        SaleEntity saleEntity = entityManager.find(SaleEntity.class, id);
        entityManager.remove(saleEntity);
    }

    public Optional<SaleEntity> findAllById(Integer id) {
        return Optional.ofNullable(
                entityManager.find(SaleEntity.class, id)
        );
    }
    public Optional<List<SaleEntity>> findAll(){
        return Optional.ofNullable(entityManager.createQuery("FROM " +
                SaleEntity.class.getName(), SaleEntity.class).getResultList());
    }
}
