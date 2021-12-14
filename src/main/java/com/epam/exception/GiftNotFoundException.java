package com.epam.exception;

public class GiftNotFoundException extends RuntimeException {

    public GiftNotFoundException(Long id) {
        super("Gift Certificate is not found by this id: "+id);
    }

    public GiftNotFoundException(String name) {
        super("Gift Certificate is not found by this name: "+name);
    }
}
