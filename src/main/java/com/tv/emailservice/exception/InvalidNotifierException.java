package com.tv.emailservice.exception;

public class InvalidNotifierException extends RuntimeException{
    public InvalidNotifierException(String message) {
        super(message);
    }
}
