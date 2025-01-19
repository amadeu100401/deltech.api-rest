package http.controllers;

import http.common.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHolder {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        var message = e.getMessage();
        var response = new ErrorResponse(message, e.getCause().toString());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
