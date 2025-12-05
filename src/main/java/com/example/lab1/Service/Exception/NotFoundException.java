package com.example.lab1.Service.Exception;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    private static final String NOT_FOUND_EXCEPTION = "%s with id %s not found";

    public NotFoundException(String type, UUID id) {
        super(String.format(NOT_FOUND_EXCEPTION, type, id));
    }
}
