package com.multiclientwebsite.merchantAndProduct.exception;

public class NoSuchProductExistsException extends Exception {

    private static final long serialVersionUID = 1L;

    public NoSuchProductExistsException() {

    }

    public NoSuchProductExistsException(String message) {
        super(message);
    }
}
