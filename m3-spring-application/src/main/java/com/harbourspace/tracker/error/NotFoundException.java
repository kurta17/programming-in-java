package com.harbourspace.tracker.error;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException() {
        super("Not Found");
    }

}
