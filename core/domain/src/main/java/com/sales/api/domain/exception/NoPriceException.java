package com.sales.api.domain.exception;

public class NoPriceException extends SalesException {
    public NoPriceException(String errorMessage) {
        super(errorMessage);
    }
}
