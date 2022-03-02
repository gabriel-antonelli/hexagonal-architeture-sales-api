package com.sales.api.output;

import com.sales.api.output.repositories.ProductEntityRepository;
import com.sales.api.usecase.port.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ApplicationScoped
class ProductEntityGateway implements ProductRepository {

    private final ProductEntityRepository productRepository;

    @Inject
    public ProductEntityGateway(ProductEntityRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean exists(Integer id) {
        return productRepository.existsById(id);
    }

    @Override
    public void updateQuantity(Integer id, Integer quantitySold) {
        productRepository.updateQuantityById(id, quantitySold);
    }
}
