package com.example.exception;

public class MessageBlankTextException extends RuntimeException {
    public MessageBlankTextException(String message) {
        super(message);
    }
}