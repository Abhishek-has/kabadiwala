package com.user.authservice.controller;

import com.user.authservice.dao.ErrorResponse;
import com.user.authservice.exceptions.ResourseNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourseNotFound.class)
    public ResponseEntity<ErrorResponse> resourceNotFound (ResourseNotFound e){
        ErrorResponse errorResponse=new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Resourse Not Found",
                e.getMessage()
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> resourceNotFound (Exception e){
        ErrorResponse errorResponse=new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "somthing went wrong",
                e.getMessage()
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
