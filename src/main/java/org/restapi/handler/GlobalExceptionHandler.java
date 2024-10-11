package org.restapi.handler;

import org.restapi.dto.ErrorResponse;
import org.restapi.exception.ProductOutOfStockException;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductOutOfStockException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler() {
        ErrorResponse exception = new ErrorResponse();
        exception.setErrorCode("404");
        exception.setErrorMessage("product out of stock");
        return new ResponseEntity<>(exception, HttpStatus.OK);
    }
}
