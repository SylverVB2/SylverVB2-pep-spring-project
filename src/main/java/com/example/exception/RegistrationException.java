package com.example.exception;

public class RegistrationException extends IllegalArgumentException {
    public RegistrationException(String message) {
        super(message);
    }
}