package com.sales.api.domain.exception;

public class NoProductException extends SalesException {
    public NoProductException(String errorMessage) {
        super(errorMessage);
    }
}
