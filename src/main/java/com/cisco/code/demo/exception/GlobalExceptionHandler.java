package com.cisco.code.demo.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleBaseException(DataIntegrityViolationException e) {
        return new ResponseEntity<>("Data not good", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoDataFoundException.class)
    public ResponseEntity<Object> handleNoDataFoundException(NoDataFoundException e) {
        return new ResponseEntity<>("No Data found", HttpStatus.NOT_FOUND);
    }
}