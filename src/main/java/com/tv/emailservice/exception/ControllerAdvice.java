package com.tv.emailservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidationExceptions(MethodArgumentNotValidException ex) {
        log.error("Exception: ", ex);
        return ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
    }

    @ExceptionHandler(OTPNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleOTPNotFoundException(OTPNotFoundException ex) {
        log.error("Exception: ", ex);
        return ex.getMessage();
    }

    @ExceptionHandler(AmountNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleAmountNotFoundException(AmountNotFoundException ex) {
        log.error("Exception: ", ex);
        return ex.getMessage();
    }

    @ExceptionHandler(InvalidOTPException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidOTPException(InvalidOTPException ex) {
        log.error("Exception: ", ex);
        return ex.getMessage();
    }

    @ExceptionHandler(InvalidAmountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidAmountException(InvalidAmountException ex) {
        log.error("Exception: ", ex);
        return ex.getMessage();
    }
}
