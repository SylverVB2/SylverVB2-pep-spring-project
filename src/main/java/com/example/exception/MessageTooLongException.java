package com.example.exception;

public class MessageTooLongException extends RuntimeException {
    public MessageTooLongException(String message) {
        super(message);
    }
}
