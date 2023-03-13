package com.internal.visit.controller

import com.internal.visit.exception.DataNotFound
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class GlobalException {

    @ExceptionHandler(DataNotFound.class)
    ResponseEntity<String> dataNotFound(Exception ex, WebRequest request) {
        System.out.println(ex.getMessage())
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
