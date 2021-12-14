package com.epam.exception;

public class TagNotFoundException extends RuntimeException {

    public TagNotFoundException(Long id) {
        super("Tag is not found by this id: "+id);
    }

    public TagNotFoundException(String name) {
        super("Tag is not found by this name: "+name);
    }
}
