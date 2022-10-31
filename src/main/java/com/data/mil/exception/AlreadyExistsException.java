package com.data.mil.exception;

public class AlreadyExistsException extends IllegalArgumentException{

    private static final long serialVersionUID = 8884242L;
    private static final String ALREADY_EXISTS_EXCEPTION = "Something already exists ";

    public AlreadyExistsException(String message) {
        super((message == null || message.isEmpty()) ? ALREADY_EXISTS_EXCEPTION : message);
    }

    public AlreadyExistsException() {
        super(ALREADY_EXISTS_EXCEPTION);
    }

}
