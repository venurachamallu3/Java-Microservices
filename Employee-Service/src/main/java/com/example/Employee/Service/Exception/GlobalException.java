package com.example.Employee.Service.Exception;

import jakarta.persistence.Column;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;


@ControllerAdvice
public class GlobalException extends RuntimeException{

    @ExceptionHandler(IDNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleIDNotFoundException(Exception e , WebRequest webRequest){
        ErrorMessage em = new ErrorMessage(LocalDateTime.now(),e.getMessage(),webRequest.getDescription(false));
        return  new ResponseEntity<>(em, HttpStatus.NOT_FOUND);
    }
}
