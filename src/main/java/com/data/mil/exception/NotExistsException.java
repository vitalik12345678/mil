package com.data.mil.exception;

public class NotExistsException extends IllegalArgumentException{

    private static final String MESSAGE = "Not exists";

    public NotExistsException() {
        super(MESSAGE);
    }

    public NotExistsException(String message) {
        super(message.isEmpty() ? MESSAGE : message);
    }

}
