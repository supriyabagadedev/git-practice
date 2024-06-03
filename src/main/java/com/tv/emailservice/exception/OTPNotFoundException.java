package com.tv.emailservice.exception;

public class OTPNotFoundException extends RuntimeException{
    public OTPNotFoundException(String message) {
        super(message);
    }
}
