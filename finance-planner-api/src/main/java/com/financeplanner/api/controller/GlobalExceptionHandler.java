package com.financeplanner.api.controller;

import com.financeplanner.api.controller.model.ErrorModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Logger;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class.getName());

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorModel> handleUncaught(HttpServletRequest request, Exception exception) {
        LOGGER.severe(exception.getClass().getSimpleName() + ": " + exception.getMessage() + " (from: " + request.getRequestURI() + ")");
        exception.printStackTrace();
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, request, exception);
    }

    private ResponseEntity<ErrorModel> buildErrorResponse(HttpStatus httpStatus, HttpServletRequest request, Exception exception) {
        return ResponseEntity.status(httpStatus).body(new ErrorModel(httpStatus, request, exception));
    }
}
