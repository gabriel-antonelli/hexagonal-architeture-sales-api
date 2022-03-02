package com.sales.api.usecase.port;

public interface ProductRepository {

    boolean exists(Integer id);

    void updateQuantity(Integer id, Integer quantitySold);
}
