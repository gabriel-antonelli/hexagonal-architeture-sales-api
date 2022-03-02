package com.sales.api.usecase.exception;

import com.sales.api.domain.exception.SalesException;

public class SaleNotFoundException extends SalesException {
    public SaleNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
