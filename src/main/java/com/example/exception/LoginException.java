package com.example.exception;

public class LoginException extends IllegalArgumentException {
    public LoginException(String message) {
        super(message);
    }
}