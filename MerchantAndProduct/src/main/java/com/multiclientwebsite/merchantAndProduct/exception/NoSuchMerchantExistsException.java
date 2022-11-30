package com.multiclientwebsite.merchantAndProduct.exception;

import javax.xml.crypto.NoSuchMechanismException;

public class NoSuchMerchantExistsException extends Exception {

    private static final long serialVersionUID = 1L;

    public NoSuchMerchantExistsException() {

    }

    public NoSuchMerchantExistsException(String message) {
        super(message);
    }

}
