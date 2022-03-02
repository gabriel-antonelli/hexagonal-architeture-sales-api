package com.sales.api.usecase.exception;

import com.sales.api.domain.exception.SalesException;

public class ProductNotFoundException extends SalesException {
    public ProductNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
