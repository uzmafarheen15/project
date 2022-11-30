package com.multiclientwebsite.merchantAndProduct.exception;

public class NoSuchCustomerExistsException extends Exception {

    private static final long serialVersionUID = 1L;
    public NoSuchCustomerExistsException() {

    }

    public NoSuchCustomerExistsException(String message) {
        super(message);
    }
}
