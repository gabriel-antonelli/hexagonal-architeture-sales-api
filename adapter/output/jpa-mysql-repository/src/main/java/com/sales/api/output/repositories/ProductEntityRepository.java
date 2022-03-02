package com.sales.api.output.repositories;

import com.sales.api.output.entity.ProductEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Named
@ApplicationScoped
public class ProductEntityRepository {
    private final EntityManager entityManager;

    @Inject
    public ProductEntityRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean existsById(Integer id) {
        return entityManager.find(ProductEntity.class, id) != null;
    }

    @Transactional
    public void updateQuantityById(Integer id, Integer quantitySold) {
        entityManager.createNativeQuery("UPDATE PRODUCTS SET QUANTITY = QUANTITY - :quantitySold WHERE ID = :id", ProductEntity.class)
                .setParameter("quantitySold", quantitySold)
                .setParameter("id", id)
                .executeUpdate();
    }
}
