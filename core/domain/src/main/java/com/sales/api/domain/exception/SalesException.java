package com.sales.api.domain.exception;

public class SalesException extends RuntimeException{

    public SalesException(final String errorMessage){
        super(errorMessage);
    }
}
