package com.sales.api.domain.exception;

public class NoQuantityException extends SalesException {
    public NoQuantityException(String errorMessage) {
        super(errorMessage);
    }
}
