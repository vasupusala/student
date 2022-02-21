package com.student.restservices.student.controller;

import com.student.restservices.student.errorhandlers.StudentNotFoundException;
import com.student.restservices.student.model.ErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class Validation extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(StudentNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        Map<String ,String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error)->{
//            String fieldName = ((FieldError) error).getField();
//            String message = error.getDefaultMessage();
//            errors.put(fieldName,message);
//        });
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed",
                ex.getBindingResult().toString());
        return new ResponseEntity<Object>(errorDetails,HttpStatus.BAD_REQUEST);
    }

}
